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

	private boolean updatePointByCoFlag;

	// コンストラクタ
	public Brain(){

		// PointSystemのインスタンス化
		this.pointSystem = new PointSystem();
		updatePointByCoFlag = false;
	}

	public Brain(Role role, Team team) {
		this.myRole = role;
		this.myTeam = team;
		this.pointSystem = new PointSystem();
		updatePointByCoFlag = false;
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
				//region 初日の自分以外の占い師および霊能師のCOをカウントする
				//TODO もし自分自身の発言もeventにカウントされるなら，それを取り除く
				if (event.getRole().equals(Role.SEER)) {
					if (!firstDayCoSeer.contains(event.getAgent().getAgentIdx()))
						firstDayCoSeer.add(event.getAgent().getAgentIdx());
				} else if (event.getRole().equals(Role.MEDIUM)) {
					if (!firstDayCoMedium.contains(event.getAgent().getAgentIdx()))
						firstDayCoMedium.add(event.getAgent().getAgentIdx());
				}
				//endregion
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

				//region 2日目においてこのメソッドが初めて呼び出された時に，占いCOした人に対してポイントを下げる
				if (event.getDay() == 1 && updatePointByCoFlag == false) {

					//region 客観ポイント
					for (int i = 0; i < firstDayCoSeer.size(); i++) {
						// 占い師のポイントを下げる
						Point decreaseSeer = new Point();
						decreaseSeer.setVariation(-10);
						decreaseSeer.setAgentId(firstDayCoSeer.get(i));
						decreaseSeer.setView(1);
						decreaseSeer.setRole(Role.SEER);
						points.add(decreaseSeer);

						// 人狼のポイントを上げる
						Point increaseWerewolf = new Point();
						increaseWerewolf.setVariation(10);
						increaseWerewolf.setAgentId(firstDayCoSeer.get(i));
						increaseWerewolf.setView(1);
						increaseWerewolf.setRole(Role.WEREWOLF);
						points.add(increaseWerewolf);

						// 狂人のポイントを上げる
						Point increasePossessed = new Point();
						increasePossessed.setVariation(10);
						increasePossessed.setAgentId(firstDayCoSeer.get(i));
						increasePossessed.setView(1);
						increasePossessed.setRole(Role.POSSESSED);
						points.add(increasePossessed);

						// 陣営ポイントを下げる
						Point decreaseCP = new Point();
						decreaseCP.setVariation(-10);
						decreaseCP.setAgentId(firstDayCoSeer.get(i));
						decreaseCP.setView(1);
						points.add(decreaseCP);
					}
					//endregion

					//region 主観ポイント
					if (myRole == Role.SEER) {
						// 自分以外で占い師COしたものをすべて人狼または狂人とみなす
						for (int i = 0; i < firstDayCoSeer.size(); i++) {
							// 占い師のポイントを最小にする
							Point decreaseSeer = new Point();
							decreaseSeer.setVariation(-100);
							decreaseSeer.setAgentId(firstDayCoSeer.get(i));
							decreaseSeer.setView(0);
							decreaseSeer.setRole(Role.SEER);
							points.add(decreaseSeer);

							// 人狼のポイントを最大にする
							Point increaseWerewolf = new Point();
							increaseWerewolf.setVariation(100);
							increaseWerewolf.setAgentId(firstDayCoSeer.get(i));
							increaseWerewolf.setView(0);
							increaseWerewolf.setRole(Role.WEREWOLF);
							points.add(increaseWerewolf);

							// 狂人のポイントを最大にする
							Point increasePossessed = new Point();
							increasePossessed.setVariation(100);
							increasePossessed.setAgentId(firstDayCoSeer.get(i));
							increasePossessed.setView(0);
							increasePossessed.setRole(Role.POSSESSED);
							points.add(increasePossessed);

							// 陣営ポイントを最小にする
							Point decreaseCP = new Point();
							decreaseCP.setVariation(-100);
							decreaseCP.setAgentId(firstDayCoSeer.get(i));
							decreaseCP.setView(0);
							points.add(decreaseCP);
						}
					}
					//endregion

					updatePointByCoFlag = true;
				}
				//endregion
			}
		}

		// PointSystemにArrayList<Point>を渡す
		pointSystem.updatePoint(points);

		// pointsの中身を空にする
		points.clear();
	}
}
