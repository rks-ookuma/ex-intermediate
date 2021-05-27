package com.example.form;

/**
 * 衣類検索を行うときに利用されるフォーム.
 *
 * @author takahiro.okuma
 */
public class ClothSerchForm {

	/** 検索したい衣類の性別 */
	private String gender;
	/** 検索したい衣類の色 */
	private String color;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ClothSerchForm [gender=" + gender + ", color=" + color + "]";
	}

}
