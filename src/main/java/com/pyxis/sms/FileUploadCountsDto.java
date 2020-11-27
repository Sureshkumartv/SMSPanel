package com.pyxis.sms;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileUploadCountsDto {

	private MultipartFile uploadedFile;
	private Integer total;
	private Integer invalid;
	private Integer duplicate;
	private Integer dnd;
	private String messageType;
	private String smsgroup;
	private String mobileColumn;

	private String smsMsisdn;
	private String smsMessage;
	private String status;
	private Integer senderId;
	private String date;
	private Integer smppId;
	private String filepath;

	private String type; // numbers, upload, custom

	private String filePath;

	@JsonIgnore
	public MultipartFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(MultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getInvalid() {
		return invalid;
	}

	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}

	public Integer getDuplicate() {
		return duplicate;
	}

	public void setDuplicate(Integer duplicate) {
		this.duplicate = duplicate;
	}

	public Integer getDnd() {
		return dnd;
	}

	public void setDnd(Integer dnd) {
		this.dnd = dnd;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getSmsgroup() {
		return smsgroup;
	}

	public void setSmsgroup(String smsgroup) {
		this.smsgroup = smsgroup;
	}

	public String getMobileColumn() {
		return mobileColumn;
	}

	public void setMobileColumn(String mobileColumn) {
		this.mobileColumn = mobileColumn;
	}

	public String getSmsMsisdn() {
		return smsMsisdn;
	}

	public void setSmsMsisdn(String smsMsisdn) {
		this.smsMsisdn = smsMsisdn;
	}

	public String getSmsMessage() {
		return smsMessage;
	}

	public void setSmsMessage(String smsMessage) {
		this.smsMessage = smsMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getSmppId() {
		return smppId;
	}

	public void setSmppId(Integer smppId) {
		this.smppId = smppId;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
