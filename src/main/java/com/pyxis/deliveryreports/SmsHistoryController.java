/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.resources.SmsHistoryResource;
import com.pyxis.utils.ObjectListToCSV;
import com.pyxis.utils.SMSPage;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewhistory")
public class SmsHistoryController {
	@Autowired
	SmsHistoryService smsHistoryServiceImpl;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAllSmsHistory() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/reports/sms/deliveryreports");
	}

	@RequestMapping(value = "gethistory", method = RequestMethod.GET)
	public ResponseEntity<Page<SmsHistory>> fetchAllHistory(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****gethistory************************");
		Page<SmsHistory> list = this.smsHistoryServiceImpl.listRecords(page, size, "excel");
		return new ResponseEntity<Page<SmsHistory>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "gethttpscheduled", method = RequestMethod.GET)
	public ResponseEntity<?> fetchAllHttpHistory(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****gethistory************************");
		SMSPage<ScheduledDto> list = this.smsHistoryServiceImpl.fetchHttpScheduledHistory(page, size);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "gethttphistory", method = RequestMethod.GET)
	public ResponseEntity<?> fetchhistory(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size , @RequestParam("date") Long dateMillis) {
		System.out.println("coming here ****gethistory************************");
		Date date = new Date(dateMillis);
		List<SmsHistory> list = this.smsHistoryServiceImpl.fetchHttpHistory(page, size, date);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "getexcelhistory", method = RequestMethod.GET)
	public ResponseEntity<List<SmsHistory>> fetchHistory(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam Integer excelsno) {
		System.out.println("coming here ****gethistory************************");
		List<SmsHistory> list = this.smsHistoryServiceImpl.fetchHistoryByExcelSno(page, size, excelsno);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "downloadexcelhistory", method = RequestMethod.GET)
	public void downloadHistory(@RequestParam(required=false) Integer excelsno,@RequestParam(required=false) Long dateMillis, HttpServletResponse response) {
		System.out.println("coming here ****gethistory************************");
		
		List<SmsHistory> list = new ArrayList<SmsHistory>();
		if(null != excelsno){
			list = this.smsHistoryServiceImpl.fetchHistoryByExcelSno(excelsno);
		} else if(null != dateMillis){
			Date date = new Date(dateMillis);
			list = this.smsHistoryServiceImpl.fetchHttpHistory(0, 0, date);
		}
		List<SmsHistoryResource> resultList = list.stream().map(SmsHistory :: getResource).collect(Collectors.toList());
		StringBuilder  contents = new StringBuilder("MOBILE, MESSAGE, SENDERID , INSERTEDDATE , DELIVEREDDATE, STATUS \r\n");
		contents.append(ObjectListToCSV.convertListToCSV(resultList, false,  "MOBILE", "MESSAGE", "SENDERID", "INSERTEDDATE", "DELIVEREDDATE", "STATUS" ));
		response.setContentType("image/png"); // in my example this
		response.setContentLength(contents.toString().getBytes().length);
		response.setHeader("Content-Disposition", "attachment; filename=reports.csv");
		try {
			FileCopyUtils.copy(new ByteArrayInputStream(contents.toString().getBytes()), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
