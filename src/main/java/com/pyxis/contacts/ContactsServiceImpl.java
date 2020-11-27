/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pyxis.users.UserToken;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    ContactsRepository contactsRepository;

    @Autowired
    ContactsDAO contactsDAOImpl;
    

    @Override
    public Page<Contacts> listRecords(Integer page, Integer size, Long groupId) {
    	Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC, "createdOn"));
        Page<Contacts> contacts = this.contactsRepository.findByGroupsGroupsno(groupId, pageable);
//        Pageable pageable = new PageRequest(page, size);
//        PageImpl<Contacts> impl = new PageImpl<>(contacts, pageable, contactsDAOImpl.getContactsCount());
        return contacts;
    }
    
    
    @Override
    public void addRecord(Contacts s) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
    	s.setCreatedBy(user.getId().toString());
    	s.setCreatedOn(new Date());
        this.contactsRepository.save(s);
    }


	@Override
	public List<Contacts> listRecords(List<Long> groupIds) {
        List<Contacts> contacts = this.contactsRepository.findByGroupsGroupsnoIn(groupIds);
//        Pageable pageable = new PageRequest(page, size);
//        PageImpl<Contacts> impl = new PageImpl<>(contacts, pageable, contactsDAOImpl.getContactsCount());
        return contacts;

	}

}
