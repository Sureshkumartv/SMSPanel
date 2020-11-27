/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.usertypes;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pyxis.users.Users;

/**
 *
 * @author suresh
 */
public interface UsertypeService {

    public void addRecord(Usertypes s);

    public void updateRecord(int id);

    public void deleteRecord(int id);

    public Usertypes getById(int id);

    public List<Usertypes> listRecords();

	public Page<Users> listRecords(int page, int size);
}
