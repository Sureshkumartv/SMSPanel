/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.pyxis.utils.SMSPage;

/**
 *
 * @author suresh
 */
public interface SmsHistoryService {

	Page<SmsHistory> listRecords(Integer page, Integer size, String type);

	List<SmsHistory> fetchHistoryByExcelSno(int page, int size, Integer excelsno);
	
	List<SmsHistory> fetchHistoryByExcelSno(Integer excelsno);

	List<SmsHistory> fetchHttpHistory(int page, int size, Date object);

	SMSPage<ScheduledDto> fetchHttpScheduledHistory(int pageNo, int pageSize);
}
