package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Team;
import com.example.repository.BaseballTeamRepository;

/**
 * 野球チーム関連の業務処理を行うクラス.
 * 
 * @author takahiro.okuma
 *
 */
@Service
public class BaseballTeamService {

	@Autowired
	private BaseballTeamRepository repository;

	/**
	 * 全野球チームを取得する.
	 * 
	 * @return 全野球チームのドメインの入ったリスト
	 */
	public List<Team> showList() {
		return repository.findAll();
	}

	/**
	 * 指定したIDの野球チームを取得する.
	 * 
	 * @param id 取得したい野球チームのID
	 * @return 指定したIDの野球チームドメイン
	 */
	public Team showDetail(int id) {
		return repository.findById(id);
	}

}
