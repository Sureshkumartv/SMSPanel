/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.usertypes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pyxis.users.Users;

/**
 *
 * @author suresh
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsertypeServiceImpl implements UsertypeService {

	@Autowired
	private UsertypeDAO usertypeDAOImpl;

	@Override
	public void addRecord(Usertypes s) {
		// this.usertypeDAOImpl.addRecord(s);
	}

	@Override
	public void updateRecord(int id) {
		// this.usertypeDAOImpl.updateRecord(id);
	}

	@Override
	public void deleteRecord(int id) {
		// this.usertypeDAOImpl.deleteRecord(id);
	}

	@Override
	public Usertypes getById(int id) {
		// Usertypes s = this.usertypeDAOImpl.getById(id);
		// return s;
		return null;
	}

	@Override
	public List<Usertypes> listRecords() {
		 return this.usertypeDAOImpl.findAll();
	}

	@Override
	public Page<Users> listRecords(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
