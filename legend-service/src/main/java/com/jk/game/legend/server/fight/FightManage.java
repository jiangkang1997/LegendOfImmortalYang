package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/3/20 22:26
 */
public class FightManage {

    public static List<String> doFight(UserInfo p1, UserInfo p2){

        Respond respond = new Respond(new ArrayList<>(),0,false,new int[10],1);
        //记录下开始的双方玩家的血量
        int p1Health = p1.getHealth();
        int p2Health = p2.getHealth();
        //确定第一次攻击的优先级
        boolean priority = Priority.priority(p1, p2);
        //对战过程
        respond = FightProcess.fightProcess(respond,p1,p2,priority);


        //结算战斗，攻防+1，血量+5
        if (p1.getHealth()>0){
            p1.setAttack(p1.getAttack()+1);
            p1.setDefensive(p1.getDefensive()+1);
            p1.setHealth(p1Health+5);
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
            //respond.winner = true;
        }else {
            p2.setAttack(p2.getAttack()+1);
            p2.setDefensive(p2.getDefensive()+1);
            p2.setHealth(p2Health+5);
            respond.fightProcess.add("恭喜您升级了！攻防+1，血量+5");
            //respond.winner = false;
        }
        return respond.fightProcess;
    }
}
