package com.jk.game.legend.server.fight.skill;


import com.jk.game.legend.model.UserInfo;

import com.jk.game.legend.server.fight.Respond;


/**
 * @author xiayuyang
 * @create 2021-03-22-18:57
 */
public class HarmSkill {
    public static Respond attackTwice(UserInfo p1, UserInfo p2, Respond respond){
        if (p1.getSkill().contains("1")){
            int probability = (int)(Math.random() * 101);
            if (probability <= 20){
                if (p2.getHealth()-respond.getHarmCollect()*2<=0){
                    respond.fightProcess.add("触发无影手：攻击两次！");
                    respond.setDie(true);
                    return respond;
                }
                respond.setHarmCollect(respond.getHarmCollect()*2);
                p2.setHealth(p2.getHealth()-(int)(respond.getHarmCollect()*2));
                respond.fightProcess.add("触发无影手：攻击两次！");
            }
        }
        return respond;
    }
}
