/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyxis.entities.EsmeInfo;
import com.pyxis.entities.UserCreditsDetail;

/**
 *
 * @author suresh
 */
@Entity
@Table(name = "user_details")

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5504709513426604020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	private Long userid;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "LOGINID")
	private String loginid;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "USERTYPE")
	private Integer usertype;

	@Column(name = "SMSSENDTYPE")
	private Integer smssendtype;

	@Column(name = "USERSTATUS")
	private Integer userstatus;

	@Column(name = "MOBILENUMBER")
	private String mobilenumber;

	@Column(name = "EMAILID")
	private String emailid;

	
	
	@ManyToOne
	@JoinColumn(name = "SMPPID")
	@NotFound(action = NotFoundAction.IGNORE)
	private EsmeInfo smppid;

	@Column(name = "USERCREATEDDATE")
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date usercreateddate;

	
	@ManyToOne
	@JoinColumn(name = "USERCREATEDBY")
	private Users usercreatedby;

	@Column(name = "USER_TIMEZONE")
	private String user_timezone;

	@Column(name = "DNDSTATUS")
	private Integer dndstatus;
	
	@OneToMany(mappedBy="userDetail" , fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<UserCreditsDetail> userCredits;
	
	
	@Transient
	private String createdBy;
	
	@Transient
	private UserCreditsDto userCreditsDto;

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the loginid
	 */
	public String getLoginid() {
		return loginid;
	}

	/**
	 * @param loginid
	 *            the loginid to set
	 */
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the usertype
	 */
	public Integer getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype
	 *            the usertype to set
	 */
	public void setUsertype(Integer usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the smssendtype
	 */
	public Integer getSmssendtype() {
		return smssendtype;
	}

	/**
	 * @param smssendtype
	 *            the smssendtype to set
	 */
	public void setSmssendtype(Integer smssendtype) {
		this.smssendtype = smssendtype;
	}

	/**
	 * @return the userstatus
	 */
	public Integer getUserstatus() {
		return userstatus;
	}

	/**
	 * @param userstatus
	 *            the userstatus to set
	 */
	public void setUserstatus(Integer userstatus) {
		this.userstatus = userstatus;
	}

	/**
	 * @return the mobilenumber
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * @param mobilenumber
	 *            the mobilenumber to set
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * @return the emailid
	 */
	public String getEmailid() {
		return emailid;
	}

	/**
	 * @param emailid
	 *            the emailid to set
	 */
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	/**
	 * @return the smppid
	 */
	public EsmeInfo getSmppid() {
		return smppid;
	}

	/**
	 * @param smppid
	 *            the smppid to set
	 */
	public void setSmppid(EsmeInfo smppid) {
		this.smppid = smppid;
	}

	/**
	 * @return the usercreateddate
	 */
	public Date getUsercreateddate() {
		return usercreateddate;
	}

	/**
	 * @param usercreateddate
	 *            the usercreateddate to set
	 */
	public void setUsercreateddate(Date usercreateddate) {
		this.usercreateddate = usercreateddate;
	}

	/**
	 * @return the usercreatedby
	 */
	@JsonIgnore
	public Users getUsercreatedby() {
		return usercreatedby;
	}

	/**
	 * @param usercreatedby
	 *            the usercreatedby to set
	 */
	public void setUsercreatedby(Users usercreatedby) {
		this.usercreatedby = usercreatedby;
	}

	/**
	 * @return the user_timezone
	 */
	public String getUser_timezone() {
		return user_timezone;
	}

	/**
	 * @param user_timezone
	 *            the user_timezone to set
	 */
	public void setUser_timezone(String user_timezone) {
		this.user_timezone = "+05:30";
	}

	/**
	 * @return the dndstatus
	 */
	public Integer getDndstatus() {
		return dndstatus;
	}

	/**
	 * @param dndstatus
	 *            the dndstatus to set
	 */
	public void setDndstatus(Integer dndstatus) {
		this.dndstatus = 1;
	}

	@PrePersist
	public void setDefaults() {
		if (null == usercreateddate) {
			this.usercreateddate = new Date();
		}

		 if(null == password){
			 this.password = "Reset@123";
		 }
	}

	@PreUpdate
	public void setUpdateValues() {
	}

	public String getCreatedBy() {
		return usercreatedby.getUsername();
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonIgnore
	public List<UserCreditsDetail> getUserCredits() {
		return userCredits;
	}

	public void setUserCredits(List<UserCreditsDetail> userCredits) {
		this.userCredits = userCredits;
	}

	@Transient
	public UserCreditsDto getUserCreditsDto() {
		return userCreditsDto;
	}

	public void setUserCreditsDto(UserCreditsDto userCreditsDto) {
		this.userCreditsDto = userCreditsDto;
	}

}
