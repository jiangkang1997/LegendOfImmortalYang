package com.jk.game.legend.server.fight.common;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.common.Respond;

/**
 * @author xiayuyang
 * @create 2021-03-29-20:48
 */
public class BackSkill {
    /**
     * 反击:在p1的攻击回合，p2进行反击，伤害为p2基础伤害的一半
     * @param p1
     * @param p2
     * @param respond
     * @return
     */
    public static void fightBack(UserInfo p1, UserInfo p2, Respond respond){
        int probability = (int)(Math.random() * 100);
        if (probability <= 50){
            //触发反击,做个标记
            respond.isTouchSkills.add(2);
            //扣血
            p1.setHealth((int) (p1.getHealth()-0.5*p2.getAttack()*p1.getDefensive()/p1.getDefensive()+5));
        }
    }
}
