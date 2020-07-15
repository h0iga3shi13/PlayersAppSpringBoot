package com.higashi.players.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.higashi.players.dto.BBSForm;
import com.higashi.players.entity.BBS;
import com.higashi.players.repository.BBSRepository;

@Service
@Transactional(rollbackOn = Exception.class)
public class BBSService {

	/*
	 * BBS Repository
	 */
	@Autowired
	BBSRepository bbsRepository;

	/*
	 * BBS情報 全検索
	 * return 検索結果
	 */
	public List<BBS> searchAll() {
		return bbsRepository.findAll();
	}

	/*
	 * BBS情報新規登録
	 *
	 */
	public void create(BBSForm formRequest) {
		bbsRepository.save(createBBS(formRequest));
	}

	/*
	 * Entityの生成
	 * @param formRequest
	 * @return ユーザーTBL Entity
	 */

	private BBS createBBS(BBSForm formRequest) {
		//		Date now = new Date();

		BBS bbs = new BBS();
		bbs.setName(formRequest.getName());
		bbs.setEvent(formRequest.getEvent().atTime(0, 0, 0));
		bbs.setDeadline(formRequest.getDeadline().atTime(0, 0, 0));
		bbs.setArea(formRequest.getArea());
		bbs.setVenue(formRequest.getVenue());
		bbs.setCost(formRequest.getCost());
		bbs.setCapacity(formRequest.getCapacity());
		bbs.setLevel(formRequest.getLevel());
		bbs.setType(formRequest.getType());
		bbs.setText(formRequest.getText());

		bbs.setCreated(LocalDateTime.now()); // 作成日を自動生成

		return bbs;
	}

}
