/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author suresh
 */
public interface SenderidService {

    public void addRecord(Senderid s);
    
    public void addUserRecord(UserSenderID s);
    
    public Senderid getById(int id);

    public List<Senderid> listRecords();

    Page<Senderid> listRecords(Integer page, Integer size);

	public List<Senderid> fetchUserSenderIds(Integer senderId);

	void updateRecord(Integer id);


	void deleteRecord(Integer id);

}
