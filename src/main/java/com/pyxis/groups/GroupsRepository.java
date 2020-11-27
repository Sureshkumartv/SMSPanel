/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.groups;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suresh
 */
public interface GroupsRepository extends JpaRepository<Groups, Long> {

	Groups findByGroupsno(int id) throws DataAccessException;	
	
	List<Groups> findByCreatedby(Long createdBy);

	Page<Groups> findByCreatedby(Long id, Pageable pageable);

}

   