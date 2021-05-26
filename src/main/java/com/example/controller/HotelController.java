package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelSerchForm;
import com.example.service.HotelService;

/**
 * ホテル関連の制御を行うコントローラー.
 * 
 * @author takahiro.okuma
 *
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {

	@ModelAttribute
	public HotelSerchForm setUpHotelSerchForm() {
		return new HotelSerchForm();
	}

	@Autowired
	private HotelService service;

	/**
	 * ホテルの検索画面を表示させる.
	 * 
	 * @return ホテルの検索画面
	 */
	@RequestMapping("")
	public String index() {
		return "hotel/hotelSerch";
	}

	/**
	 * 入力された価格以下のホテルを表示した検索画面を表示させる.
	 * 
	 * @param hotelSerchForm ホテルの検索の際に利用されるフォーム
	 * @param result         入力値チェックのエラー群
	 * @param model          リクエストスコープ
	 * @return ホテルの検索画面
	 */
	@RequestMapping("/serchHotel")
	public String serchHotel(@Validated HotelSerchForm hotelSerchForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "hotel/hotelSerch";
		}

		List<Hotel> hotelList = new ArrayList<>();

		if (hotelSerchForm.getPrice() == null) {
			hotelList = service.showAllHotel();
		} else {
			hotelList = service.serchByLessThanPrice(hotelSerchForm.getPrice());
		}

		model.addAttribute("hotelList", hotelList);
		return "hotel/hotelSerch";

	}
}
