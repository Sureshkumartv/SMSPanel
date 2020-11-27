/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.groups;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.srisairam.sms.files.CSVFileReader;
import org.srisairam.sms.files.ExcelFileReader;
import org.srisairam.sms.files.ExcelXFileReader;
import org.srisairam.sms.files.PanelFileReader;

import com.pyxis.contacts.Contacts;
import com.pyxis.contacts.ContactsRepository;
import com.pyxis.users.UserToken;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GroupsServiceImpl implements GroupsService {

	private static Logger logger = Logger.getLogger("StoreUploadFile");

    @Autowired
    ContactsRepository contactsRepository;
    
	@Autowired
	GroupsRepository groupsRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value("${smsuploads.path}")
	String smsUploadsPath;
	
	public GroupsServiceImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	public GroupsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addRecord(Groups s) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		s.setCreatedby(user.getId());
		s.setCreateddate(new Date());
		this.groupsRepository.save(s);
	}

	@Override
	public void updateRecord(Groups s) {
		this.groupsRepository.save(s);
	}

	@Override
	public void deleteRecord(Long id) {
		Groups g = groupsRepository.findOne(id);
		if (null != g) {
			this.groupsRepository.delete(g);
		}
	}

	@Override
	public Groups getById(int id) {
		Groups s = this.groupsRepository.findOne(Long.valueOf(id));
		return s;
	}

	@Override
	public Page<Groups> listRecords(Integer page, Integer size) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "groupsno"));
		Page<Groups> groups = this.groupsRepository.findByCreatedby(user.getId(), pageable);

		return groups;
	}

	@Override
	public List<Groups> allRecords() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		String sql = "SELECT ug.*, COUNT(ugc.`CONTACTNO`) contactsCount FROM user_groups ug LEFT JOIN user_group_contacts ugc ON ug.`GROUPSNO` = ugc.`GROUPID` " 
					+" WHERE ug.`CREATEDBY` = ? GROUP BY ugc.`GROUPID`";
		List<Groups> groups = jdbcTemplate.query(sql, new Object[]{user.getId()}, new BeanPropertyRowMapper<>(Groups.class));
//		List<Groups> groups = this.groupsRepository.findByCreatedby(user.getId());
		return groups;
	}

	@Override
	public List<Contacts> saveUploadedContacts(MultipartFile excelFile, Integer groupId) {
		UserToken auth = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> map = new LinkedHashMap<>();
		File directory = new File(smsUploadsPath + "temp");
		if (!directory.exists()) {
			directory.mkdir();
		}
		String fileName = System.currentTimeMillis() + "_" + excelFile.getOriginalFilename();
		File file = new File(directory, fileName);
		System.out.println(file.getPath());
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			excelFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String uploadFileFileName = file.getName();
        PanelFileReader fileReader = null;
        List<Contacts> contactsList = new ArrayList<Contacts>();
        try {
            if (uploadFileFileName.toLowerCase().endsWith("xls")) {
                fileReader = new ExcelFileReader();

            } else if (uploadFileFileName.toLowerCase().endsWith("xlsx")) {
                fileReader = new ExcelXFileReader();

            } else {
                String seperator = null;
                if (uploadFileFileName.toLowerCase().endsWith("csv")) {
                    seperator = ",";
                }
                System.out.println("seperator===>" + seperator);
                fileReader = new CSVFileReader(seperator);
            }
            fileReader.openFile(file, true);
            ArrayList<Object> elemnts = fileReader.getNextLine();
            while (elemnts != null) {
                if (elemnts.size() > 0) {
                	Contacts contacts = new Contacts();
                	if(null == elemnts.get(0) || null == elemnts.get(1) ) {
                		elemnts = fileReader.getNextLine();
                	} else { 
                		contacts.setContactName(elemnts.get(0).toString());
                		contacts.setMsisdn(elemnts.get(1).toString());
                		contacts.setMailID(null != elemnts.get(2) ? elemnts.get(2).toString() : null);
                		contacts.setCreatedBy(auth.getId().toString());
                		contacts.setCreatedOn(new Date());
                		contacts.setGroupId(groupId.longValue());
                		contactsList.add(contacts);
                		elemnts = fileReader.getNextLine();
                	}
                }
            }
            contactsRepository.save(contactsList);

        } catch (Exception iOException) {
            logger.error(iOException, iOException);
        } finally {
            if (fileReader != null) {
                fileReader.closeFile();
            }
        }
		return contactsList;
	}

}
