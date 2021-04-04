package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.skill.HarmSkill;

/**
 * @author xiayuyang
 * @create 2021-03-30-19:49
 */
public class FightProcess {
    static int count;
    public static void fightProcess(Respond respond,UserInfo p1, UserInfo p2, boolean priority){
        UserInfo p;
        String s;
        count = 2;
        while (p1.getHealth()>=0 || p2.getHealth()>=0) {
            if (count % 2 == 0) {
                respond.fightProcess.add("第" + count / 2 + "回合");
            }
            respond.fightProcess.add(Respond.player1);
            if (priority) {
                p2.setHealth((p2.getHealth() - p1.getAttack() * p2.getDefensive() / p2.getDefensive() + 5));
                //是否暴击
                Crit.isCrit(p1,p2,respond);
                //是否触发无影手技能
                HarmSkill.attackTwice(p1,p2,respond);
                //被攻击一方是否反击
                //若攻击方触发无影手，则判断两次反击
                if (respond.isTouchSkills.contains(1)){
                    BackSkill.fightBack(p1,p2,respond);
                }
                BackSkill.fightBack(p1,p2,respond);
                //文案记录
                ProcessRecord.record(respond,p1,p2);
                //触发技能清0
                respond.isTouchSkills.clear();
                count++;
            }
            s = Respond.player1;
            Respond.player1 = Respond.player2;
            Respond.player2 = s;
            p = p1;
            p1 = p2;
            p2 = p;
            priority = true;
        }
    }
}
