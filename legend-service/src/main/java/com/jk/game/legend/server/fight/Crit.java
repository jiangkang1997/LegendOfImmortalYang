package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.Respond;

import java.util.List;

/**
 * @author xiayuyang
 * @create 2021-03-22-22:21
 */
public class Crit {
    public static Respond isCrit(UserInfo p1, UserInfo p2, Respond respond){
        double crit = (int) (Math.random() * 101);
        if (crit <= p1.getCritical() * 100){
            crit = 1.5;
            if (p2.getHealth()-(int)(respond.getHarmCollect()*crit)<=0){
                respond.setHarmCollect(respond.getHarmCollect()*crit);
                respond.fightProcess.add("触发暴击!");
                respond.setDie(true);
                return respond;
            }
            respond.setHarmCollect(respond.getHarmCollect()*crit);
            p2.setHealth(p2.getHealth()-(int)(respond.getHarmCollect()*crit));
            respond.getFightProcess().add("触发暴击!" );
        }
        return respond;
    }
}
