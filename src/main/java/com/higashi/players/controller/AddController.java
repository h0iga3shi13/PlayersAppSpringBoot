package com.higashi.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.dto.AddForm;
import com.higashi.players.entity.Add;
import com.higashi.players.service.AddService;

@Controller
public class AddController {

	@Autowired
	AddService addService;

	//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	//	public String add(Model model) {
	//		return "add";
	//	}

	/**
	 * ユーザー情報一覧画面を表示
	 * @param model Model
	 * @return ユーザー情報一覧画面
	 */
	@RequestMapping(value = "/addlist", method = RequestMethod.GET)
	public String displayList(Model model) {
		List<Add> userlist = addService.searchAll();
		model.addAttribute("userlist", userlist);
		return "addlist";
	}

	/**
	 * フォーム入力画面を表示
	//	 * @param model Model
	//	 * @return form画面
	//	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayform(@ModelAttribute("addRequest") AddForm addRequest, Model model) {
		return "add";
	}

	/*
	 * 新規ユーザー登録 送信
	 */
	@RequestMapping(value = "/addcreate", method = RequestMethod.POST)
	public String create(AddForm addRequest) { //formの中身をdbに送信
		// add情報の登録
		addService.create(addRequest);
		return "redirect:/addlist"; // URLの再読み込み
	}

	// 入力情報確認
	@RequestMapping(value = "/add/confirm", method = RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute("addRequest") AddForm addRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			return "add";
		}

		//		model.addAttribute("addRequest", addRequest);
		return "addConfirm";
	}

	/**
	 * ユーザー情報削除
	 * value= list.htmlの form th:action="@{/user/delete}" の部分と紐付ける
	 * method= list.htmlの"post" (メソッドによって表示する内容を変更する  削除ボタンが押されるとデータ削除)
	 * paramas リクエストパラメーターを指定できる
	 * param = "formで付与した name属性のdelete"
	 * @return 遷移先
	 */

	@RequestMapping(value = "/adddelete", method = RequestMethod.POST)
	public String delete(Long id) {
		addService.delete(id);
		return "redirect:/addlist";
	}

}
