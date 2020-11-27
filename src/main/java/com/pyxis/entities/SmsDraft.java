package com.pyxis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sms_drafts database table.
 * 
 */
@Entity
@Table(name="sms_drafts")
@NamedQuery(name="SmsDraft.findAll", query="SELECT s FROM SmsDraft s")
public class SmsDraft implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer sno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="draft_createddate")
	private Date draftCreateddate;

	@Lob
	@Column(name="draft_message")
	private String draftMessage;

	@Column(name="draft_type")
	private Integer draftType;

	@Column(name="draft_uploadedby")
	private Integer draftUploadedby;

	public SmsDraft() {
	}

	public Integer getSno() {
		return this.sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Date getDraftCreateddate() {
		return this.draftCreateddate;
	}

	public void setDraftCreateddate(Date draftCreateddate) {
		this.draftCreateddate = draftCreateddate;
	}

	public String getDraftMessage() {
		return this.draftMessage;
	}

	public void setDraftMessage(String draftMessage) {
		this.draftMessage = draftMessage;
	}

	public Integer getDraftType() {
		return this.draftType;
	}

	public void setDraftType(Integer draftType) {
		this.draftType = draftType;
	}

	public Integer getDraftUploadedby() {
		return this.draftUploadedby;
	}

	public void setDraftUploadedby(Integer draftUploadedby) {
		this.draftUploadedby = draftUploadedby;
	}
	

}