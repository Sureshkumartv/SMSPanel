/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.srisairam.http.HttpResponce;

import com.pyxis.entities.EsmeInfo;
import com.pyxis.entities.UserCreditsDetail;
import com.pyxis.panelapiclient.UserPanelClientImpl;
import com.pyxis.repositories.EsmeInfoRepository;
import com.pyxis.repositories.UserCreditsDetailRepository;
import com.pyxis.sms.SmsDetailServiceImpl;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAOImpl;

	@Autowired
	private EsmeInfoRepository esmeInfoRepository;
	
	@Autowired
	private UserCreditsDetailRepository userCreditsDetailRepository; 

	@Value("${http.user.panel.url}")
	private String httpUserpanelUrl;
	
	

	@Override
	@Transactional
	public void addRecord(Users s) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();

		s.setUsercreatedby(this.userDAOImpl.findOne(user.getId()));
		s.setUser_timezone("+5:30");
		s.setUserstatus(1);
		System.out.println("----TimeZone------:"+s.getUser_timezone());
		Users saved = this.userDAOImpl.save(s);
		this.userDAOImpl.updatePassword("Reset@123", saved.getUserid());
	}

	@Override
	public void updateRecord(Users id) {

		Users existing = userDAOImpl.findOne(id.getUserid());
		BeanUtils.copyProperties(id, existing, "password", "createdBy", "usercreatedby");
		this.userDAOImpl.save(existing);
	}

	@Override
	public void deleteRecord(int id) {
		Users s = getById(id);
		this.userDAOImpl.delete(s);
	}

	@Override
	public Users getById(int id) {
		Users s = this.userDAOImpl.findOne(Long.valueOf(id));
		return s;
	}

	@Override
	public Page<Users> listRecords(Integer page, Integer size) {
		UserToken user = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "userid"));
		Page<Users> users = null;
		switch (user.getUserType()) {
		case 0:
			users = userDAOImpl.findAll(pageable);
		case 1:
			users = userDAOImpl.findByUsertypeIn(Arrays.asList(new Integer[] { 2, 3, 4 }), pageable);
			break;
		case 2:
			users = userDAOImpl.findByUsertypeIn(Arrays.asList(new Integer[] { 3, 4 }), pageable);
			break;
		case 3:
			users = userDAOImpl.findByUsertypeAndUsercreatedbyUserid(4, user.getId(), pageable);
			break;
		default:
			users = userDAOImpl.findByUsercreatedbyUserid(user.getId(), pageable);
			break;
		}
		users.getContent()
				.forEach(e -> e.setUserCreditsDto(new UserCreditsDto(userDAOImpl.getUserSmsCount(e.getUserid()),
						userDAOImpl.getUserUsedCredits(e.getUserid()))));
		return users;
	}

	@Override
	public boolean hasRole(String role) {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.
		return false;
	}

	@Override
	public List<EsmeInfo> fetchEsmeInfo() {
		return esmeInfoRepository.findByStatusAndTransmitterGreaterThan(1, 0);
	}

	@Override
	public void submitCredits(UserCreditsDetail s) {
		logger.info("Adding credits to user credits detail :: {} ", s);
		UserToken user = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		s.setGivenby(user.getId().intValue());
		
		userCreditsDetailRepository.save(s);
		
		UserPanelClientImpl userPanelClient = new UserPanelClientImpl(httpUserpanelUrl, user.getUsername(), user.getPassword());
        try {
            HttpResponce responce = userPanelClient.addUsedCredits(s.getSmscount().longValue());
            if (responce != null) {
                logger.info("[CR][" + s.getUserDetail().getUserid() + "] [" + s.getSmscount() + "]Credits SucessFully Logged in PanelApi");
            }
        } catch (Exception ex) {
            logger.error( user.getId() + " {HTTPRESPONCE} ", ex);

        }
        userPanelClient.editUser(s.getUserDetail().getUserid() + "");
        logger.info("Adding credits to user credits detail completed :: {} ", s);
	}

}
