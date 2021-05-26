package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Hotel;
import com.example.repository.HotelRepository;

@Service
@Transactional
public class HotelService {

	@Autowired
	private HotelRepository repository;

	/**
	 * 指定した価格以下のホテルのリストを取得する.
	 * 
	 * @param price この価格以下のホテルを取得する
	 * @return 指定した価格以下のホテルのドメインが価格の降順で入ったリスト
	 */
	public List<Hotel> serchByLessThanPrice(int price) {
		return repository.findByLessThanPrice(price);
	}

	public List<Hotel> showAllHotel() {
		return repository.findAll();
	}
}
