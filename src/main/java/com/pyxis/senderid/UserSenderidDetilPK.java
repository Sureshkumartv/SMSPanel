package com.pyxis.senderid;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_senderid_detils database table.
 * 
 */
@Embeddable
public class UserSenderidDetilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int userid;

	@Column(unique=true, nullable=false)
	private int senderid;

	public UserSenderidDetilPK() {
	}
	public int getUserid() {
		return this.userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getSenderid() {
		return this.senderid;
	}
	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserSenderidDetilPK)) {
			return false;
		}
		UserSenderidDetilPK castOther = (UserSenderidDetilPK)other;
		return 
			(this.userid == castOther.userid)
			&& (this.senderid == castOther.senderid);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid;
		hash = hash * prime + this.senderid;
		
		return hash;
	}
}