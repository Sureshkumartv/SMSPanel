package com.pyxis.sms;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the excel_file_details database table.
 * 
 */
@Entity
@Table(name="excel_file_details")
@NamedQuery(name="ExcelFileDetail.findAll", query="SELECT e FROM ExcelFileDetail e")
public class ExcelFileDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EXCEL_SNO")
	private int excelSno;

	@Column(name="CREDITS_DETECTED")
	private int creditsDetected;

	@Lob
	@Column(name="EXCEL_COMMON_MESSAGE")
	private String excelCommonMessage;

	@Lob
	@Column(name="EXCEL_FILE_NAME")
	private String excelFileName;

	@Column(name="EXCEL_MESSAGE_COLUMN_NAME")
	private String excelMessageColumnName;

	@Column(name="EXCEL_MOBILE_COLUMN_NAME")
	private String excelMobileColumnName;

	@Column(name="EXCEL_NAME")
	private String excelName;

	@Lob
	@Column(name="EXCEL_PATH")
	private String excelPath;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EXCEL_SCHEDULE_DATE")
	private Date excelScheduleDate;

	@Column(name="EXCEL_STATUS")
	private String excelStatus;

	@Column(name="EXCEL_UPLOADBY")
	private int excelUploadby;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="EXCEL_UPLOADED_DATE")
	private Date excelUploadedDate;

	@Column(name="MESSAGE_TYPE")
	private int messageType;

	@Column(name="SENDER_ID")
	private int senderId;

	private int smppid;

	@Column(name="SMS_SENDINGTYPE")
	private int smsSendingtype;

	@Column(name="UPLOAD_TYPE")
	private int uploadType;

	public ExcelFileDetail() {
	}

	public int getExcelSno() {
		return this.excelSno;
	}

	public void setExcelSno(int excelSno) {
		this.excelSno = excelSno;
	}

	public int getCreditsDetected() {
		return this.creditsDetected;
	}

	public void setCreditsDetected(int creditsDetected) {
		this.creditsDetected = creditsDetected;
	}

	public String getExcelCommonMessage() {
		return this.excelCommonMessage;
	}

	public void setExcelCommonMessage(String excelCommonMessage) {
		this.excelCommonMessage = excelCommonMessage;
	}

	public String getExcelFileName() {
		return this.excelFileName;
	}

	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public String getExcelMessageColumnName() {
		return this.excelMessageColumnName;
	}

	public void setExcelMessageColumnName(String excelMessageColumnName) {
		this.excelMessageColumnName = excelMessageColumnName;
	}

	public String getExcelMobileColumnName() {
		return this.excelMobileColumnName;
	}

	public void setExcelMobileColumnName(String excelMobileColumnName) {
		this.excelMobileColumnName = excelMobileColumnName;
	}

	public String getExcelName() {
		return this.excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getExcelPath() {
		return this.excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

	public Date getExcelScheduleDate() {
		return this.excelScheduleDate;
	}

	public void setExcelScheduleDate(Date excelScheduleDate) {
		this.excelScheduleDate = excelScheduleDate;
	}

	public String getExcelStatus() {
		return this.excelStatus;
	}

	public void setExcelStatus(String excelStatus) {
		this.excelStatus = excelStatus;
	}

	public int getExcelUploadby() {
		return this.excelUploadby;
	}

	public void setExcelUploadby(int excelUploadby) {
		this.excelUploadby = excelUploadby;
	}

	public Date getExcelUploadedDate() {
		return this.excelUploadedDate;
	}

	public void setExcelUploadedDate(Date excelUploadedDate) {
		this.excelUploadedDate = excelUploadedDate;
	}

	public int getMessageType() {
		return this.messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public int getSenderId() {
		return this.senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getSmppid() {
		return this.smppid;
	}

	public void setSmppid(int smppid) {
		this.smppid = smppid;
	}

	public int getSmsSendingtype() {
		return this.smsSendingtype;
	}

	public void setSmsSendingtype(int smsSendingtype) {
		this.smsSendingtype = smsSendingtype;
	}

	public int getUploadType() {
		return this.uploadType;
	}

	public void setUploadType(int uploadType) {
		this.uploadType = uploadType;
	}

}