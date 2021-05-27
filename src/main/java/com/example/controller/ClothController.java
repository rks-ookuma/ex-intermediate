package com.example.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Cloth;
import com.example.form.ClothSerchForm;
import com.example.service.ClothService;

/**
 * 衣類関連の制御をするコントローラークラス.
 *
 * @author takahiro.okuma
 */
@Controller
@RequestMapping("/cloth")
public class ClothController {

	@Autowired
	private ClothService service;

	@ModelAttribute
	public ClothSerchForm setUpClothSerchForm() {
		return new ClothSerchForm();
	}

	/**
	 * 衣類検索画面を表示する.
	 *
	 * @param model リクエストスコープ
	 * @return 衣類検索画面
	 */
	@RequestMapping("")
	public String index(Model model) {

		List<String> colorList = new LinkedList<>();
		colorList.add("赤");
		colorList.add("青");
		colorList.add("白");
		colorList.add("黄");

		model.addAttribute("colorList", colorList);

		return "cloth/cloth";
	}

	/**
	 * 入力された性別、色の衣類のリストを表示する衣類検索画面を表示する.
	 *
	 * @param clothSerchForm 衣類検索の際に利用されるフォーム
	 * @param result         入力値チェックのエラー群
	 * @param model          リクエストスコープ
	 * @return 検索された衣類がスコープに入った衣類検索画面
	 */
	@RequestMapping("/serchCloth")
	public String serchCloth(@Validated ClothSerchForm clothSerchForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return index(model);
		}

		List<Cloth> clothList = service.serchClothByGenderAndColor(clothSerchForm.getGender(),
				clothSerchForm.getColor());

		System.out.println("size:" + clothList.size());
		if (clothList.size() == 0) {
			System.out.println("検索結果０");
			model.addAttribute("serch0Case", "検索結果は0件でした");
		}

		model.addAttribute("clothList", clothList);

		return index(model);
	}
}
