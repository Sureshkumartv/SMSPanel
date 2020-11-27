/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 *
 * @author suresh
 */
public interface ScheduledService {
    Page<Scheduled> listRecords(Integer page, Integer size);

	List<Scheduled> listAllRecords();
}
