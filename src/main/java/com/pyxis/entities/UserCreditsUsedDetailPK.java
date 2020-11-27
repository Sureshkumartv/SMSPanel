package com.pyxis.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_credits_used_details database table.
 * 
 */
@Embeddable
public class UserCreditsUsedDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(unique=true, nullable=false)
	private int userid;

	@Temporal(TemporalType.DATE)
	@Column(unique=true, nullable=false)
	private java.util.Date useddate;

	public UserCreditsUsedDetailPK() {
	}
	public int getUserid() {
		return this.userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public java.util.Date getUseddate() {
		return this.useddate;
	}
	public void setUseddate(java.util.Date useddate) {
		this.useddate = useddate;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserCreditsUsedDetailPK)) {
			return false;
		}
		UserCreditsUsedDetailPK castOther = (UserCreditsUsedDetailPK)other;
		return 
			(this.userid == castOther.userid)
			&& this.useddate.equals(castOther.useddate);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userid;
		hash = hash * prime + this.useddate.hashCode();
		
		return hash;
	}
}