package com.higashi.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.entity.BBS;
import com.higashi.players.service.BBSService;

@Controller
public class CommonController {

	@Autowired
	BBSService bbsService;

	// HOME画面
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home.html";
	}

	/*
	 * BBS画面
	 * BBS 一覧画面を表示
	 *
	 */
	@RequestMapping(value = "/bbs", method = RequestMethod.GET)
	public String list(Model model) {
		List<BBS> bbslist = bbsService.searchAll();
		model.addAttribute("bbslist", bbslist);
		return "bbs";
	}

	/*
	 * add画面
	 * 新規ユーザー登録入力フォーム画面を表示
	 */
	//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	//	public String add(Model model) {
	//		return "add";
	//	}

	// team画面
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team(Model model) {
		return "team";
	}

	// login画面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	// confirm画面
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(Model model) {
		return "confirm";
	}

}
