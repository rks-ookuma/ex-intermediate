package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * 野球チームテーブルを操作するリポジトリ.
 * 
 * @author takahiro.okuma
 *
 */
@Repository
public class BaseballTeamRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_TEAMS = "teams";

	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs, i) -> {
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};

	/**
	 * 野球チームを全件取得する.
	 * 
	 * @return 全野球チームのドメインが入ったリスト
	 */
	public List<Team> findAll() {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM " + TABLE_TEAMS
				+ " ORDER BY id;";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}

	/**
	 * 指定したIDの野球チームを取得する.
	 * 
	 * @param id 取得したい野球チームのID
	 * @return 指定したIDの野球チームドメイン
	 */
	public Team findById(int id) {
		String sql = "SELECT id,league_name,team_name,headquarters,inauguration,history FROM " + TABLE_TEAMS
				+ " WHERE id=:id;";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);

		return team;
	}
}
