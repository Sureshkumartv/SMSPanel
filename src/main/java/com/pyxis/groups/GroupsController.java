/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.groups;

import com.pyxis.contacts.Contacts;
import com.pyxis.users.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewgroup")
public class GroupsController {

	@Autowired
	GroupsService groupsServiceImpl;

	public void setGroupsServiceImpl(GroupsServiceImpl groupsServiceImpl) {
		this.groupsServiceImpl = groupsServiceImpl;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAllGroups() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/groups/managegroups");
	}

	@RequestMapping(value = "getgroup", method = RequestMethod.GET)
	public ResponseEntity<Page<Groups>> fetchGroups(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****************************");
		Page<Groups> list = this.groupsServiceImpl.listRecords(page, size);
		return new ResponseEntity<Page<Groups>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "deletegroup", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteGroup(@RequestParam("id") Long id) {
		System.out.println("coming here ****************************");
		Boolean flag = Boolean.FALSE;
		this.groupsServiceImpl.deleteRecord(id);
		return new ResponseEntity<>(Boolean.TRUE,HttpStatus.OK);
	}

	@RequestMapping(value = "getallgroup", method = RequestMethod.GET)
	public ResponseEntity<List<Groups>> fetchAllGroups(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "15") int size) {
		System.out.println("coming here ****************************");
		List<Groups> list = this.groupsServiceImpl.allRecords();
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping("/savegroup")
	public @ResponseBody ResponseEntity<Boolean> saveRole(@RequestBody Groups s) {
		Boolean flag = Boolean.FALSE;
		if (null != s) {
			try {
				if (null != s.getGroupsno()) {
					this.groupsServiceImpl.updateRecord(s);
				} else {
					this.groupsServiceImpl.addRecord(s);
				}
				flag = Boolean.TRUE;
			} catch (Exception ex) {
				System.out.println("Exception while persisting user details : " + ex.getMessage());
			}
		}
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/saveuploadcontacts/{groupid}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> customUploads(@RequestPart(value = "file", required = false) MultipartFile excelFile,
			HttpServletRequest request, @PathVariable(value = "groupid") Integer groupId) throws IOException {
		List<Contacts> map = new ArrayList<>();
		try {
			map = groupsServiceImpl.saveUploadedContacts(excelFile, groupId);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<List<Contacts>>(map, HttpStatus.OK);
	}
}
