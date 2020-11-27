package com.pyxis.utils;

import java.util.List;

import com.pyxis.contacts.Contacts;

public class FormRequestDetails {

	List<Long> idsList;

	List<Contacts> contacts;

	public List<Long> getIdsList() {
		return idsList;
	}

	public void setIdsList(List<Long> idsList) {
		this.idsList = idsList;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

}
