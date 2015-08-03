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

	public PointSystem() {
		// Generate AgentPoint instances of each player without me.
		AgentPoint agentPoint = new AgentPoint();
	}


	public void updatePoint(ArrayList<Point> pointList) {
		for (int i = 0; i < pointList.size(); i++) {
			Point point = pointList.get(i);
			if (point.getRole() != null) {
				switch (point.getRole()) {
					case Role.VILLAGER:
						agentPoint.setVillagerPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.BODYGUARD:
						agentPoint.setBodyguardPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.SEER:
						agentPoint.setSeerPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.MEDIUM:
						agentPoint.setMediumPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.WEREWOLF:
						agentPoint.setWolfPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
					case Role.POSSESSED:
						agentPoint.setPossessedPoint(point.getAgentId(), point.getView(), point.getVariation());
						break;
				}
			} else {
				agentPoint.setCampPoint(point.getAgentId(), point.getView(), point.getVariation());
			}
		}
	}
}