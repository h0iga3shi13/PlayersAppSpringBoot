package com.higashi.players.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.higashi.players.entity.UserTable;

public interface UserTableRepository extends JpaRepository<UserTable, String> {

	public UserTable findByEmail(String email);
}
