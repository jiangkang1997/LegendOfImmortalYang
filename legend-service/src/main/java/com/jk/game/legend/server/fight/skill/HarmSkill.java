package com.jk.game.legend.server.fight.skill;


import com.jk.game.legend.model.UserInfo;

import com.jk.game.legend.server.fight.Respond;


/**
 * @author xiayuyang
 * @create 2021-03-22-18:57
 */
public class HarmSkill {
    /**
     * 无影手：连续攻击两次，该技能与暴击不可同时触发
     * @param p1
     * @param p2
     * @param respond
     */
    public static void attackTwice(UserInfo p1, UserInfo p2, Respond respond){
        //判断玩家是否习得这个技能，且前面是否已经触发暴击
        if (p1.getSkill().contains("1") && !respond.isTouchSkills.contains(0)){
            int probability = (int)(Math.random() * 100);
            if (probability <= 50){
                //触发了无影手，做个标记
                respond.isTouchSkills.add(1);
                //扣血
                p2.setHealth((p2.getHealth()-p1.getAttack()*p2.getDefensive()/(p2.getDefensive()+5)));
            }
        }
    }
}
