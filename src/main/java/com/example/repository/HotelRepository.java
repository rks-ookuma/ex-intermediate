package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテルテーブルの操作をするリポジトリ.
 * 
 * @author takahiro.okuma
 *
 */
@Repository
public class HotelRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_HOTELS = "hotels";

	private static final RowMapper<Hotel> HOTEL_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

	/**
	 * 指定した価格以下のホテルのリストを取得する.
	 * 
	 * @param price この価格以下のホテルを取得する
	 * @return 指定した価格以下のホテルのドメインが値段の降順で入っているリスト
	 */
	public List<Hotel> findLessPrice(int price) {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM " + TABLE_HOTELS
				+ " WHERE price <= :price ORDER BY price DESC;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);

		return hotelList;
	}

	/**
	 * ホテルを全件取得する.
	 * 
	 * @return 全ホテルのドメインが価格の降順で入ったリスト
	 */
	public List<Hotel> findAll() {
		String sql = "SELECT id,area_name,hotel_name,address,nearest_station,price,parking FROM " + TABLE_HOTELS
				+ " ORDER BY price DESC;";
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;
	}
}
