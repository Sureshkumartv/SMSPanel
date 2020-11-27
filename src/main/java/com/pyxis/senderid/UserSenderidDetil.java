package com.pyxis.senderid;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the user_senderid_detils database table.
 * 
 */
@Entity
@Table(name="user_senderid_detils")
public class UserSenderidDetil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserSenderidDetilPK id;

	@Column(nullable=false)
	private Timestamp creadteddate;

	@Column(nullable=false)
	private int status;

	public UserSenderidDetil() {
	}

	public UserSenderidDetilPK getId() {
		return this.id;
	}

	public void setId(UserSenderidDetilPK id) {
		this.id = id;
	}

	public Timestamp getCreadteddate() {
		return this.creadteddate;
	}

	public void setCreadteddate(Timestamp creadteddate) {
		this.creadteddate = creadteddate;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}