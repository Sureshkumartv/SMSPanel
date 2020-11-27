package com.pyxis.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.pyxis.users.Users;


/**
 * The persistent class for the user_credits_details database table.
 * 
 */
@Entity
@Table(name="user_credits_details")
public class UserCreditsDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=150)
	private String description;

	private Integer givenby;

	@Column(nullable=false)
	private Timestamp givendate;

	@Column(nullable=false)
	private Integer price;

	@Column(nullable=false)
	private BigInteger smscount;

	//bi-directional many-to-one association to UserDetail
	@ManyToOne
	@JoinColumn(name="USERID", nullable=false)
	private Users userDetail;
	
	@Transient
	private String type;

	public UserCreditsDetail() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGivenby() {
		return this.givenby;
	}

	public void setGivenby(Integer givenby) {
		this.givenby = givenby;
	}

	public Timestamp getGivendate() {
		return this.givendate;
	}

	public void setGivendate(Timestamp givendate) {
		this.givendate = givendate;
	}

	public Integer getPrice() {
		return this.price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public BigInteger getSmscount() {
		return this.smscount;
	}

	public void setSmscount(BigInteger smscount) {
		this.smscount = smscount;
	}

	public Users getUserDetail() {
		return this.userDetail;
	}

	public void setUserDetail(Users userDetail) {
		this.userDetail = userDetail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}