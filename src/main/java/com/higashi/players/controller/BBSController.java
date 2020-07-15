package com.higashi.players.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.dto.BBSForm;
import com.higashi.players.service.BBSService;

/*
 * BBS Controller
 */
@Controller
public class BBSController {
	@Autowired
	BBSService bbsService;

	/**
	 * フォーム入力画面を表示
	 * @param model Model
	 * @return form画面
	 */
	@RequestMapping(value = "/bbs/form", method = RequestMethod.GET)
	public String displayform(@ModelAttribute("formRequest") BBSForm formRequest, Model model) {
		//		model.addAttribute("formRequest", new BBSForm());
		return "bbsForm";
	}

	/**
	 * フォーム登録画面
	 * @param BBSForm リクエストデータ
	 * @param model Model
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(BBSForm formRequest) { //formの中身をdbに送る
		// BBS情報の登録
		bbsService.create(formRequest);
		return "redirect:/"; // URLの再読み込み
	}

	/*
	 * 確認画面
	 */
	@RequestMapping(value = "/bbs/confirm", method = RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute("formRequest") BBSForm formRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			//			model.addAttribute("formRequest", formRequest);
			return "bbsForm";
		}
		//		model.addAttribute("formRequest", formRequest);
		//		System.out.println("なまえは" + formRequest.getName());
		return "bbsConfirm";
	}

	//	@PostMapping("/bbs/confirm")
	//	public String confirm(@Valid BBSForm formRequest,
	//			BindingResult result) {
	//		if (result.hasErrors()) {
	//			return "bbsForm";
	//		}
	//		return "bbsConfirm";
	//	}

}
