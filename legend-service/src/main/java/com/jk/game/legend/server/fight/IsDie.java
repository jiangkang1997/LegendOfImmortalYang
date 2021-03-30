package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;

/**
 * @author xiayuyang
 * @create 2021-03-30-20:22
 */
public class IsDie {

    public static Respond isDie(Respond respond, UserInfo p1, UserInfo p2){
        if (p2.getHealth()<=0){
            respond.fightProcess.add("给玩家2造成" + respond.getHarmCollect() + "点伤害,玩家二死亡");
            respond.setWinner(true);
        }else if (p1.getHealth()<=0){
            respond.fightProcess.add("给玩家1造成" + respond.getHarmCollect() + "点伤害,玩家一死亡");
            respond.setWinner(true);
        }
        return respond;
    }
}
