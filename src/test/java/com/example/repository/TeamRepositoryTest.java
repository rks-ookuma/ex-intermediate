package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.example.domain.Team;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.domain.Team;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TeamRepositoryTest {

	@Autowired
	private TeamRepository repository;

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String CREATE_SQL = "DROP TABLE IF EXISTS teams CASCADE;" + "CREATE TABLE teams("
			+ "id serial primary key," + "league_name text," + "team_name text," + "headquarters text,"
			+ "inauguration text," + "history text" + ");";

	private static final String INSERT_SQL = "INSERT INTO teams (league_name, team_name, headquarters, inauguration, history) VALUES"
			+ "('セントラル・リーグ','読売ジャイアンツ','東京ドーム（東京都・文京区）','1934年12月26日','大日本東京野球倶楽部（1934年）" + "↓" + "東京巨人軍（1935年〜1946年）"
			+ "↓" + "読売ジャイアンツ（1947年〜）');"
			+ "INSERT INTO teams (league_name, team_name, headquarters, inauguration, history) VALUES"
			+ "('セントラル・リーグ','阪神タイガース','阪神甲子園球場（兵庫県・西宮市）','1935年12月10日','大阪タイガース（1935年〜1940年途）" + "↓"
			+ "阪神軍（1940年途〜1946年）" + "↓" + "大阪タイガース（1947年〜1960年）→阪神タイガース（1961年〜）');"
			+ "INSERT INTO teams (league_name, team_name, headquarters, inauguration, history) VALUES"
			+ "('セントラル・リーグ','中日ドラゴンズ','ナゴヤドーム（愛知県・名古屋市東区）','1936年1月15日','名古屋軍（1936年〜1943年）" + "↓" + "産業軍（1944年）" + "↓"
			+ "中部日本軍（1946年）" + "↓" + "中日ドラゴンズ（1947年〜1950年）" + "↓" + "名古屋ドラゴンズ（1951年〜1953年）" + "↓" + "中日ドラゴンズ（1954年〜）');"
			+ "INSERT INTO teams (league_name, team_name, headquarters, inauguration, history) VALUES"
			+ "('セントラル・リーグ','横浜DeNAベイスターズ','横浜スタジアム（神奈川県・横浜市中区）','1949年11月22日','大洋ホエールズ（1950年〜1952年）" + "↓"
			+ "大洋松竹ロビンス（1953年〜1954年）" + "↓" + "大洋ホエールズ（1955年〜1977年）" + "↓" + "横浜大洋ホエールズ（1978年〜1992年）" + "↓"
			+ "横浜ベイスターズ（1993年〜2011年）" + "↓" + "横浜DeNAベイスターズ（2012年〜）');"
			+ "INSERT INTO teams (league_name, team_name, headquarters, inauguration, history) VALUES"
			+ "('セントラル・リーグ','広島東洋カープ','MAZDA Zoom-Zoomスタジアム広島（広島県・広島市南区）','1949年12月15日','広島カープ（1950年〜1967年）" + "↓"
			+ "広島東洋カープ（1968年〜）')," + "('セントラル・リーグ','東京ヤクルトスワローズ','明治神宮野球場（東京都・新宿区）','1950年1月12日','国鉄スワローズ（1950年〜1965年途）"
			+ "↓" + "サンケイスワローズ（1965年途〜終了）" + "↓" + "サンケイアトムズ（1966年〜1968年）" + "↓" + "アトムズ（1969年）" + "↓"
			+ "ヤクルトアトムズ（1970年〜1973年）" + "↓" + "ヤクルトスワローズ（1974年〜2005年）" + "↓" + "東京ヤクルトスワローズ（2006年〜）');";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

		String sql = CREATE_SQL + INSERT_SQL;
		SqlParameterSource param = new MapSqlParameterSource();
		template.update(sql, param);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void findAllTest() {

		List<Team> teamList = repository.findAll();

		assertEquals(6, teamList.size());
		assertEquals("読売ジャイアンツ", teamList.get(0).getTeamName());
	}

}
