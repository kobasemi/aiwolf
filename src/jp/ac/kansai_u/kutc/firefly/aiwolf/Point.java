package jp.ac.kansai_u.kutc.firefly.aiwolf;

import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Team;


/**
 * This class manage detail of point.
 *
 * @author Kensuke Kosaka
 */
public class Point {
	private int variation; // Variation of agent point.
	private int agentId; // ID of update target agent.
	private int view; // Point of view. Subjective:0 or Objective:1.
	private Role role; // Role.VILLAGER, Role.WEREWOLF, and so on.
	private Team team; // Team.VILLAGER or Team.WEREWOLF.

	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public int getAgentId() {
		return agentId;
	}

	/**
	 * Set Agent ID.
	 *
	 * @param agentId int value. 0~13
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getView() {
		return view;
	}

	/**
	 * Set Point of view for this variation wheather Subjective or Objective.
	 *
	 * @param view 0:Subjective, 1:Objective.
	 */
	public void setView(int view) {
		this.view = view;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
}