package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;

import java.util.Collections;

/**
 * @author xiayuyang
 * @create 2021-04-3-14:51
 */
public class ProcessRecord {
    static double basicDamagep1;
    static double basicDamagep2;
    static double critHarm = 0;
    static double attackTwice = 0;
    public static void record(Respond respond, UserInfo p1,UserInfo p2){
        //记录p1与p2玩家的基础伤害
        basicDamagep1 = p1.getAttack()*(double)p2.getDefensive()/(p2.getDefensive()+5);
        basicDamagep2 = p2.getAttack()*(double)p1.getDefensive()/(p1.getDefensive()+5);
        critHarm = 0;
        attackTwice = 0;
        //是否触发暴击
        respond.fightProcess.add(Respond.player1);
        if (respond.isTouchSkills.contains(0)){
            respond.fightProcess.add("触发暴击！");
            critHarm = basicDamagep1*0.5;
        }
        //是否触发无影手
        if (respond.isTouchSkills.contains(1)){
            respond.fightProcess.add("触发无影手，攻击两次");
            attackTwice = basicDamagep1;
        }
        //伤害结算

        respond.fightProcess.add("给"+Respond.player2+"造成"+(basicDamagep1+critHarm+attackTwice)+"点伤害");
        //被攻击一方是否死亡
        if (isDie(respond,p1,p2).winner!=null){
            return;
        }
        //被攻击一方没有死，是否触发反击，在攻击方触发无影手时，被攻击方有可能触发两次反击
        if (Collections.frequency(respond.isTouchSkills,2) ==1){
            respond.fightProcess.add(Respond.player2+"被攻击时触发一次反击，给"+Respond.player1+"造成"+basicDamagep2*0.5+"点伤害");
            p1.setHealth((int) (p1.getHealth() - basicDamagep2 * 0.5));
            //被攻击方反击时，攻击方是否死亡
            isDie(respond,p1,p2);
        }else if (Collections.frequency(respond.isTouchSkills,2) ==2){
            respond.fightProcess.add(Respond.player2+"被攻击时触发两次反击，给"+Respond.player1+"造成"+basicDamagep2+"点伤害");
            p1.setHealth((int) (p1.getHealth() - basicDamagep2));
            isDie(respond,p1,p2);
        }
    }

    public static Respond isDie(Respond respond, UserInfo p1, UserInfo p2){

        if (p2.getHealth()<=0){
            respond.fightProcess.add(Respond.player2+"死亡，"+Respond.player1+"胜");
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
            //赢家为p1
            respond.setWinner("p1");
            return respond;
        }else if (p1.getHealth()<=0){
            respond.fightProcess.add(Respond.player1+"死亡，"+Respond.player2+"胜");
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
            //赢家为p2
            respond.setWinner("p2");
            return respond;
        }
        return respond;
    }

}
