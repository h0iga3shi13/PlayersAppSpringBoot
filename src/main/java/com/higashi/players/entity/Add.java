package com.higashi.players.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * Add Entity
 */
@Entity
@Data
@Table(name = "add_master")
public class Add {

	/*
	 * add ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/*
	 * 名前
	 */
	@Column(name = "name")
	private String name;

	/*
	 * 所属チーム名(bbs情報と紐付けする)
	 */
	@Column(name = "teamid")
	private String team;

	/*
	 * 電話番号
	 */
	@Column(name = "phone")
	private String phone;

	/*
	 * メールアドレス
	 */
	@Column(name = "email")
	private String Email;

	/*
	 * 住所
	 */
	@Column(name = "address")
	private String address;

	/*
	 * ポジション
	 */
	@Column(name = "position")
	private String position;

	/*
	 * パスワード
	 */
	@Column(name = "password")
	private String password;

	/*
	 * 更新日時
	 */
	@Column(name = "update_date")
	private LocalDateTime updateDate;

	/**
	 * 登録日時
	 */
	@Column(name = "create_date")
	private LocalDateTime createDate;

	/**
	 * 削除日時
	 */
	@Column(name = "delete_date")
	private LocalDateTime deleteDate;

}
