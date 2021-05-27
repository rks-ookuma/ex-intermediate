package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

/**
 * ホテルに関する業務処理を行うクラス.
 * 
 * @author takahiro.okuma
 *
 */
@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;

	/**
	 * 指定した価格以下のホテルのリストを取得する.
	 * 
	 * @param price この価格以下のホテルを取得する
	 * @return 指定した価格以下のホテルのドメインが価格の降順で入ったリスト、または入力がない場合全ホテルのドメインが価格の降順で入ったリスト
	 */
	public List<Hotel> serchByLessThanPrice(String inPrice) {
		List<Hotel> hotelList = new ArrayList<>();
		if (inPrice.isBlank()) {
			hotelList = repository.findAll();
		} else {
			hotelList = repository.findByLessThanPrice(Integer.parseInt(inPrice));
		}

		return hotelList;
	}

	/**
	 * DBにホテルのデータが存在するかを確かめる.
	 * 
	 * @return 存在しなければtrue、1件でも存在していればfalse
	 */
	public boolean existHotelData() {
		if (repository.count() == 0) {
			return true;
		}

		return false;
	}
}
