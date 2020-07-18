package com.higashi.players.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import com.higashi.players.entity.UserTable;

public class LoginUserDetails extends org.springframework.security.core.userdetails.User {

	@Autowired
	UserTable userTable;

	public LoginUserDetails(UserTable userTable) {
		super(userTable.getEmail(), userTable.getPassword(), Collections.emptySet());
		this.userTable = userTable;
	}

}
