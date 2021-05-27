package com.example.form;

import javax.validation.constraints.Pattern;

/**
 * ホテルの価格検索の際に利用するフォーム.
 * 
 * @author takahiro.okuma
 *
 */
public class HotelSerchForm {

	/** 検索したい価格 */
	@Pattern(regexp = "^[0-9]{0,6}$", message = "金額を半角数字で入力してください(最大6桁)")
	private String price;

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "HotelSerchForm [price=" + price + "]";
	}

}
