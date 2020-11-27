package com.pyxis.panelapiclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.srisairam.http.HttpResponce;

import com.pyxis.utils.SingleUserDetails;

@Component
public class HttpUserPanelClientImpl {

	UserPanelClientImpl upc;
	private String userName;

	@Autowired
	SingleUserDetails singleUserDetails;

	@Value("${http.user.panel.url}")
	String httpUrl;

	private void createClinetObject(String userName, String password) {
		this.userName = userName;
		try {
			upc = new UserPanelClientImpl(httpUrl, userName, password);
		} catch (Exception ex) {
			upc = new UserPanelClientImpl("", userName, password);
		}
	}

	public void addUser(String userId) {
		HttpResponce resp = upc.addUser(userId);
		if (resp == null) {
			// Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
			// userId + " API NOT PRESENT ");

		}

	}

	public void editUser(String userId) {
		HttpResponce resp = upc.editUser(userId);
		if (resp == null) {
			// Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
			// userId + " API NOT PRESENT ");

		}
	}

	public void login() {
		HttpResponce resp = upc.login();
		if (resp == null) {
			// Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
			// userName + " API NOT PRESENT ");

		}
	}

	public UserPanelClientImpl getUserPanel() {
		return upc;
	}

	public long getCredits(int userid) {
		HttpResponce resp = upc.getCredits();
		if (resp != null) {
			return resp.getUserDetails().getCredits();
		}
		long credits = singleUserDetails.loadRemainingCredits(userid);
		return credits;
	}

	public void loadSenderid() {
		HttpResponce resp = upc.loadSenderIds();
		if (resp == null) {
			// Logger.getLogger(WebUserPanelImple.class.getName()).log(Level.SEVERE,
			// userName + " API NOT PRESENT");

		}
	}

	public HttpResponce addCredits(long credits) {
		return upc.addUsedCredits(credits);
	}

	public void loadGroupid() {
	}

	public void loadConcats() {
	}
}
