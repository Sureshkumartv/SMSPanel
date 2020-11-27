package com.pyxis.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.srisairam.beans.SenderIdBean;

import com.pyxis.users.UserDAO;

@Component
public class SingleUserDetails {

	@Autowired
	UserDAO userdao;

	public long getCredits(Integer userid) {
		try {
			return userdao.getUserSmsCount(userid.longValue());
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, userid + "", ex);
		}
		return 0;
	}

	public long getUsedCredits(Integer userid) {
		try {
			
			return userdao.getUserUsedCredits(userid.longValue());
		} catch (Exception ex) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, userid + "  ", ex);

		} 
		return 0;
	}

	public long loadRemainingCredits(Integer userID) {
		long userCredits = getCredits(userID);
		long userUsedCredits = getUsedCredits(userID);
		long remainingCredist = userCredits - userUsedCredits;
		return remainingCredist;
	}
}
