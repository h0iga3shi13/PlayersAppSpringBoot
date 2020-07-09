package com.higashi.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.higashi.players.dto.AddRequest;
import com.higashi.players.entity.Add;
import com.higashi.players.service.AddService;

@Controller
public class AddController {

	@Autowired
	AddService addService;

	//	@RequestMapping(value = "/add", method = RequestMethod.GET)
	//	public String add(Model model) {
	//		return "add.html";
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
		return "addlist.html";
	}

	/**
	 * フォーム入力画面を表示
	//	 * @param model Model
	//	 * @return form画面
	//	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String displayform(Model model) {
		model.addAttribute("addRequest", new AddRequest());
		return "add.html";
	}

	/*
	 * 新規ユーザー登録 送信
	 */
	@RequestMapping(value = "/addcreate", method = RequestMethod.POST)
	public String create(@ModelAttribute AddRequest addRequest, Model model) {
		// add情報の登録
		addService.create(addRequest);
		return "redirect:/addlist.html"; // URLの再読み込み
	}

	// 入力情報確認
	@RequestMapping(value = "/addconfirm", method = RequestMethod.POST)
	public String confirm(AddRequest addRequest, Model model) {
		model.addAttribute("addRequest", addRequest);
		return "addconfirm.html";
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
		return "redirect:/addlist.html";
	}

}
