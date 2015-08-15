package jp.ac.kansai_u.kutc.firefly.aiwolf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.aiwolf.client.lib.Topic;
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

//	private ArrayList<Integer> firstDayCoSeer = new ArrayList<Integer>();
//	private ArrayList<Integer> firstDayCoMedium = new ArrayList<Integer>();

	// coSeers - Key:AgentID Value:CO日
	private Map<Integer, Integer> coSeers = new HashMap<Integer, Integer>();
	// coMediums - Key:AgentID Value:CO日
	private Map<Integer, Integer> coMediums = new HashMap<Integer, Integer>();

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
	/*
	 TODO; EventやAgentPoint等から増減するポイントを計算
	 TODO; Pointインスタンスを生成
	 TODO; ArrayList<Point>に追加
	 */
	public void update(Event event){

		// PointSystemに渡すArrayList<Point>を作成
		ArrayList<Point> points = new ArrayList<Point>();

		// eventがCOの場合
		if (event.getType().equals(EventType.TALK) && event.getTopic().equals(Topic.COMINGOUT)){
			// 未CO者をCO者マップに追加
			putCoAgent(event);
		}

		//初日以外の場合
		if (event.getDay() != 0) {
			// TODO: 今のところ，中田さんの方針にある"初日CO者の数"ではなく"全CO者"で場合分けしているが，実際はどうするか？
			if (coSeers.size() == 0 && coMediums.size() == 0) {
				// 占い師および霊能師のCOがともに0人だった場合
				// 役職者を暴こうとする人，発言数が少ない人にマイナスを振る

			} else if (coSeers.size() == 1 && (coMediums.size() == 1 || coMediums.size() == 2)) {
				// 占い師1，霊能師1あるいは2の場合
				// 正しい占い師に関して，占い結果が出る2日目まで潜伏する可能性があり，このときのCOが正しいとは限らないが，基本的には信用する

			} else if (coSeers.size() == 2 && (coMediums.size() == 1 || coMediums.size() == 2)) {
				// 占い師2，霊能師1あるいは2の場合
				// 占い師に間違いなく騙りがいる．内訳は占い師・狼・狂人．これら役職のポイントをいじる

			} else if (coSeers.size() == 3 && coMediums.size() == 1) {
				// 占い師3，霊能師1の場合
				// 占い師に間違いなく騙りがいる．占い候補者が噛まれたら他の占い師に関してポイントを下げていく．

			} else if (coSeers.size() == 4 && coMediums.size() == 1) {
				// 占い師4，霊能師1の場合

				//region 2日目においてこのメソッドが初めて呼び出された時に，占いCOした人に対してポイントを下げる
				if (event.getDay() == 1 && updatePointByCoFlag == false) {

					//region 客観ポイント
					for (int id : coSeers.keySet()) {
						// 占い師のポイントを下げる
						Point decreaseSeer = new Point(-10, id, View.OBJECTIVE, Role.SEER);
						points.add(decreaseSeer);

						// 人狼のポイントを上げる
						Point increaseWerewolf = new Point(+10, id, View.OBJECTIVE, Role.WEREWOLF);
						points.add(increaseWerewolf);

						// 狂人のポイントを上げる
						Point increasePossessed = new Point(+10, id, View.OBJECTIVE, Role.POSSESSED);
						points.add(increasePossessed);

						// 陣営ポイントを下げる
						Point decreaseCP = new Point(-10, id, View.OBJECTIVE, null);//Roleの引数にnullを指定するとCP操作
						points.add(decreaseCP);
					}
					//endregion

					//region 主観ポイント
					if (myRole == Role.SEER) {
						// 自分以外で占い師COしたものをすべて人狼または狂人とみなす
						for (int id : coSeers.keySet()) {
							// 占い師のポイントを最小にする
							Point decreaseSeer = new Point(-100, id, View.SUBJECTIVE, Role.SEER);
							points.add(decreaseSeer);

							// 人狼のポイントを最大にする
							Point increaseWerewolf = new Point(+100, id, View.SUBJECTIVE, Role.WEREWOLF);
							points.add(increaseWerewolf);

							// 狂人のポイントを最大にする
							Point increasePossessed = new Point(+100, id, View.SUBJECTIVE, Role.POSSESSED);
							points.add(increasePossessed);

							// 陣営ポイントを最小にする
							Point decreaseCP = new Point(-100, id, View.SUBJECTIVE, null);
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

	private void putCoAgent(Event event) {

		int day = event.getDay();
		int agentId = event.getAgent().getAgentIdx();

		switch(event.getRole()){
		case BODYGUARD:
			break;
		case MEDIUM:
			// 既にCO済みなら無視
			if(!coMediums.containsKey(agentId)){
				// CO者マップに追加
				coMediums.put(agentId, day);
			}
			break;
		case SEER:
			// 既にCO済みなら無視
			if(!coSeers.containsKey(agentId)){
				// CO者マップに追加
				coSeers.put(agentId, day);
			}
			break;
		case POSSESSED://狂人
			// TODO 必要ない？
			break;
		case VILLAGER:
			// TODO 必要ない？
			break;
		case WEREWOLF:
			// TODO 必要ない？
			break;
		default:
			break;
		}
	}
}
