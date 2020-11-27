/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.groups;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.pyxis.contacts.Contacts;

/**
 *
 * @author suresh
 */
public interface GroupsService {

    public void addRecord(Groups s);

    public Groups getById(int id);

    Page<Groups> listRecords(Integer page, Integer size);

    List<Groups> allRecords();

    void updateRecord(Groups s);

	void deleteRecord(Long id);

	public List<Contacts> saveUploadedContacts(MultipartFile excelFile, Integer groupId);

}
