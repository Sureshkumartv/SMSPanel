/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.deliveryreports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyxis.resources.SmsHistoryResource;
import com.pyxis.senderid.Senderid;
import com.pyxis.utils.DelStatusEnum;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author suresh
 */
@Entity
@Table(name = "sms_message_details_history")
public class SmsHistory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SMS_SNO")
	private int smsSno;

	@Column(name = "SMS_MSISDN")
	private String msisdn;

	@Column(name = "SMS_SENDINGTYPE")
	private int sendingType;

	@Column(name = "SMS_SMPPID")
	private int smppid;

	@Column(name = "SMS_MESSAGE")
	private String message;

	@Column(name = "SMS_MESSAGEID")
	private String messageId;

	@Column(name = "SMS_MESSAGE_TYPE")
	private int messageType;

	@Column(name = "SMS_EXCEL_SNO")
	private Integer excelSno;

	@Column(name = "SMS_SENDER_ID")
	private int senderId;

	@OneToOne(optional = false)
	@JoinColumn(name = "SMS_SENDER_ID", insertable = false, updatable = false)
	private Senderid senderid;

	@Column(name = "SMS_SCHEDULE_DATE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date scheduleDate;

	@Column(name = "SMS_INSERT_DATE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date insertedDate;

	@Column(name = "SMS_UPLOADEDBY")
	private int uploadedBy;

	@Column(name = "SMS_STATUS")
	private String smsStatus;

	@Column(name = "SMS_SENDING_COMPLETE")
	private String sendingComplete;

	@Column(name = "SMS_RESPONSE")
	private String smsResponse;

	@Column(name = "SMS_PRIORITY")
	private int smsPriority;

	@Column(name = "SMS_RESPONSE_RECEIVE_DATE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date smsResponseReceiveDate;

	@Column(name = "SMS_DEL_RESP_RECEIVE_DATE")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date smsDelRepReceiveDate;

	@Column(name = "SMS_DEL_RESPONSE")
	private String smsDelResponse;
	@Transient
	private Integer count;

	public SmsHistory() {
	}

	public SmsHistory(int smsSno, String msisdn, int sendingType, int smppid, String message, String messageId,
			int messageType, Integer excelSno, int senderId, Senderid senderid, Date scheduleDate, Date insertedDate,
			int uploadedBy, String smsStatus, String sendingComplete, String smsResponse, int smsPriority,
			Date smsResponseReceiveDate, Date smsDelRepReceiveDate, String smsDelResponse) {
		this.smsSno = smsSno;
		this.msisdn = msisdn;
		this.sendingType = sendingType;
		this.smppid = smppid;
		this.message = message;
		this.messageId = messageId;
		this.messageType = messageType;
		this.excelSno = excelSno;
		this.senderId = senderId;
		this.senderid = senderid;
		this.scheduleDate = scheduleDate;
		this.insertedDate = insertedDate;
		this.uploadedBy = uploadedBy;
		this.smsStatus = smsStatus;
		this.sendingComplete = sendingComplete;
		this.smsResponse = smsResponse;
		this.smsPriority = smsPriority;
		this.smsResponseReceiveDate = smsResponseReceiveDate;
		this.smsDelRepReceiveDate = smsDelRepReceiveDate;
		this.smsDelResponse = smsDelResponse;
	}

	/**
	 * @return the smsSno
	 */
	public int getSmsSno() {
		return smsSno;
	}

	/**
	 * @param smsSno
	 *            the smsSno to set
	 */
	public void setSmsSno(int smsSno) {
		this.smsSno = smsSno;
	}

	/**
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * @param msisdn
	 *            the msisdn to set
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	/**
	 * @return the sendingType
	 */
	public int getSendingType() {
		return sendingType;
	}

	/**
	 * @param sendingType
	 *            the sendingType to set
	 */
	public void setSendingType(int sendingType) {
		this.sendingType = sendingType;
	}

	/**
	 * @return the smppid
	 */
	public int getSmppid() {
		return smppid;
	}

	/**
	 * @param smppid
	 *            the smppid to set
	 */
	public void setSmppid(int smppid) {
		this.smppid = smppid;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId
	 *            the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messageType
	 */
	public int getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the excelSno
	 */
	public Integer getExcelSno() {
		return excelSno;
	}

	/**
	 * @param excelSno
	 *            the excelSno to set
	 */
	public void setExcelSno(Integer excelSno) {
		this.excelSno = excelSno;
	}

	/**
	 * @return the senderId
	 */
	public int getSenderId() {
		return senderId;
	}

	/**
	 * @param senderId
	 *            the senderId to set
	 */
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	/**
	 * @return the scheduleDate
	 */
	public Date getScheduleDate() {
		return scheduleDate;
	}

	/**
	 * @param scheduleDate
	 *            the scheduleDate to set
	 */
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	/**
	 * @return the insertedDate
	 */
	public Date getInsertedDate() {
		return insertedDate;
	}

	/**
	 * @param insertedDate
	 *            the insertedDate to set
	 */
	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	/**
	 * @return the uploadedBy
	 */
	public int getUploadedBy() {
		return uploadedBy;
	}

	/**
	 * @param uploadedBy
	 *            the uploadedBy to set
	 */
	public void setUploadedBy(int uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	/**
	 * @return the smsStatus
	 */
	public String getSmsStatus() {
		return smsStatus;
	}

	/**
	 * @param smsStatus
	 *            the smsStatus to set
	 */
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}

	/**
	 * @return the sendingComplete
	 */
	public String getSendingComplete() {
		return sendingComplete;
	}

	/**
	 * @param sendingComplete
	 *            the sendingComplete to set
	 */
	public void setSendingComplete(String sendingComplete) {
		this.sendingComplete = sendingComplete;
	}

	/**
	 * @return the smsResponse
	 */
	public String getSmsResponse() {
		return smsResponse;
	}

	/**
	 * @param smsResponse
	 *            the smsResponse to set
	 */
	public void setSmsResponse(String smsResponse) {
		this.smsResponse = smsResponse;
	}

	/**
	 * @return the smsPriority
	 */
	public int getSmsPriority() {
		return smsPriority;
	}

	/**
	 * @param smsPriority
	 *            the smsPriority to set
	 */
	public void setSmsPriority(int smsPriority) {
		this.smsPriority = smsPriority;
	}

	/**
	 * @return the smsResponseReceiveDate
	 */
	public Date getSmsResponseReceiveDate() {
		return smsResponseReceiveDate;
	}

	/**
	 * @param smsResponseReceiveDate
	 *            the smsResponseReceiveDate to set
	 */
	public void setSmsResponseReceiveDate(Date smsResponseReceiveDate) {
		this.smsResponseReceiveDate = smsResponseReceiveDate;
	}

	/**
	 * @return the smsDelRepReceiveDate
	 */
	public Date getSmsDelRepReceiveDate() {
		return smsDelRepReceiveDate;
	}

	/**
	 * @param smsDelRepReceiveDate
	 *            the smsDelRepReceiveDate to set
	 */
	public void setSmsDelRepReceiveDate(Date smsDelRepReceiveDate) {
		this.smsDelRepReceiveDate = smsDelRepReceiveDate;
	}

	/**
	 * @return the smsDelResponse
	 */
	public String getSmsDelResponse() {
		return smsDelResponse;
	}

	/**
	 * @param smsDelResponse
	 *            the smsDelResponse to set
	 */
	public void setSmsDelResponse(String smsDelResponse) {
		this.smsDelResponse = smsDelResponse;
	}

	/**
	 * @return the senderid
	 */
	public Senderid getSenderid() {
		return senderid;
	}

	/**
	 * @param senderid
	 *            the senderid to set
	 */
	public void setSenderid(Senderid senderid) {
		this.senderid = senderid;
	}

	@JsonIgnore
	public SmsHistoryResource getResource() {
		SmsHistoryResource resource = new SmsHistoryResource();
		resource.setMessage(this.getMessage().replace("\r\n", "").replace("\n", ""));
		resource.setMobile(this.getMsisdn());
		resource.setSenderid(this.getSenderid().getSendername());
		resource.setInsertedDate(this.insertedDate);
		resource.setDeliveredDate(this.smsResponseReceiveDate);
		if (null != this.getSmsStatus()) {
			resource.setStatus(DelStatusEnum.valueOf(this.getSmsStatus()).getValue());
		}
		return resource;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
