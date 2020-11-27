package com.pyxis.sms;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "sms_message_details")
public class SmsDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SMS_SNO")
    private Integer smsSno;
    
    @Column(name = "SMS_MSISDN")
    private String smsMsisdn;
    @Column(name = "SMS_SENDINGTYPE")
    private Integer smsSendingType;
    @Column(name = "SMS_SMPPID")
    private Integer smsSmppId;
    @Column(name = "SMS_MESSAGE")
    private String smsMessage;
    @Column(name = "SMS_MESSAGEID")
    private String smsMessageId;
    @Column(name = "SMS_MESSAGE_TYPE")
    private Integer smsMessageType;
    @Column(name = "SMS_EXCEL_SNO")
    private Integer smsExcelSno;
    @Column(name = "SMS_SENDER_ID")
    private Integer smsSenderId;
    @Column(name = "SMS_SCHEDULE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date smsScheduleDate;
    @Column(name = "SMS_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date smsInsertDate;
    @Column(name = "SMS_UPLOADEDBY")
    private Integer smsUploadedBy;
    @Column(name = "SMS_STATUS")
    private String smsStatus;
    @Column(name = "SMS_SENDING_COMPLETE")
    private String smsSendingComplete;
    @Column(name = "SMS_RESPONSE")
    private String smsResponse;
    @Column(name = "SMS_PRIORITY")
    private Integer smsPriority;
    @Column(name = "SMS_RESPONSE_RECEIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date smsResponseReceiveDate;
    @Column(name = "SMS_DEL_RESP_RECEIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date smsDelRespReceiveDate;
    @Column(name = "SMS_DEL_RESPONSE")
    private String smsDelResponse;
    public Integer getSmsSno() {
        return smsSno;
    }
    public void setSmsSno(Integer smsSno) {
        this.smsSno = smsSno;
    }
    public String getSmsMsisdn() {
        return smsMsisdn;
    }
    public void setSmsMsisdn(String smsMsisdn) {
        this.smsMsisdn = smsMsisdn;
    }
    public Integer getSmsSendingType() {
        return smsSendingType;
    }
    public void setSmsSendingType(Integer smsSendingType) {
        this.smsSendingType = smsSendingType;
    }
    public Integer getSmsSmppId() {
        return smsSmppId;
    }
    public void setSmsSmppId(Integer smsSmppId) {
        this.smsSmppId = smsSmppId;
    }
    public String getSmsMessage() {
        return smsMessage;
    }
    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }
    public String getSmsMessageId() {
        return smsMessageId;
    }
    public void setSmsMessageId(String smsMessageId) {
        this.smsMessageId = smsMessageId;
    }
    public Integer getSmsMessageType() {
        return smsMessageType;
    }
    public void setSmsMessageType(Integer smsMessageType) {
        this.smsMessageType = smsMessageType;
    }
    public Integer getSmsExcelSno() {
        return smsExcelSno;
    }
    public void setSmsExcelSno(Integer smsExcelSno) {
        this.smsExcelSno = smsExcelSno;
    }
    public Integer getSmsSenderId() {
        return smsSenderId;
    }
    public void setSmsSenderId(Integer smsSenderId) {
        this.smsSenderId = smsSenderId;
    }
    public Date getSmsScheduleDate() {
        return smsScheduleDate;
    }
    public void setSmsScheduleDate(Date smsScheduleDate) {
        this.smsScheduleDate = smsScheduleDate;
    }
    public Date getSmsInsertDate() {
        return smsInsertDate;
    }
    public void setSmsInsertDate(Date smsInsertDate) {
        this.smsInsertDate = smsInsertDate;
    }
    public Integer getSmsUploadedBy() {
        return smsUploadedBy;
    }
    public void setSmsUploadedBy(Integer smsUploadedBy) {
        this.smsUploadedBy = smsUploadedBy;
    }
    public String getSmsStatus() {
        return smsStatus;
    }
    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus;
    }
    public String getSmsSendingComplete() {
        return smsSendingComplete;
    }
    public void setSmsSendingComplete(String smsSendingComplete) {
        this.smsSendingComplete = smsSendingComplete;
    }
    public String getSmsResponse() {
        return smsResponse;
    }
    public void setSmsResponse(String smsResponse) {
        this.smsResponse = smsResponse;
    }
    public Integer getSmsPriority() {
        return smsPriority;
    }
    public void setSmsPriority(Integer smsPriority) {
        this.smsPriority = smsPriority;
    }
    public Date getSmsResponseReceiveDate() {
        return smsResponseReceiveDate;
    }
    public void setSmsResponseReceiveDate(Date smsResponseReceiveDate) {
        this.smsResponseReceiveDate = smsResponseReceiveDate;
    }
    public Date getSmsDelRespReceiveDate() {
        return smsDelRespReceiveDate;
    }
    public void setSmsDelRespReceiveDate(Date smsDelRespReceiveDate) {
        this.smsDelRespReceiveDate = smsDelRespReceiveDate;
    }
    public String getSmsDelResponse() {
        return smsDelResponse;
    }
    public void setSmsDelResponse(String smsDelResponse) {
        this.smsDelResponse = smsDelResponse;
    }
    
    
   
}
