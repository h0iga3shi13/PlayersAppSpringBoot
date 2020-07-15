package com.higashi.players.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

/*
 * 会員登録form リクエストデータ
 */
@Data
public class AddForm implements Serializable {

	/*
	 * 名前(ユーザー名)
	 */
	@NotBlank(message = "名前を入力してください")
	@Size(max = 64)
	private String name;

	/*
	 * 所属チーム名(bbs情報と紐付けする)
	 */
	@NotBlank(message = "所属チーム名を入力してください")
	@Size(max = 64)
	private String team;

	/*
	 * 電話番号
	 */
	@NotBlank(message = "電話番号を入力してください")
	@Min(0)
	private String phone;

	/*
	 * メールアドレス
	 */
	@NotBlank(message = "メールアドレスを入力してください")
	@Size(max = 128)
	@Email
	private String email;

	/*
	 * 住所
	 */
	@NotBlank(message = "住所を入力してください")
	@Size(max = 512)
	private String address;

	/*
	 * ポジション
	 */
	private String position;

	/*
	 * パスワード
	 */
	@NotBlank(message = "パスワードを設定してください")
	private String password;

}
