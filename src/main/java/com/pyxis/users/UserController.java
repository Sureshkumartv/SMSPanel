/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.entities.EsmeInfo;
import com.pyxis.entities.UserCreditsDetail;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewusers")
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAll() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/users/manageusers");
	}

	@RequestMapping(value = "getusers", method = RequestMethod.GET)
	public ResponseEntity<Page<Users>> fetchAllUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		System.out.println("coming here ****************************");
		Page<Users> list = this.userServiceImpl.listRecords(page, size);
		return new ResponseEntity<Page<Users>>(list, HttpStatus.OK);
	}

	@RequestMapping("/adduser")
	public ModelAndView showusersform() {
		return new ModelAndView("mainpages/users/addusers", "command", new Users());
	}

	@RequestMapping("/saveuser")
	public @ResponseBody ResponseEntity<Boolean> saveRole(@RequestBody Users s) {
		Boolean flag = Boolean.FALSE;
		if (null != s) {
			try {
				if (null != s.getUserid()) {
					this.userServiceImpl.updateRecord(s);
				} else {
					this.userServiceImpl.addRecord(s);
				}
				flag = Boolean.TRUE;
			} catch (Exception ex) {
				System.out.println("Exception while persisting user details : " + ex.getMessage());
			}
		}
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

	@RequestMapping(value = "/smslayout.htm", method = RequestMethod.GET)
	public ModelAndView smsLayout(@ModelAttribute("s") Users s) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		user.getUserType();
		Page<Users> list = this.userServiceImpl.listRecords(0, 10);
		return new ModelAndView("mainpages/layout/sendSMS", "list", list);
	}

	@RequestMapping(value = "getsmppids", method = RequestMethod.GET)
	public @ResponseBody List<EsmeInfo> fetchEsmeInfo() {
		System.out.println("coming here ****************************");
		List<EsmeInfo> list = this.userServiceImpl.fetchEsmeInfo();
		return list;
	}
	
	
	@RequestMapping(value = "submitcredits", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Boolean> sumbitCredits(@RequestBody UserCreditsDetail s) {
		Boolean flag = Boolean.FALSE;
		if (null != s) {
			try {
				this.userServiceImpl.submitCredits(s);
				flag = Boolean.TRUE;
			} catch (Exception ex) {
				System.out.println("Exception while persisting user details : " + ex.getMessage());
			}
		}
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}

}
