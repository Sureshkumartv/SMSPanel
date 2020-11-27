package com.pyxis.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.sms.SmsDetailService;
import com.pyxis.users.UserToken;

@Controller
public class DefaultController {

	@Autowired
	private SmsDetailService smsDetailsService;

	@GetMapping("/")
	public String home1() {
		System.out.println("home -------");
		return "/home";
	}

//	@GetMapping("/home")
//	public String home() {
//		return "/home";
//	}

	@GetMapping("/admin")
	public String admin() {
		return "/admin";
	}
	
	@GetMapping("/apidocs")
	public String apidocs() {
		return "/mainpages/api/manageapi";
	}
	
	
	@GetMapping("/testlogin")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		if(user.getUserType() != 4){
			return "redirect:viewuser.htm";
		} else{
			return "redirect:sendsms.htm";
		}
	}
	
	

	@GetMapping("/user")
	public String user() {
		return "/user";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/login")
	public String login() {
		return "login/home";
	}

	@GetMapping("/modalDialog")
	public String modalDialog() {
		return "modalDialog";
	}

	@GetMapping("/403")
	public String error403() {
		return "/error/403";
	}

	@RequestMapping(value = "/i/{imgid}", method = RequestMethod.GET)
	public ModelAndView getImagePage(@PathVariable("imgid") Integer imgId, HttpServletResponse response)
			throws IOException {
		System.out.println("coming here ****************************");
		ModelAndView view = new ModelAndView("mainpages/layout/image");
		view.addObject("image", "/display/"+imgId);
		return view;
	}

	@RequestMapping(value = "/display/{imgid}", method = RequestMethod.GET)
	public void getImage(@PathVariable("imgid") Integer imgId, HttpServletResponse response) throws IOException {
		try {
			byte[] imageData = smsDetailsService.getImage(imgId);
			response.setContentType("image/png");
			response.setContentLength(imageData.length);
			response.setHeader("Content-Disposition", "attachment; filename=image.png");

			try {
				FileCopyUtils.copy(new ByteArrayInputStream(imageData), response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/b/{imgid}", method = RequestMethod.GET)
	@ResponseBody
	public byte[] getImageBytes(@PathVariable("imgid") Integer imgId, HttpServletResponse response) throws IOException {
		try {
			byte[] imageData = smsDetailsService.getImage(imgId);
			// response.setContentType("image/png");
			// response.setContentLength(imageData.length);
			// response.setHeader("Content-Disposition", "attachment;
			// filename=image.png");
			return imageData;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

}
