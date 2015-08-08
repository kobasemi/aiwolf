package jp.ac.kansai_u.kutc.firefly.aiwolf.agent;

import org.aiwolf.client.base.player.AbstractVillager;
import org.aiwolf.client.lib.Utterance;
import org.aiwolf.common.data.*;
import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Talk;
import org.aiwolf.common.data.Team;
import org.aiwolf.common.data.Vote;
import org.aiwolf.common.net.GameInfo;

import java.util.List;

import jp.ac.kansai_u.kutc.firefly.aiwolf.Brain;
import jp.ac.kansai_u.kutc.firefly.aiwolf.Event;
import jp.ac.kansai_u.kutc.firefly.aiwolf.EventLog;

/**
 * This class is the role of Villager.
 *
 * @see org.aiwolf.client.base.player.AbstractVillager
 * @author asakasa
 * @author Kensuke Kosaka
 */
public class KobaVillager extends AbstractVillager {
    // Index of talks that already has been read in this day
    int readTalkIdx = 0;
    EventLog log=new EventLog();
    Brain brain=new Brain(Role.VILLAGER, Team.VILLAGER);
    @Override
    public void dayStart() {
        readTalkIdx = 0;
        for (Vote vote : getLatestDayGameInfo().getVoteList()) {
        }
    }

    @Override
    public void update(GameInfo gameInfo) {
        super.update(gameInfo);
        List<Talk> talkList = gameInfo.getTalkList();
        for (int i = readTalkIdx; i < talkList.size(); i++) {
        	Event event =new Event(talkList.get(i).getContent());//Event作成
        	log.addEvent(event);// EventLogにEventを詰め込む
        	brain.update(event);//BrainにEventを渡す
            Utterance u = new Utterance(talkList.get(i).getContent());
            switch (u.getTopic()) {
                case COMINGOUT:
                    break;
                case VOTE:
                    break;
                case DIVINED:
                    break;
                case INQUESTED:
                    break;
                case GUARDED:
                    break;
                case ATTACK:
                    break;
                case ESTIMATE:
                    break;
                case AGREE:
                    break;
                case DISAGREE:
                    break;
                case SKIP:
                    break;
                case OVER:
                    break;
            }
            readTalkIdx++;
        }

    }

    @Override
    public String talk() {
        return null;
    }

    @Override
    public Agent vote() {
        return null;
    }

    @Override
    public void finish() {

    }
}
