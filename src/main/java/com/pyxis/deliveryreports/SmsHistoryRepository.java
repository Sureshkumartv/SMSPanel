/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author suresh
 */
public interface SmsHistoryRepository extends JpaRepository<SmsHistory, Long> {

	SmsHistory findBySmsSno(int id) throws DataAccessException;

	@Query(value="SELECT * FROM `sms_message_details_history` a FORCE INDEX(IDX_SMS_EXCEL_SNO) WHERE a.`SMS_EXCEL_SNO` = ?1" , nativeQuery = true )
	List<SmsHistory> findByExcelSno(Integer excelsno);
	
	@Query(value="SELECT * FROM `sms_message_details_history` a FORCE INDEX(SMS_DATE, SMS_USERID) WHERE a.`SMS_EXCEL_SNO` is null AND DATE(a.`SMS_INSERT_DATE`) = DATE(?1) AND `SMS_UPLOADEDBY` = ?2" , nativeQuery = true )
	List<SmsHistory> findByInsertedDate(Date date, Long uploadedBy);
	
	@Query(value="SELECT * FROM `sms_message_details_history` a FORCE INDEX(IDX_SMS_EXCEL_SNO) WHERE a.`SMS_EXCEL_SNO` IS NULL AND SMS_UPLOADEDBY = ?1  ORDER BY ?#{#pageable}" , 
			countQuery="SELECT count(*) FROM `sms_message_details_history` a FORCE INDEX(IDX_SMS_EXCEL_SNO) WHERE a.`SMS_EXCEL_SNO` IS NULL AND SMS_UPLOADEDBY = ?1", nativeQuery = true )
	Page<SmsHistory> findHttpReports( Long userId, Pageable pageable);
	
	@Query(value="SELECT * FROM `sms_message_details_history` a FORCE INDEX(IDX_SMS_EXCEL_SNO) WHERE a.`SMS_EXCEL_SNO` IS NOT NULL AND SMS_UPLOADEDBY = ?1 ORDER BY ?#{#pageable}" , 
			countQuery="SELECT count(*)* FROM `sms_message_details_history` a FORCE INDEX(IDX_SMS_EXCEL_SNO) WHERE a.`SMS_EXCEL_SNO` IS NOT NULL AND SMS_UPLOADEDBY = ?1" , nativeQuery = true )
	Page<SmsHistory> findExcelReports(Long userId, Pageable pageable);
	
	
	
}
