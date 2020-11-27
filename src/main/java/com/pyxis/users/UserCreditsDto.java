package com.pyxis.users;

import java.io.Serializable;

public class UserCreditsDto  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -473133282545124744L;
	private Long credits;
	private Long usedCredits;
	private Long remainingCredits;
	
	public UserCreditsDto() {
		// TODO Auto-generated constructor stub
	}

	public UserCreditsDto(Long userSmsCount, Long userUsedCredits) {
		this.credits = userSmsCount;
		this.usedCredits = userUsedCredits;
		if(null != userSmsCount && null != userUsedCredits)
		this.remainingCredits = userSmsCount - userUsedCredits;
	}

	public Long getCredits() {
		return credits == null ? 0l : credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public Long getUsedCredits() {
		return usedCredits == null ? 0l : usedCredits ;
	}

	public void setUsedCredits(Long usedCredits) {
		this.usedCredits = usedCredits;
	}

	public Long getRemainingCredits() {
		return remainingCredits == null ? 0l : remainingCredits;
	}

	public void setRemainingCredits(Long remainingCredits) {
		this.remainingCredits = remainingCredits;
	}

}
