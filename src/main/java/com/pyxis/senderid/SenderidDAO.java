/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

import java.util.List;

/**
 *
 * @author suresh
 */
public interface SenderidDAO {

    public void addRecord(Senderid s);

    public void updateRecord(int id);

    public void deleteRecord(int id);

    public Senderid getById(int id);

    public List<Senderid> listRecords();

    List<Senderid> listRecords(Integer page, Integer size);

    Long getSenderidsCount();

}
