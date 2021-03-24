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
        //第一次攻击的优先级
        boolean priorityFlag;
        //记录回合
        int roundCount = 1;
        //记录下开始的双方玩家的血量
        int p1Health = p1.getHealth();
        int p2Health = p2.getHealth();
        //基于速度判断第一次攻击的优先级，若相同则优先级随机
        if (p1.getSpeed().equals(p2.getSpeed())){
            int randomFlag = (int) (Math.random() * 2);
            priorityFlag = randomFlag == 0;
        }else {
            priorityFlag = p1.getSpeed() > p2.getSpeed();
        }
        //对战过程
        while (p1.getHealth() >0 && p2.getHealth()>0){
            if (priorityFlag){
                //玩家一优先攻击，每次攻击之前初始化基础伤害，防御减伤比默认为n/n+5，n为防御值
                respond.setHarmCollect(p1.getAttack() * p2.getDefensive()/(p2.getDefensive()+5));
                //对战开始
                respond.fightProcess.add("第"+roundCount+"回合，玩家一 >>>>");
                //调用isCrit方法判断是否暴击
                Crit.isCrit(p1,p2,respond.getHarmCollect(),respond);
                //调用attackTwice方法判断是否触发攻击两次的技能
                HarmSkill.attackTwice(p1,p2,respond.getHarmCollect(),respond);
                //玩家一在该回合攻击完毕，判断玩家2是否死亡，若死亡，则结束对战
                if (respond.isDie){
                    respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害,玩家二死亡");
                    break;
                }
                respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害");
                //玩家二开始攻击，初始化基础伤害
                respond.setHarmCollect(p2.getAttack() * p1.getDefensive()/(p1.getDefensive()+5));
                respond.fightProcess.add("玩家二 >>>>");
                Crit.isCrit(p2,p1,respond.getHarmCollect(),respond);
                HarmSkill.attackTwice(p2,p1,respond.getHarmCollect(),respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害,玩家一死亡");
                    break;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                //回合结束
                roundCount ++;
            }else {
                //玩家二优先攻击
                respond.setHarmCollect(p2.getAttack() * p1.getDefensive()/(p1.getDefensive()+5));
                respond.fightProcess.add("第"+roundCount+"回合，玩家二 >>>>");
                Crit.isCrit(p2,p1,respond.getHarmCollect(),respond);
                HarmSkill.attackTwice(p1,p2,respond.getHarmCollect(),respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害,玩家一死亡");
                    break;
                }
                respond.fightProcess.add("给玩家1造成"+respond.getHarmCollect()+"点伤害");
                
                respond.setHarmCollect(p2.getAttack() * p1.getDefensive()/(p1.getDefensive()+5));
                respond.fightProcess.add("玩家一 >>>>");
                Crit.isCrit(p1,p2,respond.getHarmCollect(),respond);
                HarmSkill.attackTwice(p2,p1,respond.getHarmCollect(),respond);
                if (respond.isDie){
                    respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害,玩家二死亡");
                    break;
                }
                respond.fightProcess.add("给玩家2造成"+respond.getHarmCollect()+"点伤害");
                roundCount ++;
            }
        }
        //结算战斗，攻防+1，血量+5
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
