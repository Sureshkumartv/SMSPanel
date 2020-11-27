/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;


import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suresh
 */
public interface ContactsRepository extends JpaRepository<Contacts, Integer> {

	Contacts findByContactNo(int id) throws DataAccessException;

	Page<Contacts> findByGroupsGroupsno(Long groupId, Pageable pageable);
	List<Contacts> findByGroupsGroupsnoIn(List<Long> groupId);

}
