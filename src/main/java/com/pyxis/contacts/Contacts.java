/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.contacts;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyxis.groups.Groups;

/**
 *
 * @author suresh
 */
@Entity
@Table(name = "user_group_contacts")
public class Contacts implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1270408453700230920L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTACTNO")
    private Integer contactNo;

    @Column(name = "CONTACTNAME")
    private String contactName;

    @Column(name = "MOBILENUMBER")
    private String msisdn;

    @Column(name = "MAILID")
    private String mailID;

    @Column(name = "GROUPID")
    private Long groupId;
    
    @Transient
    private boolean selected = true;
    
    @ManyToOne(optional = false , fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUPID", insertable = false, updatable = false)
    private Groups groups;
    
    
    @Column(name = "CREATEDBY")
    private String createdBy;
//    @OneToOne(optional = false)
//    @JoinColumn(name = "CREATEDBY", insertable = false, updatable = false)
//    private Users users;

    @Column(name = "CRAETEDDATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createdOn;

    public Contacts(int contactNo, String contactName, String msisdn, String mailID, Long groupId, String createdBy, Groups groups, Date createdOn) {
        this.contactNo = contactNo;
        this.contactName = contactName;
        this.msisdn = msisdn;
        this.mailID = mailID;
        this.groupId = groupId;
        this.createdBy = createdBy;
        this.groups = groups;
        this.createdOn = createdOn;
    }

    public Contacts() {
    }

    /**
     * @return the contactNo
     */
    public Integer getContactNo() {
        return contactNo;
    }

    /**
     * @param contactNo the contactNo to set
     */
    public void setContactNo(Integer contactNo) {
        this.contactNo = contactNo;
    }

    /**
     * @return the contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * @param contactName the contactName to set
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * @return the msisdn
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * @param msisdn the msisdn to set
     */
    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    /**
     * @return the mailID
     */
    public String getMailID() {
        return mailID;
    }

    /**
     * @param mailID the mailID to set
     */
    public void setMailID(String mailID) {
        this.mailID = mailID;
    }

    /**
     * @return the groupId
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId the groupId to set
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    

    /**
     * @return the createdOn
     */
    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the groups
     */
    @JsonIgnore
    public Groups getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(Groups groups) {
        this.groups = groups;
    }

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
