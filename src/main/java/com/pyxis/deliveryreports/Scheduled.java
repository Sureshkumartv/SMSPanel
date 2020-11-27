/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.pyxis.entities.EsmeInfo;
import com.pyxis.senderid.Senderid;
import com.pyxis.users.Users;

/**
 *
 * @author suresh
 */
@Entity
@Table(name = "excel_file_details")
public class Scheduled implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXCEL_SNO")
    private int excelSno;

    @Column(name = "SMS_SENDINGTYPE")
    private int smsSendingType;

    @Column(name = "MESSAGE_TYPE")
    private int messageType;

    @Column(name = "UPLOAD_TYPE")
    private int uploadType;

    @Column(name = "EXCEL_NAME")
    private String excelName;

    @Column(name = "EXCEL_PATH")
    private String excelPath;

    @Column(name = "EXCEL_FILE_NAME")
    private String excelFileName;

    @Column(name = "EXCEL_UPLOADBY")
    private int excelUploadedBy;
    @OneToOne(optional = false)
    @JoinColumn(name = "EXCEL_UPLOADBY", insertable = false, updatable = false)
    private Users users;

    @Column(name = "EXCEL_UPLOADED_DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date excelUploadedDate;

    @Column(name = "CREDITS_DETECTED")
    private int creditsDetected;

    @Column(name = "EXCEL_MOBILE_COLUMN_NAME")
    private String mobileColumnName;

    @Column(name = "EXCEL_MESSAGE_COLUMN_NAME")
    private String messageColumnName;

    @Column(name = "EXCEL_COMMON_MESSAGE")
    private String commonMessage;

    @Column(name = "EXCEL_SCHEDULE_DATE")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date excelScheduleDate;

    @Column(name = "SENDER_ID")
    private int senderId;
    @OneToOne(optional = false)
    @JoinColumn(name = "SENDER_ID", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Senderid senderid;

    @Column(name = "EXCEL_STATUS")
    private String excelStatus;

    @Column(name = "SMPPID")
    private int smppId;

    @ManyToOne
    @JoinColumn(name = "SMPPID", insertable = false, updatable = false)
    private EsmeInfo esmeInfo;

//     @OneToOne(optional = false)
//    @JoinColumn(name = "SMPPID", insertable = false, updatable = false)
//    private Senderid senderid;
    public Scheduled() {
        System.out.println("Scheduled Contructor");
    }

    public Scheduled(int excelSno, int smsSendingType, int messageType, int uploadType, String excelName, String excelPath, String excelFileName, int excelUploadedBy, Users users, Date excelUploadedDate, int creditsDetected, String mobileColumnName, String messageColumnName, String commonMessage, Date excelScheduleDate, int senderId, Senderid senderid, String excelStatus, int smppId, EsmeInfo esmeInfo) {
        this.excelSno = excelSno;
        this.smsSendingType = smsSendingType;
        this.messageType = messageType;
        this.uploadType = uploadType;
        this.excelName = excelName;
        this.excelPath = excelPath;
        this.excelFileName = excelFileName;
        this.excelUploadedBy = excelUploadedBy;
        this.users = users;
        this.excelUploadedDate = excelUploadedDate;
        this.creditsDetected = creditsDetected;
        this.mobileColumnName = mobileColumnName;
        this.messageColumnName = messageColumnName;
        this.commonMessage = commonMessage;
        this.excelScheduleDate = excelScheduleDate;
        this.senderId = senderId;
        this.senderid = senderid;
        this.excelStatus = excelStatus;
        this.smppId = smppId;
        this.esmeInfo = esmeInfo;
    }

    public Scheduled(int excelSno, int smsSendingType, int messageType, int uploadType, String excelName, String excelPath, String excelFileName, int excelUploadedBy, Users users, Date excelUploadedDate, int creditsDetected, String mobileColumnName, String messageColumnName, String commonMessage, Date excelScheduleDate, int senderId, String excelStatus, int smppId) {
        this.excelSno = excelSno;
        this.smsSendingType = smsSendingType;
        this.messageType = messageType;
        this.uploadType = uploadType;
        this.excelName = excelName;
        this.excelPath = excelPath;
        this.excelFileName = excelFileName;
        this.excelUploadedBy = excelUploadedBy;
        this.users = users;
        this.excelUploadedDate = excelUploadedDate;
        this.creditsDetected = creditsDetected;
        this.mobileColumnName = mobileColumnName;
        this.messageColumnName = messageColumnName;
        this.commonMessage = commonMessage;
        this.excelScheduleDate = excelScheduleDate;
        this.senderId = senderId;
        this.excelStatus = excelStatus;
        this.smppId = smppId;
    }

    public Scheduled(int excelSno, int smsSendingType, int messageType, int uploadType, String excelName, String excelPath, String excelFileName, int excelUploadedBy, Users users, Date excelUploadedDate, int creditsDetected, String mobileColumnName, String messageColumnName, String commonMessage, Date excelScheduleDate, int senderId, Senderid senderid, String excelStatus, int smppId) {
        this.excelSno = excelSno;
        this.smsSendingType = smsSendingType;
        this.messageType = messageType;
        this.uploadType = uploadType;
        this.excelName = excelName;
        this.excelPath = excelPath;
        this.excelFileName = excelFileName;
        this.excelUploadedBy = excelUploadedBy;
        this.users = users;
        this.excelUploadedDate = excelUploadedDate;
        this.creditsDetected = creditsDetected;
        this.mobileColumnName = mobileColumnName;
        this.messageColumnName = messageColumnName;
        this.commonMessage = commonMessage;
        this.excelScheduleDate = excelScheduleDate;
        this.senderId = senderId;
        this.senderid = senderid;
        this.excelStatus = excelStatus;
        this.smppId = smppId;
    }

    /**
     * @return the excelSno
     */
    public int getExcelSno() {
        return excelSno;
    }

    /**
     * @param excelSno the excelSno to set
     */
    public void setExcelSno(int excelSno) {
        this.excelSno = excelSno;
    }

    /**
     * @return the smsSendingType
     */
    public int getSmsSendingType() {
        return smsSendingType;
    }

    /**
     * @param smsSendingType the smsSendingType to set
     */
    public void setSmsSendingType(int smsSendingType) {
        this.smsSendingType = smsSendingType;
    }

    /**
     * @return the messageType
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * @param messageType the messageType to set
     */
    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    /**
     * @return the uploadType
     */
    public int getUploadType() {
        return uploadType;
    }

    /**
     * @param uploadType the uploadType to set
     */
    public void setUploadType(int uploadType) {
        this.uploadType = uploadType;
    }

    /**
     * @return the excelName
     */
    public String getExcelName() {
        return excelName;
    }

    /**
     * @param excelName the excelName to set
     */
    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    /**
     * @return the excelPath
     */
    public String getExcelPath() {
        return excelPath;
    }

    /**
     * @param excelPath the excelPath to set
     */
    public void setExcelPath(String excelPath) {
        this.excelPath = excelPath;
    }

    /**
     * @return the excelFileName
     */
    public String getExcelFileName() {
        return excelFileName;
    }

    /**
     * @param excelFileName the excelFileName to set
     */
    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    /**
     * @return the excelUploadedBy
     */
    public int getExcelUploadedBy() {
        return excelUploadedBy;
    }

    /**
     * @param excelUploadedBy the excelUploadedBy to set
     */
    public void setExcelUploadedBy(int excelUploadedBy) {
        this.excelUploadedBy = excelUploadedBy;
    }

    /**
     * @return the excelUploadedDate
     */
    public Date getExcelUploadedDate() {
        return excelUploadedDate;
    }

    /**
     * @param excelUploadedDate the excelUploadedDate to set
     */
    public void setExcelUploadedDate(Date excelUploadedDate) {
        this.excelUploadedDate = excelUploadedDate;
    }

    /**
     * @return the creditsDetected
     */
    public int getCreditsDetected() {
        return creditsDetected;
    }

    /**
     * @param creditsDetected the creditsDetected to set
     */
    public void setCreditsDetected(int creditsDetected) {
        this.creditsDetected = creditsDetected;
    }

    /**
     * @return the mobileColumnName
     */
    public String getMobileColumnName() {
        return mobileColumnName;
    }

    /**
     * @param mobileColumnName the mobileColumnName to set
     */
    public void setMobileColumnName(String mobileColumnName) {
        this.mobileColumnName = mobileColumnName;
    }

    /**
     * @return the messageColumnName
     */
    public String getMessageColumnName() {
        return messageColumnName;
    }

    /**
     * @param messageColumnName the messageColumnName to set
     */
    public void setMessageColumnName(String messageColumnName) {
        this.messageColumnName = messageColumnName;
    }

    /**
     * @return the commonMessage
     */
    public String getCommonMessage() {
        return commonMessage;
    }

    /**
     * @param commonMessage the commonMessage to set
     */
    public void setCommonMessage(String commonMessage) {
        this.commonMessage = commonMessage;
    }

    /**
     * @return the excelScheduleDate
     */
    public Date getExcelScheduleDate() {
        return excelScheduleDate;
    }

    /**
     * @param excelScheduleDate the excelScheduleDate to set
     */
    public void setExcelScheduleDate(Date excelScheduleDate) {
        this.excelScheduleDate = excelScheduleDate;
    }

    /**
     * @return the senderId
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     * @return the excelStatus
     */
    public String getExcelStatus() {
        return excelStatus;
    }

    /**
     * @param excelStatus the excelStatus to set
     */
    public void setExcelStatus(String excelStatus) {
        this.excelStatus = excelStatus;
    }

    /**
     * @return the smppId
     */
    public int getSmppId() {
        return smppId;
    }

    /**
     * @param smppId the smppId to set
     */
    public void setSmppId(int smppId) {
        this.smppId = smppId;
    }

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

    /**
     * @return the senderid
     */
    public Senderid getSenderid() {
        return senderid;
    }

    /**
     * @param senderid the senderid to set
     */
    public void setSenderid(Senderid senderid) {
        this.senderid = senderid;
    }

    /**
     * @return the esmeInfo
     */
    public EsmeInfo getEsmeInfo() {
        return esmeInfo;
    }

    /**
     * @param esmeInfo the esmeInfo to set
     */
    public void setEsmeInfo(EsmeInfo esmeInfo) {
        this.esmeInfo = esmeInfo;
    }

   

}
