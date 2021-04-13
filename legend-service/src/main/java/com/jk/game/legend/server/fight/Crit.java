package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;


/**
 * @author xiayuyang
 * @create 2021-03-22-22:21
 */
class Crit {
    /**
     * 暴击：几率取决于该玩家的属性，暴击伤害为1.5倍的基础伤害
     * @param p1
     * @param p2
     * @param respond
     */
    public static void isCrit(UserInfo p1, UserInfo p2,Respond respond){
        int probability = (int) (Math.random() * 100);
        if (probability <= p1.getCritical() * 100){
            //触发了暴击，做个标记
            respond.isTouchSkills.add(0);
            //扣血
            p2.setHealth((int) (p2.getHealth()-0.5*p1.getAttack()*p2.getDefensive()/(p2.getDefensive()+5)));
        }
    }
}
