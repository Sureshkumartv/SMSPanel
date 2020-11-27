/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.senderid;

import com.pyxis.users.Users;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author suresh
 */
@Entity
@Table(name = "senderid_detils")
public class Senderid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SENDERID")
    private int senderid;
//    @OneToOne(optional = false)
//    @JoinColumn(name = "SENDERID", insertable = false, updatable = false)
//    private UserSenderID userSenderID;

    @Column(name = "SENDERNAME")
    private String sendername;

    @Column(name = "CREADTEDBY")
    private Integer creadtedby;

    @OneToOne(optional = false)
    @JoinColumn(name = "CREADTEDBY",insertable = false, updatable = false)
    private Users users;
    
    @Column(name = "STATUS")
    private int status;
    
    public Senderid() {
        System.out.println("Default Constructor");
    }

   

    public Senderid(int senderid, String sendername, Integer creadtedby, Users users, int status) {
        this.senderid = senderid;
        this.sendername = sendername;
        this.creadtedby = creadtedby;
        this.users = users;
        this.status = status;
    }

    

    /**
     *
     * @param sendername
     * @param creadtedby
     * @param status
     */
//    public Senderid(String sendername ,int creadtedby,int status/*Users user*/){
//        this.sendername=sendername;
//        this.creadtedby=creadtedby; 
//        this.status=status;
////        this.users=users;
//    }
    /**
     * @return the senderid
     */
    public Integer getSenderid() {
        return senderid;
    }

    /**
     * @param senderid the senderid to set
     */
    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    /**
     * @return the sendername
     */
    public String getSendername() {
        return sendername;
    }

    /**
     * @param sendername the sendername to set
     */
    public void setSendername(String sendername) {
        this.sendername = sendername;
    }

    /**
     * @return the creadtedby
     */
    public int getCreadtedby() {
        return creadtedby;
    }

    /**
     * @param creadtedby the creadtedby to set
     */
    public void setCreadtedby(int creadtedby) {
        this.creadtedby = creadtedby;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

//    /**
//     * @return the users
//     */
//    public Users getUsers() {
//        return users;
//    }
//
//    /**
//     * @param users the users to set
//     */
//    public void setUsers(Users users) {
//        this.users = users;
//    }

    /**
     * @return the userSenderID
     */
   
    /**
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Override
    public String toString() {
    	return this.sendername;
    }
}
