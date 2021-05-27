package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Cloth;
import com.example.repository.ClothRepository;

/**
 * 衣類関連の業務処理を行うクラス.
 *
 * @author takahiro.okuma
 */
@Service
@Transactional
public class ClothService {

	@Autowired
	private ClothRepository repository;

	/**
	 * 指定した性別かつ色の衣類のリストを取得する.
	 *
	 * @param gender 取得したい衣類の性別
	 * @param color  取得したい衣類の色
	 * @return 指定した性別かつ色の衣類のドメインが価格の昇順で入ったリスト
	 */
	public List<Cloth> serchClothByGenderAndColor(String gender, String color) {
		return repository.findByGenderAndColor(gender, color);
	}
}
