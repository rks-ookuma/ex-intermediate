package com.example.domain;

/**
 * 衣類を表すドメイン.
 *
 * @author takahiro.okuma
 */
public class Cloth {

	/** ID */
	private Integer id;
	/** カテゴリー */
	private String category;
	/** ジャンル */
	private String genre;
	/** 性別（０：男、１：女） */
	private Integer gender;
	/** 服の色 */
	private String color;
	/** 価格 */
	private Integer price;
	/** サイズ */
	private String size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", category=" + category + ", genre=" + genre + ", gender=" + gender + ", color="
				+ color + ", price=" + price + ", size=" + size + "]";
	}

}
