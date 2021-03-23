package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.fight.skill.HarmSkill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/3/20 22:26
 */
public class FightManage {

    public static List<String> doFight(UserInfo p1, UserInfo p2){
        List<String> result = new ArrayList<>();
        Respond respond = new Respond(new ArrayList<String>(),0,false);
        boolean priorityFlag;
        int roundCount = 1;
        int p1Health = p1.getHealth();
        int p2Health = p2.getHealth();
        if (p1.getSpeed().equals(p2.getSpeed())){
            int randomFlag = (int) (Math.random() * 2);
            priorityFlag = randomFlag == 0;
        }else {
            priorityFlag = p1.getSpeed() > p2.getSpeed();
        }

        while (p1.getHealth() >0 && p2.getHealth()>0){
            respond.setHarmCollect(p1.getAttack() * p2.getDefensive()/(p2.getDefensive()+5));
            if (priorityFlag){
                respond.fightProcess.add("第"+roundCount+"回合，玩家一 >>>>");
                Crit.isCrit(p1,p2,respond);
                HarmSkill.attackTwice(p1,p2,respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害,玩家二死亡");
                    break;
                }
                respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害");
                respond.fightProcess.add("玩家二 >>>>");
                Crit.isCrit(p2,p1,respond);
                HarmSkill.attackTwice(p2,p1,respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害,玩家一死亡");
                    break;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                roundCount ++;
            }else {
                respond.fightProcess.add("第"+roundCount+"回合，玩家二 >>>>");
                Crit.isCrit(p2,p1,respond);
                HarmSkill.attackTwice(p1,p2,respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害,玩家一死亡");
                    break;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                respond.fightProcess.add("玩家一 >>>>");
                Crit.isCrit(p1,p2,respond);
                HarmSkill.attackTwice(p2,p1,respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害,玩家二死亡");
                    break;
                }
                respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害");
                roundCount ++;
            }
        }
        //3. 结算战斗  获取经验   升级---->基础属性的提升
        //ps：获胜的一方 直接升级 --> 攻防+1  血量+5
        if (p1.getHealth()>0){
            p1.setAttack(p1.getAttack()+1);
            p1.setDefensive(p1.getDefensive()+1);
            p1.setHealth(p1Health+5);
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
        }else {
            p2.setAttack(p2.getAttack()+1);
            p2.setDefensive(p2.getDefensive()+1);
            p2.setHealth(p2Health+5);
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
        }
        return respond.fightProcess;
    }
}
