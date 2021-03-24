package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.Respond;

import java.util.List;

/**
 * @author xiayuyang
 * @create 2021-03-22-22:21
 */
public class Crit {
    public static Respond isCrit(UserInfo p1, UserInfo p2, double harmCollect ,Respond respond){
        //是否暴击，暴击几率取决于该玩家的属性，暴击伤害为1.5倍的基础伤害
        double crit = (int) (Math.random() * 101);
        if (crit <= p1.getCritical() * 100){
            crit = 1.5;
            //触发暴击并且杀死了玩家
            if (p2.getHealth()-(int)(harmCollect*crit)<=0){
                respond.setHarmCollect(harmCollect*crit);
                respond.fightProcess.add("触发暴击!");
                respond.setDie(true);
                return respond;
            }
            //触发暴击，没杀死，扣血，并且此时的伤害增加为基础伤害的1.5倍，有助于后续技能的叠加
            respond.setHarmCollect(harmCollect*crit);
            p2.setHealth(p2.getHealth()-(int)(harmCollect*crit));
            respond.getFightProcess().add("触发暴击!" );
        }
        return respond;
    }
}
