package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.skill.BackSkill;

/**
 * @author xiayuyang
 * @create 2021-03-30-19:49
 */
public class FightProcess {

    public static Respond fightProcess(Respond respond,UserInfo p1, UserInfo p2, boolean priority){
        while (p1.getHealth() >0 && p2.getHealth()>0) {
            if (priority) {
                respond.fightProcess.add("第" + respond.count + "回合，玩家一 >>>>");
                //确定基础伤害
                respond.setHarmCollect(p1.getAttack() * p2.getDefensive()/(p2.getDefensive()+5));
                FightDetail.fightProcess(respond, p1, p2);
                //玩家一在该回合攻击完毕，判断玩家2是否死亡，若死亡，则结束对战
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("给玩家2造成" + respond.getHarmCollect() + "点伤害");
                BackSkill.fightBack(p1,p2,respond,priority);


                respond.fightProcess.add("玩家二 >>>>");
                respond.setHarmCollect(p2.getAttack() * p1.getDefensive()/(p1.getDefensive()+5));
                FightDetail.fightProcess(respond, p2, p1);
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                BackSkill.fightBack(p2,p1,respond,priority);

                respond.count++;
            } else {
                respond.fightProcess.add("第" + respond.count + "回合，玩家二 >>>>");
                respond.setHarmCollect(p2.getAttack() * p1.getDefensive()/(p1.getDefensive()+5));
                FightDetail.fightProcess(respond, p2, p1);
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                BackSkill.fightBack(p2,p1,respond,priority);



                respond.fightProcess.add("玩家一 >>>>");
                respond.setHarmCollect(p1.getAttack() * p2.getDefensive()/(p2.getDefensive()+5));
                FightDetail.fightProcess(respond, p1, p2);
                if ((IsDie.isDie(respond, p1, p2)).winner){
                    return respond;
                }
                respond.fightProcess.add("给玩家2造成" + respond.getHarmCollect() + "点伤害");
                BackSkill.fightBack(p1,p2,respond,priority);

                respond.count++;
            }
        }
        return respond;
    }
}
