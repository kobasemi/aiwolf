package jp.ac.kansai_u.kutc.firefly.aiwolf;

import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is 脳.
 *
 * @author Tsubasa Bando
 * @author Kensuke Kosaka
 */
public class Brain {

	private Role myRole;
	private Team myTeam;
	private PointSystem pointSystem;

	// コンストラクタ
	public Brain(){

		// PointSystemのインスタンス化
		this.pointSystem = new PointSystem();
	}

	public Brain(Role role, Team team) {
		this.myRole = role;
		this.myTeam = team;
		this.pointSystem = new PointSystem();
	}

	// ポイント計算メソッド
	public void update(Event event){

		// PointSystemに渡すPoint<List>を作成
		List<Point> points = new ArrayList<Point>();

		/*
		 TODO; EventやAgentPoint等から増減するポイントを計算
		 TODO; Pointインスタンスを生成
		 TODO; Point<List>に追加
		 */

		// PointSystemにPoint<List>を渡す
		pointSystem.updatePoint(points);
	}
}
