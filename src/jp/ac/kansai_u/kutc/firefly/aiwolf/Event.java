package jp.ac.kansai_u.kutc.firefly.aiwolf;

import org.aiwolf.client.lib.Topic;
import org.aiwolf.common.data.*;

/**
 * This class manages all event of the game.
 *
 * @author asakasa
 */
public class Event {
    public Event(Talk t) {

    }
    public Event(Judge j) {

    }
    public Event(String s) {

    }


    // a day of the event
    private int day = -1;
    public int getDay() {
        return day;
    }
    // a type of the event such as TALK, DIVINE, DIVINED, etc
    private String type = null;
    public String getType() {
        return type;
    }
    // an agent of the event
    private Agent agent = null;
    public Agent getAgent() {
        return agent;
    }
    // a targeted agent of the event
    private Agent target = null;
    public Agent getTarget() {
        return target;
    }

    // a result that some events such as DIVINE, INQUESTED did
    private Judge judge;
    public Judge getJudge() {
        return judge;
    }
    // a role of the agent
    private Role role;
    public Role getRole() {
        return role;
    }
    // a species of the targeted agent such as VILLAGER or WEREWOLF
    private Species species;
    public Species getSpecies() {
        return species;
    }
    // a talk topic of the event
    private Topic topic = null;
    public Topic getTopic() {
        return topic;
    }
}
