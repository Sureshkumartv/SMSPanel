package com.techniecode.entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the esme_info database table.
 * 
 */
@Entity
@Table(name="longapp_main_user")
public class LongappMainUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	  private Integer userId;
	
	  @Column(name = "user_name")
	  private String userName;
	  
	  @Column(name = "email")
	  private String email;
	  
	  @Column(name = "password")
	  private String password;
	  
	  @Column(name = "activation_code")
	  private String activationCode;
	  
	  @Column(name = "real_name")
	  private String realName;
	  
	  @Column(name = "active")
	  private Integer active;
	  
	  @Column(name = "auth_OpenID")
	  private String authOpenID;
	  
	  @Column(name = "auth_Facebook")
	  private String authFacebook;
	  
	  @Column(name = "auth_Twitter")
	  private String authTwitter;
	  
	  @Column(name = "auth_Google")
	  private String authGoogle;
	  
	  @Column(name = "auth_Yahoo")
	  private String authYahoo;
	  
	  @Column(name = "auth_LinkedIn")
	  private String authLinkedIn;
	  
	  @Column(name = "auth_MySpace")
	  private String authMySpace;
	  
	  @Column(name = "auth_Foursquare")
	  private String authFoursquare;
	  
	  @Column(name = "auth_AOL")
	  private String authAOL;
	  
	  @Column(name = "auth_Live")
	  private String authLive;
	 
	  @Column(name = "language")
	  private String language;
	  
	  @Column(name = "theme")
	  private String theme;
	  
	  @Column(name = "birthdate")
	  private Date birthdate;
	  
	  @Column(name = "sex")
	  private String sex;
	  
	  @Column(name = "profile_picture")
	  private String profilePicture;
	  
	  @Column(name = "self_description")
	  private String selfDescription;
	  
	  @Column(name = "last_active")
	  private String lastActive;
	  
	  @Column(name = "login")
	  private Integer login;
	  
	  @Column(name = "subsite")
	  private String subsite;
	  
	  @Column(name = "_created_at")
	  private Date _createdAt;
	  
	  @Column(name = "_updated_at")
	  private Date _updatedAt;
	  
	  @Column(name = "_created_by")
	  private Integer _createdBy;
	  
	  @Column(name = "_updated_by")
	  private Integer _updatedBy;
	  
	  @Column(name = "deactivateDate")
	  private Date deactivateDate;
	  
	  @Column(name = "firstName")
	  private String firstName;
	  
	  @Column(name = "lastName")
	  private String lastName;
	  
	  @Column(name = "directPhone")
	  private String directPhone;
	  
	  @Column(name = "companyName")
	  private String companyName;
	
	  @Column(name = "ipaddress")
	  private String ipaddress;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getAuthOpenID() {
		return authOpenID;
	}

	public void setAuthOpenID(String authOpenID) {
		this.authOpenID = authOpenID;
	}

	public String getAuthFacebook() {
		return authFacebook;
	}

	public void setAuthFacebook(String authFacebook) {
		this.authFacebook = authFacebook;
	}

	public String getAuthTwitter() {
		return authTwitter;
	}

	public void setAuthTwitter(String authTwitter) {
		this.authTwitter = authTwitter;
	}

	public String getAuthGoogle() {
		return authGoogle;
	}

	public void setAuthGoogle(String authGoogle) {
		this.authGoogle = authGoogle;
	}

	public String getAuthYahoo() {
		return authYahoo;
	}

	public void setAuthYahoo(String authYahoo) {
		this.authYahoo = authYahoo;
	}

	public String getAuthLinkedIn() {
		return authLinkedIn;
	}

	public void setAuthLinkedIn(String authLinkedIn) {
		this.authLinkedIn = authLinkedIn;
	}

	public String getAuthMySpace() {
		return authMySpace;
	}

	public void setAuthMySpace(String authMySpace) {
		this.authMySpace = authMySpace;
	}

	public String getAuthFoursquare() {
		return authFoursquare;
	}

	public void setAuthFoursquare(String authFoursquare) {
		this.authFoursquare = authFoursquare;
	}

	public String getAuthAOL() {
		return authAOL;
	}

	public void setAuthAOL(String authAOL) {
		this.authAOL = authAOL;
	}

	public String getAuthLive() {
		return authLive;
	}

	public void setAuthLive(String authLive) {
		this.authLive = authLive;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public String getSelfDescription() {
		return selfDescription;
	}

	public void setSelfDescription(String selfDescription) {
		this.selfDescription = selfDescription;
	}

	public String getLastActive() {
		return lastActive;
	}

	public void setLastActive(String lastActive) {
		this.lastActive = lastActive;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public String getSubsite() {
		return subsite;
	}

	public void setSubsite(String subsite) {
		this.subsite = subsite;
	}

	public Date get_createdAt() {
		return _createdAt;
	}

	public void set_createdAt(Date _createdAt) {
		this._createdAt = _createdAt;
	}

	public Date get_updatedAt() {
		return _updatedAt;
	}

	public void set_updatedAt(Date _updatedAt) {
		this._updatedAt = _updatedAt;
	}

	public Integer get_createdBy() {
		return _createdBy;
	}

	public void set_createdBy(Integer _createdBy) {
		this._createdBy = _createdBy;
	}

	public Integer get_updatedBy() {
		return _updatedBy;
	}

	public void set_updatedBy(Integer _updatedBy) {
		this._updatedBy = _updatedBy;
	}

	public Date getDeactivateDate() {
		return deactivateDate;
	}

	public void setDeactivateDate(Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDirectPhone() {
		return directPhone;
	}

	public void setDirectPhone(String directPhone) {
		this.directPhone = directPhone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	  

}