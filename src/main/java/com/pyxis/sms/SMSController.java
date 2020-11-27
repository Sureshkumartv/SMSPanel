/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.entities.SmsDraft;
import com.pyxis.users.UserService;
import com.pyxis.users.UserServiceImpl;
import com.pyxis.users.UserToken;
import com.pyxis.users.Users;
import com.pyxis.utils.FormRequestDetails;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/sendsms")
public class SMSController {

	@Autowired
	private UserService userServiceImpl;

	@Autowired
	private ObjectMapper mapper;

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@Autowired
	SmsDetailService smsDetailsService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showAll() {
		System.out.println("coming here ****************************");
		return new ModelAndView("mainpages/layout/sendSMS");
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

	@RequestMapping(method = RequestMethod.POST, value = "/smsDetails")
	public ResponseEntity<SmsDetailsDto> updateContactInfo(@RequestBody SmsDetailsDto smsDetailsDto) {
		System.out.println("vaues are===" + smsDetailsDto.getSmsMsisdn() + "====" + smsDetailsDto.getSmsMessage());
		SmsDetailsDto sd = null;
		try {
			sd = smsDetailsService.saveRecord(smsDetailsDto);
		} catch (Exception ex) {
                    ex.printStackTrace();
			new ResponseEntity<SmsDetailsDto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<SmsDetailsDto>(sd, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveupload", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> addExcelFileDetails(@RequestParam(value = "info") String userInfo,
			@RequestPart(value = "excelfile", required = false) MultipartFile excelFile, HttpServletRequest request)
			throws IOException {
		System.out.println("Inside add sms uploads" + userInfo);

		FileUploadCountsDto dto = null;
		Map<String, Object> map = new HashMap<>();
		try {
			dto = new FileUploadCountsDto();

			dto = mapper.readValue(userInfo, FileUploadCountsDto.class);
			System.out.println("Total count ::"+dto.getTotal());
			dto.setUploadedFile(excelFile);
			map = smsDetailsService.saveExcelFileDetails(dto);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/groupsms", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<FileUploadCountsDto> groupSMS(@RequestBody FormRequestDetails requestObject)
			throws IOException {
		System.out.println("Inside add sms uploads" + requestObject.getContacts());
		ObjectMapper mapper = new ObjectMapper();
		FileUploadCountsDto dto = null;
		try {
			dto = new FileUploadCountsDto();

			dto = smsDetailsService.saveGroupSMS(dto, requestObject.getContacts());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<FileUploadCountsDto>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/saveimage", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Integer> addExcelFileDetails(
			@RequestPart(value = "file", required = false) MultipartFile excelFile, HttpServletRequest request,
			@RequestParam(value = "type") Integer type) throws IOException {
		Integer dto = null;
		try {
			dto = smsDetailsService.saveImageUpload(excelFile, type);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@RequestMapping(value = "/drafts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SmsDraft>> fetchSmsDrafts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) throws IOException {
		List<SmsDraft> dto = null;
		try {
			dto = smsDetailsService.fetchSmsDraft();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@RequestMapping(value = "/savedraft", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<SmsDraft>> saveSmsDrafts(@RequestBody SmsDraft draft) throws IOException {
		List<SmsDraft> dto = null;
		try {
			smsDetailsService.saveDraft(draft);
			dto = smsDetailsService.fetchSmsDraft();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(dto, HttpStatus.OK);

	}

	@RequestMapping(value = "/customsms", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> customUploads(@RequestPart(value = "file", required = false) MultipartFile excelFile,
			HttpServletRequest request) throws IOException {
		Map<String, Object> map = new HashMap<>();
		try {
			map = smsDetailsService.saveCustomFileDetails(excelFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/previewsms", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> previewCustomSMS(@RequestBody SmsDetailsDto smsDetailsDto, HttpServletRequest request)
			throws IOException {
		ArrayList<ArrayList<Object>> list = new ArrayList<>();
		try {
			list = smsDetailsService.previewCustomSms(smsDetailsDto);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<ArrayList<ArrayList<Object>>>(list, HttpStatus.OK);
	}

}
