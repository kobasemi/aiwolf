package jp.ac.kansai_u.kutc.firefly.aiwolf;

import org.aiwolf.client.lib.Topic;
import org.aiwolf.client.lib.Utterance;
import org.aiwolf.common.data.Agent;
import org.aiwolf.common.data.Judge;
import org.aiwolf.common.data.Role;
import org.aiwolf.common.data.Species;
import org.aiwolf.common.data.Talk;

/**
 * This class manages all event of the game.
 *
 * @author asakasa
 */
public class Event {
    public Event(Talk t) {

        Utterance u = new Utterance(t.getContent());
        this.day = t.getDay();
        this.agent = t.getAgent();
        this.target = u.getTarget(); //霊能結果はターゲットがnullになるかもしれないので要確認
        this.judge = null;
        this.type = EventType.TALK;
        this.topic = u.getTopic();
        switch(this.topic){
        //TODO: 他にあるかも
        case AGREE:
        case DISAGREE:
        case COMINGOUT:
        case ESTIMATE:
            this.role = u.getRole();
            break;
        case DIVINED:
        case INQUESTED:
            this.species = u.getResult();
            //TODO: JudgeクラスはGameInfoから与えられる「絶対に正しい判定結果」であり．不確定なJudgeを勝手に生成しない方が良い？
            //this.judge = new Judge(this.day, this.agent, this.target, this.species);
            break;
        default:
            this.species = null;
            this.role = null;
            break;

        }
    }
    public Event(Judge j) {
        this.day = j.getDay();
        this.agent = j.getAgent();
        this.target = j.getTarget();
        this.judge = j;
/*TODO: Event側ではJudgeが霊能結果なのか占い結果なのかを判定できない．→Type.JUDGEでまとめる？
        if(){
            this.type = EventType.DIVINE;
        }else{
            this.type = EventType.INQUEST;
        }
*/
        this.topic = null;
        this.role = null;
        this.species = j.getResult();
    }
/* TODO:要らない？
    public Event(String content) {
    }
*/

    // a day of the event
    private int day = -1;
    public int getDay() {
        return day;
    }
    // a type of the event such as TALK, DIVINE, DIVINED, etc
    private EventType type = null;
    public EventType getType() {
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

enum EventType{
    TALK,
    DIVINE,
    INQUEST,
    ;
}
