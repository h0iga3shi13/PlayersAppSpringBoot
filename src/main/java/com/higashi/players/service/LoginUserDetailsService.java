package com.higashi.players.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.higashi.players.entity.UserTable;
import com.higashi.players.repository.UserTableRepository;

public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserTableRepository userTableRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//入力されたUserIDを条件にDBからデータを取得する
		UserTable userTable = userTableRepository.findByEmail(email);

		// 入力値（ユーザーID、パスワード）とインスタンス化したDemoUserDetailsクラスを
		// SpringSecurityの内部で比較することで、ログインチェックを行っている。
		return new LoginUserDetails(userTable);
	}

}
