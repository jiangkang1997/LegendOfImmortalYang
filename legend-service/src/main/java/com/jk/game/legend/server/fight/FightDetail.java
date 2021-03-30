package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.skill.HarmSkill;

/**
 * @author xiayuyang
 * @create 2021-03-30-20:06
 */
public class FightDetail {

    public static void fightProcess(Respond respond, UserInfo p1, UserInfo p2){
        //判断是否暴击
        Crit.isCrit(p1,p2,respond.getHarmCollect(),respond);
        //判断是否触发攻击两次的技能
        HarmSkill.attackTwice(p1,p2,respond.getHarmCollect(),respond);
        if (respond.isTouchSkills[0]==1){
            respond.fightProcess.add("触发暴击！造成150%伤害");
            respond.isTouchSkills[0]=0;
        }
        if (respond.isTouchSkills[1]==2){
            respond.fightProcess.add("触发无影手！连续攻击两次");
            respond.isTouchSkills[1]=0;
        }
    }
}
