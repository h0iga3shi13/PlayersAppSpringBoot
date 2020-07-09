package com.higashi.players.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higashi.players.dto.AddRequest;
import com.higashi.players.entity.Add;
import com.higashi.players.repository.AddRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class AddService {

	/*
	 * Add Repository
	 */
	@Autowired
	AddRepository addRepository;

	/*
	 * 会員登録情報 全検索
	 * return 検索結果
	 */
	public List<Add> searchAll() {
		return addRepository.findAll();
	}

	/*
	 * 会員情報 新規登録
	 */
	public void create(AddRequest addRequest) {
		addRepository.save(createAdd(addRequest));
	}

	/**
	 * ユーザー情報削除
	 * userRepository.deleteById()メソッドを使って削除処理を行うdelete()メソッド
	 */
	public void delete(Long id) {
		addRepository.deleteById(id);

	}

	/*
	 * Entityの生成
	 * @param addRequest
	 * @return ユーザーTBL Entity
	 */
	private Add createAdd(AddRequest addRequest) {

		Add add = new Add();
		add.setName(addRequest.getName());
		add.setTeam(addRequest.getTeam());
		add.setPhone(addRequest.getPhone());
		add.setEmail(addRequest.getEmail());
		add.setAddress(addRequest.getAddress());
		add.setPosition(addRequest.getPosition());
		add.setPassword(addRequest.getPassword());

		add.setCreateDate(LocalDateTime.now());
		add.setUpdateDate(LocalDateTime.now());

		return add;
	}

}
