package jp.ac.kansai_u.kutc.firefly.aiwolf;

import java.util.ArrayList;

import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Team;

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

		// PointSystemに渡すArrayList<Point>を作成
		ArrayList<Point> points = new ArrayList<Point>();

		/*
		 TODO; EventやAgentPoint等から増減するポイントを計算
		 TODO; Pointインスタンスを生成
		 TODO; ArrayList<Point>に追加
		 */

		// PointSystemにArrayList<Point>を渡す
		pointSystem.updatePoint(points);
	}
}
