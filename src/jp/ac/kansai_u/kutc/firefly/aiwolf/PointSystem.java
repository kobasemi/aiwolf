package jp.ac.kansai_u.kutc.firefly.aiwolf;

import java.util.ArrayList;
import jp.ac.kansai_u.kutc.firefly.aiwolf.*;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Team;

/**
 * This class manage point of each player which use indicator of judgment.
 *
 * @author Kensuke Kosaka
 */
public class PointSystem {
	private AgentPoint mAgentPoint;

	public PointSystem() {
		// Generate mAgentPoint instances of each player without me.
		mAgentPoint = new AgentPoint();
	}


	public void updatePoint(ArrayList<Point> pointList) {
		for (int i = 0; i < pointList.size(); i++) {
			Point point = pointList.get(i);
			if (point.getRole() != null) {
				switch (point.getRole()) {
					case Role.VILLAGER:
						mAgentPoint.setVillagerPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.BODYGUARD:
						mAgentPoint.setBodyguardPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.SEER:
						mAgentPoint.setSeerPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.MEDIUM:
						mAgentPoint.setMediumPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.WEREWOLF:
						mAgentPoint.setWolfPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.POSSESSED:
						mAgentPoint.setPossessedPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
				}
			} else {
				mAgentPoint.setCampPoint(point.getAgentId(), point.getView(), point.getVariation());
			}
		}
	}



	public int getPoint(Role role, int player, int view) {
		int point = -1;
		if (role != null) {
			// Return IP.
			switch (role) {
				case Role.VILLAGER:
					point = mAgentPoint.getVillagerPoint(player, view);
					break;
				case Role.BODYGUARD:
					point = mAgentPoint.getBodyguardPoint(player, view);
					break;
				case Role.SEER:
					point = mAgentPoint.getSeerPoint(player, view);
					break;
				case Role.MEDIUM:
					point = mAgentPoint.getMediumPoint(player, view);
					break;
				case Role.WEREWOLF:
					point = mAgentPoint.getWolfPoint(player, view);
					break;
				case Role.POSSESSED:
					point = mAgentPoint.getPossessedPoint(player, view);
					break;
			}
		} else {
			// Return CP.
			point = mAgentPoint.getCampPoint(player, view);
		}

		return point;
	}