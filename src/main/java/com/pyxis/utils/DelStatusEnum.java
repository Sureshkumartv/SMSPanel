package com.pyxis.utils;

public enum DelStatusEnum {
	
	C("SUBMITTED"),
	DELIV("DELIVERED"),
	UNDELIV("UNDELIVERED"),
	UNDEL("UNDELIVERED");
	
	private String value;
	private DelStatusEnum(String status) {
		this.value = status;
	}
	
	
	public String getValue(){
		return this.value;
	}
	

}
