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

	private ArrayList<Integer> firstDayCoSeer = new ArrayList<Integer>();
	private ArrayList<Integer> firstDayCoMedium = new ArrayList<Integer>();

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
		if (event.getDay() == 0) {
			if (event.getType() == "COMINGOUT") {
				// 初日の占い師および霊能師のCOをカウントする
				if (event.getRole().equals(Role.SEER)) {
					if (!firstDayCoSeer.contains(event.getAgent().getAgentIdx()))
						firstDayCoSeer.add(event.getAgent().getAgentIdx());
				} else if (event.getRole().equals(Role.MEDIUM)) {
					if (!firstDayCoMedium.contains(event.getAgent().getAgentIdx()))
						firstDayCoMedium.add(event.getAgent().getAgentIdx());
				}
			}
		} else {
			if (firstDayCoSeer.size() == 0 && firstDayCoMedium.size() == 0) {
				// 占い師および霊能師のCOがともに0人だった場合
				// 役職者を暴こうとする人，発言数が少ない人にマイナスを振る

			} else if (firstDayCoSeer.size() == 1 && (firstDayCoMedium.size() == 1 || firstDayCoMedium.size() == 2)) {
				// 占い師1，霊能師1あるいは2の場合
				// 正しい占い師に関して，占い結果が出る2日目まで潜伏する可能性があり，このときのCOが正しいとは限らないが，基本的には信用する

			} else if (firstDayCoSeer.size() == 2 && (firstDayCoMedium.size() == 1 || firstDayCoMedium.size() == 2)) {
				// 占い師2，霊能師1あるいは2の場合
				// 占い師に間違いなく騙りがいる．内訳は占い師・狼・狂人．これら役職のポイントをいじる

			} else if (firstDayCoSeer.size() == 3 && firstDayCoMedium.size() == 1) {
				// 占い師3，霊能師1の場合
				// 占い師に間違いなく騙りがいる．占い候補者が噛まれたら他の占い師に関してポイントを下げていく．

			} else if (firstDayCoSeer.size() == 4 && firstDayCoMedium.size() == 1) {
				// 占い師4，霊能師1の場合
				// 占いCOした人に対して，ポイントを下げていく

			}
		}

		// PointSystemにArrayList<Point>を渡す
		pointSystem.updatePoint(points);
	}
}
