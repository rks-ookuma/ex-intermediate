package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Team;
import com.example.service.TeamService;

/**
 * 野球チーム関連の制御をするコントローラー.
 * 
 * @author takahiro.okuma
 *
 */
@Controller
@RequestMapping("/baseballTeam")
public class TeamController {

	@Autowired
	private TeamService service;

	/**
	 * 野球チームの一覧を表示する.
	 * 
	 * @param model リクエストスコープ
	 * @return 野球チーム一覧画面
	 */
	@RequestMapping("")
	public String index(Model model) {

		List<Team> teamList = service.showList();
		model.addAttribute("teamList", teamList);

		return "baseball/list";
	}

	/**
	 * 野球チームの詳細を表示する.
	 * 
	 * @param id    詳細を表示したい野球チームのID
	 * @param model リクエストスコープ
	 * @return 野球チームの詳細画面
	 */
	@RequestMapping("/toDetail")
	public String toDetail(int id, Model model) {
		Team team = service.showDetail(id);
		model.addAttribute("team", team);

		return "baseball/detail";
	}
}
