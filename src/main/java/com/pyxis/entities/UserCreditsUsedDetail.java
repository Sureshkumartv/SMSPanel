package com.pyxis.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the user_credits_used_details database table.
 * 
 */
@Entity
@Table(name="user_credits_used_details")
@NamedQuery(name="UserCreditsUsedDetail.findAll", query="SELECT u FROM UserCreditsUsedDetail u")
public class UserCreditsUsedDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserCreditsUsedDetailPK id;

	@Column(nullable=false)
	private BigInteger credits;

	public UserCreditsUsedDetail() {
	}

	public UserCreditsUsedDetailPK getId() {
		return this.id;
	}

	public void setId(UserCreditsUsedDetailPK id) {
		this.id = id;
	}

	public BigInteger getCredits() {
		return this.credits;
	}

	public void setCredits(BigInteger credits) {
		this.credits = credits;
	}

}