/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyxis.users;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author HP
 */
public class UserToken implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String username;
	private String displayname;
	private Integer userType;
	private String role;
	private String password;
	private String requestForApproval;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private Collection<GrantedAuthority> authorities;
	private String email;
	private String favoritePage;
	private Integer smppId;
	private Integer smsSendType;
	private Long createdBy; 
	private Long availableCredits;

	public UserToken(Long userId, String name, String password2, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities,
			Integer userType, Integer smppId, Integer smsSendType) {
		this.id = userId;
		this.username = name;
		this.password = password2;
		this.enabled = enabled;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialsNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.authorities = authorities;
		this.userType = userType;
		this.smppId = smppId;
		this.smsSendType = smsSendType;
		this.role = ""+userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayname() {
		return displayname;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getRequestForApproval() {
		return requestForApproval;
	}

	public void setRequestForApproval(String requestForApproval) {
		this.requestForApproval = requestForApproval;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 *
	 * @return favorite page
	 */
	public String getFavoritePage() {
		return favoritePage;
	}

	/**
	 *
	 * @param favoritePage
	 */
	public void setFavoritePage(String favoritePage) {
		this.favoritePage = favoritePage;
	}

	public Integer getSmppId() {
		return smppId;
	}

	public void setSmppId(Integer smppId) {
		this.smppId = smppId;
	}

	public Integer getSmsSendType() {
		return smsSendType;
	}

	public void setSmsSendType(Integer smsSendType) {
		this.smsSendType = smsSendType;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getAvailableCredits() {
		return availableCredits;
	}

	public void setAvailableCredits(Long availableCredits) {
		this.availableCredits = availableCredits;
	}
}
