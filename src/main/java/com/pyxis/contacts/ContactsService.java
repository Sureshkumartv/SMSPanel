/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 *
 * @author suresh
 */
public interface ContactsService {

	Page<Contacts> listRecords(Integer page, Integer size, Long groupId);

	void addRecord(Contacts s);

	List<Contacts> listRecords(List<Long> groupIds);

}
