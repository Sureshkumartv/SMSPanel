/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.srisairam.http.HttpResponce;

import com.pyxis.panelapiclient.UserPanelClientImpl;
import com.pyxis.users.UserToken;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SenderidServiceImpl implements SenderidService {

	@Autowired
	private SenderidRepository senderidRepository;
	
	@Autowired
	private UserSenderidRepository userSenderidRepository;

	@Value("${http.user.panel.url}")
	private String httpUserpanelUrl;

	/*
	 * public void setSenderidRepository(SenderidRepository senderidRepository)
	 * { this.senderidRepository = senderidRepository; }
	 * 
	 * @Autowired private SenderidDAOImpl senderidDAOImpl;
	 * 
	 * public void setSenderidDAOImpl(SenderidDAOImpl senderidDAOImpl) {
	 * this.senderidDAOImpl = senderidDAOImpl; }
	 */

	@Override
	public void addRecord(Senderid s) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		s.setCreadtedby(user.getId().intValue());
		//insert into senderid_detils (creadtedby, sendername, status) values (?, ?, ?)
		System.out.println("-------createdby  ----:"+s.getCreadtedby());
		System.out.println("---sendername------:"+s.getSendername());
		System.out.println("----statys ---::"+s.getStatus());
		s.setStatus(1);

		Senderid senderid = this.senderidRepository.save(s);
		
		/*UserSenderID temp = new UserSenderID();
		temp.setUserId(s.getCreadtedby());
		temp.setSenderId(senderid.getSenderid());
		temp.setStatus(2);
		addUserRecord(temp);*/
		
	
		System.out.println("id==>" + senderid.getSenderid());
		if (senderid.getSenderid() > 0) {
			//senderidRepository.deleteTest(user.getId(), senderid.getSenderid());
			//senderidRepository.nativeQueryInsert(user.getId(), senderid.getSenderid());
			UserPanelClientImpl userPanelClient = new UserPanelClientImpl(httpUserpanelUrl, user.getUsername(),
					user.getPassword());
			userPanelClient.loadSenderIds();
		}
	}
@Override
public void addUserRecord(UserSenderID s) {
	
	this.userSenderidRepository.save(s);
	
}
	@Override
	public void updateRecord(Integer id) {
		Senderid sender = senderidRepository.findOne(id.longValue());
		this.senderidRepository.save(sender);
	}

	@Override
	public void deleteRecord(Integer id) {
		Senderid sender = senderidRepository.findOne(id.longValue());
		this.senderidRepository.delete(sender);
	}

	@Override
	public Senderid getById(int id) {
		Senderid s = this.senderidRepository.findOne((long) id);
		return s;
	}

	@Override
	public List<Senderid> listRecords() {
		return this.senderidRepository.findAll();
	}

	@Override
	public Page<Senderid> listRecords(Integer page, Integer size) {

		// List<Senderid> senderid = senderidRepository.listRecords(page, size);
		Pageable pageable = new PageRequest(page, size);
		// PageImpl<Senderid> impl = new PageImpl<>(senderid, pageable,
		// senderidDAOImpl.getSenderidsCount());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserToken user = (UserToken) auth.getPrincipal();
		Page<Senderid> impl = senderidRepository.findByCreadtedby(user.getId().intValue(), pageable);
		return impl;
	}

	@Override
	public List<Senderid> fetchUserSenderIds(Integer SenderId) {

		return senderidRepository.findByCreatedByApproved(SenderId);
	}

}
