/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewscheduled")
public class ScheduledController {

	@Autowired
	ScheduledService scheduledServiceImpl;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAllScheduled() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/reports/files/managescheduled");
	}

	@RequestMapping(value = "getscheduled", method = RequestMethod.GET)
	public ResponseEntity<Page<Scheduled>> fetchAllContacts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****************************");
		Page<Scheduled> list = this.scheduledServiceImpl.listRecords(page, size);
		return new ResponseEntity<Page<Scheduled>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "getapischeduled", method = RequestMethod.GET)
	public ResponseEntity<Page<Scheduled>> fetchApiScheduled(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****************************");
		Page<Scheduled> list = this.scheduledServiceImpl.listRecords(page, size);
		return new ResponseEntity<Page<Scheduled>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void downloadAll(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("coming here ****************************");
		List<Scheduled> list = this.scheduledServiceImpl.listAllRecords();
		String contents = list.toString();
		response.setContentType("image/png"); // in my example this
		response.setContentLength(contents.getBytes().length);
		response.setHeader("Content-Disposition", "attachment; filename=reports.csv");
		try {
			FileCopyUtils.copy(new ByteArrayInputStream(contents.getBytes()), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
