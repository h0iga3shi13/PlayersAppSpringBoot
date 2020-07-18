package com.higashi.players.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.dto.LoginForm;
import com.higashi.players.entity.UserTable;
import com.higashi.players.service.LoginUserDetails;
import com.higashi.players.service.UserAddService;

@Controller
public class UserController {
	@Autowired
	UserAddService userAddService;

	@ModelAttribute
	public LoginForm setupForm() {
		return new LoginForm();
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	String registForm(@ModelAttribute("registForm") LoginForm registForm) {
		return "userRegistration";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	String create(LoginForm registForm) {
		// TODO 自動生成されたメソッド・スタブ

		UserTable table = new UserTable();
		table.setEmail(registForm.getEmail());
		userAddService.create(table, registForm.getPassword());
		return "redirect:/login";
	}

	@GetMapping("/success")
	public LoginUserDetails loginSuccess() {
		LoginUserDetails userDetails = (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		return userDetails;
	}
}
