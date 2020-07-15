package com.higashi.players.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

/*
 * Form入力情報 リクエストデータ
 */
@Data
public class BBSForm implements Serializable {

	@NotBlank(message = "ユーザー名を入力してください")
	@Size(max = 64)
	private String name;

	@NotBlank(message = "チーム名を入力してください")
	@Size(max = 64)
	private String team;

	@NotNull
	@Future
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate event;

	@NotNull
	@Future
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate deadline;

	@NotBlank(message = "募集エリアを選択してください")
	@Size(max = 128)
	private String area;

	@NotBlank(message = "試合会場を選択してください")
	@Size(max = 128)
	private String venue;

	@NotNull
	@Min(0)
	private Integer cost;

	@NotNull
	@Min(0)
	private Integer capacity;

	@NotNull
	@Min(0)
	@Max(5)
	private Integer level;

	@NotBlank(message = "募集の種類を選択してください")
	@Size(max = 64)
	private String type;

	@NotBlank(message = "本文を入力してください")
	@Size(max = 512)
	private String text;

}
