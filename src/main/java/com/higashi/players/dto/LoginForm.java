package com.higashi.players.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginForm implements Serializable {
	private String email;
	private String password;
}
