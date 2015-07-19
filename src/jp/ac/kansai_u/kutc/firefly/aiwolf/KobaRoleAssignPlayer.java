package jp.ac.kansai_u.kutc.firefly.aiwolf;

import jp.ac.kansai_u.kutc.firefly.aiwolf.agent.*;
import org.aiwolf.client.base.player.*;

/**
 * This class assigns each player to the aiwolf server.
 *
 * @see org.aiwolf.client.base.player.AbstractRoleAssignPlayer
 * @author asakasa
 */
public class KobaRoleAssignPlayer extends AbstractRoleAssignPlayer {

    public KobaRoleAssignPlayer() {
        /* Set each of the role classes */
        setSeerPlayer     (new KobaSeer());
        setBodyguardPlayer(new KobaBodyguard());
        setMediumPlayer   (new KobaMedium());
        setPossessedPlayer(new KobaPossessed());
        setVillagerPlayer (new KobaVillager());
        setWerewolfPlayer (new KobaWerewolf());
    }

    @Override
    public String getName() {
        return "KobaAIWolf";
    }
}
