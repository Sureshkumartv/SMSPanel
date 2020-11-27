/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.List;

import org.springframework.data.domain.Page;

import com.pyxis.entities.EsmeInfo;
import com.pyxis.entities.UserCreditsDetail;

/**
 *
 * @author suresh
 */
public interface UserService {

    public void addRecord(Users s);

//    public void updateRecord(int id);
    public void deleteRecord(int id);

    public Users getById(int id);

    public boolean hasRole(String role);

    Page<Users> listRecords(Integer page, Integer size);

    void updateRecord(Users id);

    List<EsmeInfo> fetchEsmeInfo();

    public void submitCredits(UserCreditsDetail s);

}
