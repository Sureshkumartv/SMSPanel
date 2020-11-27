/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suresh
 */
public interface ScheduledRepository extends JpaRepository<Scheduled, Long> {
    Scheduled findByExcelSno(int id) throws DataAccessException;
    
    Page<Scheduled> findByUsersUserid(Long userId, Pageable pageable);
    
    List<Scheduled> findByUsersUserid(Long userId);
}
