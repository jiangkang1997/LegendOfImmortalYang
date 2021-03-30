package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;


/**
 * @author xiayuyang
 * @create 2021-03-22-22:21
 */
public class Crit {
    public static Respond isCrit(UserInfo p1, UserInfo p2, int harmCollect ,Respond respond){
        //是否暴击，暴击几率取决于该玩家的属性，暴击伤害为1.5倍的基础伤害
        double crit = (int) (Math.random() * 101);
        if (crit <= p1.getCritical() * 100){
            crit = 1.5;
            respond.isTouchSkills[0]=1;
            respond.setHarmCollect((int)(harmCollect*crit));
            //触发暴击并且杀死了玩家
            if ((IsDie.isDie(respond, p1, p2)).winner){
                return respond;
            }
            //触发暴击，没杀死，扣血，并且此时的伤害增加为基础伤害的1.5倍，有助于后续技能的叠加
            p2.setHealth(p2.getHealth()-(int)(harmCollect*crit));
        }
        return respond;
    }
}
