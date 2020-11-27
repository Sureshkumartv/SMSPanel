/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import com.pyxis.groups.Groups;
import com.pyxis.users.UserToken;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ScheduledServiceImpl implements ScheduledService {

    @Autowired
    ScheduledRepository scheduledRepository;

    @Autowired
    ScheduledDAOImpl scheduledDAOImpl;

    @Override
    public Page<Scheduled> listRecords(Integer page, Integer size) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
        Pageable pageable = new PageRequest(page, size, new Sort(Sort.Direction.DESC, "excelSno"));
        Page<Scheduled> groups = this.scheduledRepository.findByUsersUserid(user.getId(), pageable);
        return groups;
    }
    
    @Override
    public List<Scheduled> listAllRecords() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
        List<Scheduled> groups = this.scheduledRepository.findByUsersUserid(user.getId());
        return groups;
    }

}
