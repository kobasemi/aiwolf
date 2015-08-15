package jp.ac.kansai_u.kutc.firefly.aiwolf;

import org.aiwolf.common.data.Role;


/**
 * This class manage detail of point.
 *
 * @author Kensuke Kosaka
 */
public class Point {
	private int variation = 0; // Variation of agent point.
	private int agentId = -1; // ID of update target agent.
	private View view = null; // Point of view. View.OBJECTIVE or View.SUBJECTIVE
	private Role role = null; // Role.VILLAGER, Role.WEREWOLF, and so on.

	public Point(int variation, int agentId, View view, Role role){

		if(agentId < 0){
			throw new IllegalArgumentException("エージェントIDの値がマイナスです");
		}

		this.variation = variation;
		this.agentId = agentId;
		this.view = view;
		this.role = role;
	}

	public int getVariation() {
		return variation;
	}

	public int getAgentId() {
		return agentId;
	}

	public View getView() {
		return view;
	}

	public Role getRole() {
		return role;
	}

/*	setterを廃止してコンストラクタでフィールドを初期化
	public void setVariation(int variation) {
		this.variation = variation;
	}

	*//**
	 * Set Agent ID.
	 *
	 * @param agentId int value. 0~13
	 *//*
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	*//**
	 * Set Point of view for this variation wheather Subjective or Objective.
	 *
	 * @param view View.OBJECTIVE or View.SUBJECTIVE
	 *//*
	public void setView(View view) {
		this.view = view;
	}

	public void setRole(Role role) {
		this.role = role;
	}
*/
}

enum View {
	OBJECTIVE,  //客観
	SUBJECTIVE, //主観
	;
}