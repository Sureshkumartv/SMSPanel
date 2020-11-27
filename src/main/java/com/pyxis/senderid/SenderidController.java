/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pyxis.users.UserToken;
import com.pyxis.users.Users;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value = "/viewsenderids")
public class SenderidController {

    @Autowired
    private SenderidService senderidService;

    public void setSenderidService(SenderidServiceImpl senderidService) {
        this.senderidService = senderidService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAll() {
//        List<Senderid> list = this.senderidService.listRecords();
        return new ModelAndView("mainpages/senderid/managesenderids");
    }

    @RequestMapping("/addsenderid.htm")
    public ModelAndView showform() {
        return new ModelAndView("mainpages/senderid/addsenderids", "command", new Users());
    }

    @RequestMapping("/savesenderid.htm")
    public ModelAndView saveRole(@ModelAttribute("s") Senderid s) {
        this.senderidService.addRecord(s);
        return new ModelAndView("redirect:/viewsenderids.htm");
    }
    
    @RequestMapping("/savesenderid/{name}")
    public ModelAndView saveSender(@PathVariable("name") String id) {
    	Senderid s=new Senderid();
    	s.setSendername(id);
        this.senderidService.addRecord(s);
        return new ModelAndView("redirect:/viewsenderids.htm");
    }

    @RequestMapping(value = "/getsenderids", method = RequestMethod.GET)
    public ResponseEntity<Page<Senderid>> fetchAllSenderids(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        System.out.println("coming here ****************************");
        Page<Senderid> list = this.senderidService.listRecords(page, size);
        return new ResponseEntity<Page<Senderid>>(list, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/getallsenderids", method = RequestMethod.GET)
    public ResponseEntity<List<Senderid>> fetchAllSenderids() {
        System.out.println("coming here ****************************");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
        List<Senderid> list = this.senderidService.fetchUserSenderIds(user.getId().intValue());
        return new ResponseEntity<List<Senderid>>(list, HttpStatus.OK);
    }

}
