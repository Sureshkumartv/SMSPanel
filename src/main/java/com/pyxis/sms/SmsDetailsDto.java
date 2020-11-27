package com.pyxis.sms;

import org.apache.commons.lang3.StringUtils;

public class SmsDetailsDto {

    private String smsMsisdn;
    private String smsMessage;
    private String status;
    private Integer senderId;
    private String mobileColumn;
    private String date;
    private Integer smppId;
    private String filepath;
    private Integer credits;
    private Integer messageType;
    private String type; // numbers, upload, custom 
    
    private String filePath;
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
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getType() {
		if(StringUtils.isNotBlank(type) && "group".equalsIgnoreCase(type)) {
			type = "number";
		}
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMobileColumn() {
		return mobileColumn;
	}
	public void setMobileColumn(String mobileColumn) {
		this.mobileColumn = mobileColumn;
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

    /**
     * @return the credits
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
	public Integer getMessageType() {
		return messageType;
	}
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
    
}
