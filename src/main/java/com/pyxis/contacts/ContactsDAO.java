/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suresh
 */
public interface ContactsDAO extends JpaRepository<Contacts, Long>{
	
//    List<Contacts> listRecords(Integer page, Integer size);

//    Long getContactsCount();
}
