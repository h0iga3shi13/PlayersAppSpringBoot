package com.higashi.players.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.higashi.players.entity.UserTable;
import com.higashi.players.repository.UserTableRepository;

@Service
@Transactional
public class UserAddService {

	@Autowired
	UserTableRepository userTableRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public UserTable create(UserTable usertable, String rawPassword) {
		String encodedPassword = passwordEncoder.encode(rawPassword);
		usertable.setPassword(encodedPassword);
		return userTableRepository.save(usertable);
	}
}
