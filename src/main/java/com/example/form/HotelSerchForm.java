package com.example.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

/**
 * ホテルの価格検索の際に利用するフォーム.
 * 
 * @author takahiro.okuma
 *
 */
public class HotelSerchForm {

	/** 検索したい価格 */
	@Range(min = 0, message = "金額を入力してください")
	@Pattern(regexp = "^[0-9]+", message = "半角数字で入力してください")
	private Integer price;

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelSerchForm [price=" + price + "]";
	}

}
