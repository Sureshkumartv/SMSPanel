/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pyxis.users.UserToken;
import com.pyxis.utils.PaginationHelper;
import com.pyxis.utils.SMSPage;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SmsHistoryServiceImpl implements SmsHistoryService {

	@Autowired
	SmsHistoryRepository smsHistoryRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

//	@Override
//	public Page<SmsHistory> listRecords(Integer page, Integer size) {
//		Pageable pageable = new PageRequest(page, size);
//		Page<SmsHistory> contacts = this.smsHistoryRepository.findAll(pageable);
//		return contacts;
//	}

	@Override
	public List<SmsHistory> fetchHistoryByExcelSno(int page, int size, Integer excelsno) {
		Pageable pageable = new PageRequest(page, size , new Sort(Direction.DESC, "SMS_INSERT_DATE"));
		List<SmsHistory> contacts = this.smsHistoryRepository.findByExcelSno(excelsno);
		return contacts;
	}

	@Override
	public Page<SmsHistory> listRecords(Integer page, Integer size, String type) {
		Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "SMS_INSERT_DATE"));
		UserToken user = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Page<SmsHistory> contacts = new PageImpl<>(new ArrayList<>());
		if(org.springframework.util.StringUtils.isEmpty(type)){
			contacts = this.smsHistoryRepository.findHttpReports( user.getId(), pageable);
		} else {
			contacts = this.smsHistoryRepository.findExcelReports(user.getId(), pageable);
		}
		return contacts;
	}
	
	@Override
	public List<SmsHistory> fetchHistoryByExcelSno(Integer excelsno) {
		List<SmsHistory> contacts = this.smsHistoryRepository.findByExcelSno(excelsno);
		return contacts;
	}
	
	@Override
	public SMSPage<ScheduledDto> fetchHttpScheduledHistory(int pageNo, int pageSize){
		UserToken user = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String countquery = " SELECT COUNT(*) FROM (SELECT  DISTINCT DATE(`SMS_INSERT_DATE`) SMS_INSERT_DATE, ud.username, `SENDERNAME` ,COUNT(*) FROM  "
				+" sms_message_details_history smdh FORCE INDEX(SMS_DATE, SMS_USERID, IDX_SMS_EXCEL_SNO)  "
				+" LEFT JOIN `user_details` ud ON  (smdh.`SMS_UPLOADEDBY` = ud.USERID)  "
				+" LEFT JOIN `senderid_detils` sd ON  (smdh.`SMS_SENDER_ID` = sd.`SENDERID`)  "
				+" WHERE SMS_EXCEL_SNO IS NULL AND `SMS_UPLOADEDBY` = ? "
				+" GROUP BY DATE(`SMS_INSERT_DATE`), SMS_UPLOADEDBY, `SMS_SENDER_ID` ) A " ;
		
		String sqlFetchRows = " SELECT  DISTINCT DATE(`SMS_INSERT_DATE`) INSERT_DATE, ud.username, `SENDERNAME` SENDER_ID ,COUNT(*) as 'count' FROM  "
				+" sms_message_details_history smdh FORCE INDEX(SMS_DATE, SMS_USERID, IDX_SMS_EXCEL_SNO)  "
				+" LEFT JOIN `user_details` ud ON  (smdh.`SMS_UPLOADEDBY` = ud.USERID)  "
				+" LEFT JOIN `senderid_detils` sd ON  (smdh.`SMS_SENDER_ID` = sd.`SENDERID`)  "
				+" WHERE SMS_EXCEL_SNO IS NULL AND `SMS_UPLOADEDBY` = ? "
				+" GROUP BY DATE(`SMS_INSERT_DATE`), SMS_UPLOADEDBY, `SMS_SENDER_ID` ORDER BY 1 DESC" ;
		
		PaginationHelper<ScheduledDto> helper = new PaginationHelper<>();
		SMSPage<ScheduledDto> list = helper.fetchPage(jdbcTemplate, countquery, sqlFetchRows, new Object[]{user.getId()}, pageNo, pageSize, new BeanPropertyRowMapper<>(ScheduledDto.class));
		return list;
		
	}

	@Override
	public List<SmsHistory> fetchHttpHistory(int page, int size, Date date) {
		UserToken user = (UserToken) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<SmsHistory> contacts = this.smsHistoryRepository.findByInsertedDate(date == null ? new Date() : date,user.getId() );
		return contacts;
	}

}
