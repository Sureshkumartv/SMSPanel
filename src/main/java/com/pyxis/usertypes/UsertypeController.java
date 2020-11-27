/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.usertypes;

import com.pyxis.users.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author suresh
 */
@Controller
@RequestMapping(value="/usertypes")
public class UsertypeController {

    @Autowired
    private UsertypeService usertypeServiceImpl;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showAll() {
        System.out.println("coming here ****************************");
//        List<Users> list = this.userServiceImpl.listRecords();
//        return new ModelAndView("mainpages/users/manageusers", "list", list);
        
        return new ModelAndView("mainpages/userstypes/manageusertypes");
    }
    
    @RequestMapping(value = "getuserstypes", method = RequestMethod.GET)
    public ResponseEntity<Page<Users>> fetchAllUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        System.out.println("coming here ****************************");
        Page<Users> list = this.usertypeServiceImpl.listRecords(page, size);
        return new ResponseEntity<Page<Users>>(list, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "getallusertypes", method = RequestMethod.GET)
    public ResponseEntity<List<Usertypes>> fetchAll() {
        System.out.println("coming here ****************************");
        List<Usertypes> list = this.usertypeServiceImpl.listRecords();
        return new ResponseEntity<List<Usertypes>>(list, HttpStatus.OK);
    }
    
    

//    @RequestMapping(value = "/viewusertypes", method = RequestMethod.GET)
//    public ModelAndView showAll() {
//        List<Usertypes> list = this.usertypeServiceImpl.listRecords();
//        return new ModelAndView("mainpages/usertypes/manageusertypes", "list", list);
//    }

    @RequestMapping("/addusertype.htm")
    public ModelAndView showform() {
        return new ModelAndView("mainpages/usertypes/addusertypes", "command", new Users());
    }

    @RequestMapping("/saveusertype.htm")
    public ModelAndView saveRole(@ModelAttribute("s") Usertypes s) {
        this.usertypeServiceImpl.addRecord(s);
        return new ModelAndView("redirect:/viewusertypes.htm");
    }

}
