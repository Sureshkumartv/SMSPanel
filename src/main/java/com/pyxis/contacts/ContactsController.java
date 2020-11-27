/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.utils.FormRequestDetails;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewcontacts")
public class ContactsController {

	@Autowired
	ContactsService contactsServiceImpl;

	public void setContactsServiceImpl(ContactsServiceImpl contactsServiceImpl) {
		this.contactsServiceImpl = contactsServiceImpl;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAllContacts() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/groups/contacts/managecontacts");
	}

	@RequestMapping(value = "getcontacts", method = RequestMethod.GET)
	public ResponseEntity<Page<Contacts>> fetchAllContacts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam Long groupId) {
		System.out.println("coming here ****************************");
		Page<Contacts> list = this.contactsServiceImpl.listRecords(page, size, groupId);
		return new ResponseEntity<Page<Contacts>>(list, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "getcontacts", method = RequestMethod.GET)
//	public ResponseEntity<Page<Contacts>> fetchGroupContacts(@RequestParam Long groupId) {
//		System.out.println("coming here ****************************");
//		Page<Contacts> list = this.contactsServiceImpl.listRecords(groupId);
//		return new ResponseEntity<Page<Contacts>>(list, HttpStatus.OK);
//	}
	
	
	@RequestMapping(value = "allcontacts", method = RequestMethod.POST)
	public ResponseEntity<List<Contacts>> fetchContactsByGroup(@RequestBody FormRequestDetails requestBody) {
		System.out.println("coming here ****************************");
		List<Contacts> list = this.contactsServiceImpl.listRecords(requestBody.getIdsList());
		return new ResponseEntity<List<Contacts>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/savecontact", method= RequestMethod.POST)
	public @ResponseBody ResponseEntity<Boolean> saveContact(@RequestBody Contacts s) {
		Boolean flag = Boolean.FALSE;
		if (null != s) {
			try {
				this.contactsServiceImpl.addRecord(s);
				flag = Boolean.TRUE;
			} catch (Exception ex) {
				System.out.println("Exception while persisting user details : " + ex.getMessage());
			}
		}
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

}
