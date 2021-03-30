package com.jk.game.legend.server.fight.skill;


import com.jk.game.legend.model.UserInfo;

import com.jk.game.legend.server.fight.IsDie;
import com.jk.game.legend.server.fight.Respond;


/**
 * @author xiayuyang
 * @create 2021-03-22-18:57
 */
public class HarmSkill {
    public static Respond attackTwice(UserInfo p1, UserInfo p2,int harmCollect, Respond respond){
        //判断玩家是否习得这个技能
        if (p1.getSkill().contains("1")){
            //20%几率触发
            int probability = (int)(Math.random() * 101);
            if (probability <= 20){
                respond.isTouchSkills[1]=2;
                respond.setHarmCollect(harmCollect*2);
                //触发技能并且杀死了玩家
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                //触发技能，没杀死，扣血，并且此时的伤害增加为基础伤害的两倍，有助于后续技能的叠加
                p2.setHealth(p2.getHealth()-(int)(harmCollect*2));
            }
        }
        return respond;
    }
}
