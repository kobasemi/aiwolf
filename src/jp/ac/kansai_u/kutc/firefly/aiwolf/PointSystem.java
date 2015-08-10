package jp.ac.kansai_u.kutc.firefly.aiwolf;

import java.util.ArrayList;

import org.aiwolf.common.data.Role;

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
				case VILLAGER:
					mAgentPoint.setVillagerPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case BODYGUARD:
					mAgentPoint.setBodyguardPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case SEER:
					mAgentPoint.setSeerPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case MEDIUM:
					mAgentPoint.setMediumPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case WEREWOLF:
					mAgentPoint.setWolfPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case POSSESSED:
					mAgentPoint.setPossessedPoint(point.getAgentId(), point.getView(), point.getVariation());
					break;
				case FREEMASON:
					//TODO: 不明
					break;
				default:
					//TODO: 例外を投げる？
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
			case VILLAGER:
				point = mAgentPoint.getVillagerPoint(player, view);
				break;
			case BODYGUARD:
				point = mAgentPoint.getBodyguardPoint(player, view);
				break;
			case SEER:
				point = mAgentPoint.getSeerPoint(player, view);
				break;
			case MEDIUM:
				point = mAgentPoint.getMediumPoint(player, view);
				break;
			case WEREWOLF:
				point = mAgentPoint.getWolfPoint(player, view);
				break;
			case POSSESSED:
				point = mAgentPoint.getPossessedPoint(player, view);
				break;
			case FREEMASON:
				//TODO: 不明
				break;
			default:
				//TODO: 例外を投げる？
				break;
			}
		} else {
			// Return CP.
			point = mAgentPoint.getCampPoint(player, view);
		}

		return point;
	}
}