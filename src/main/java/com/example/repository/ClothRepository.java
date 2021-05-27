package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Cloth;

/**
 * 衣類テーブルを操作するリポジトリ.
 *
 * @author takahiro.okuma
 */
@Repository
public class ClothRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_CLOTHES = "clothes";

	private static final RowMapper<Cloth> CLOTH_ROW_MAPPER = new BeanPropertyRowMapper<>(Cloth.class);
//			(rs, i) -> {
//		Cloth cloth = new Cloth();
//		cloth.setId(rs.getInt("id"));
//		cloth.setCategory(rs.getString("category"));
//		cloth.setGenre(rs.getString("genre"));
//		cloth.setGender(rs.getInt("gender"));
//		cloth.setColor(rs.getString("color"));
//		cloth.setPrice(rs.getInt("price"));
//		cloth.setSize(rs.getString("size"));
//		return cloth;
//	};

	/**
	 * 指定した性別でかつ指定した色の衣類のリストを取得する.
	 * 
	 * @param gender 取得したい衣類の性別
	 * @param color  取得したい衣類の色
	 * @return 指定された性別でかつ色の衣類が価格の昇順で入ったリスト
	 */
	public List<Cloth> findByGenderAndColor(String gender, String color) {
		String sql = "SELECT id,category,genre,gender,color,price,size FROM " + TABLE_CLOTHES
				+ " WHERE gender=:gender AND color=:color ORDER BY price;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("gender", Integer.parseInt(gender))
				.addValue("color", color);
		List<Cloth> clothList = template.query(sql, param, CLOTH_ROW_MAPPER);
		return clothList;
	}
}
