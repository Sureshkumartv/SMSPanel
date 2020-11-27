/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author suresh
 */
public interface SmsHistoryDao extends JpaRepository<SmsHistory, Long>{

	//List<SmsHistory> listRecords(Integer page, Integer size);

}
