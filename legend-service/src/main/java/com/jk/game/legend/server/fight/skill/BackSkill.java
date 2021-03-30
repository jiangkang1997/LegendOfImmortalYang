package com.jk.game.legend.server.fight.skill;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.Crit;
import com.jk.game.legend.server.fight.FightDetail;
import com.jk.game.legend.server.fight.IsDie;
import com.jk.game.legend.server.fight.Respond;

/**
 * @author xiayuyang
 * @create 2021-03-29-20:48
 */
public class BackSkill {
    /**
     * 在p1的攻击回合，p2进行反击
     * @param p1
     * @param p2
     * @param respond
     * @param priority
     * @return
     */
    public static Respond fightBack(UserInfo p1, UserInfo p2, Respond respond,boolean priority){
        //反击:10%几率触发
        int probability = (int)(Math.random() * 101);
        if (probability <= 50){
            //触发反弹,伤害为基础伤害为基础伤害的一半
            if (priority){
                respond.fightProcess.add("玩家2被攻击时触发反弹！");
                respond.setHarmCollect((int) (0.5*p2.getAttack()) * p1.getDefensive()/(p1.getDefensive()+5));
                FightDetail.fightProcess(respond, p2, p1);
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("对玩家1造成"+respond.getHarmCollect()+"伤害");

            }else {
                respond.fightProcess.add("玩家1被攻击时触发反弹！");
                respond.setHarmCollect((int) (0.5*p1.getAttack()) * p2.getDefensive()/(p2.getDefensive()+5));
                FightDetail.fightProcess(respond, p1, p2);
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("对玩家2造成"+respond.getHarmCollect()+"伤害");
            }
        }
        return respond;
    }

}
