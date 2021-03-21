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

        List<String> result = new ArrayList<>();
        boolean priorityFlag;
        int roundCount = 1;
        double critp1;
        double critp2;
        int p1Health = p1.getHealth();
        int p2Health = p2.getHealth();
        if (p1.getSpeed().equals(p2.getSpeed())){
            int randomFlag = (int) (Math.random() * 2);
            priorityFlag = randomFlag == 0;
        }else {
            priorityFlag = p1.getSpeed() > p2.getSpeed();
        }
        //2. 防御减伤比    n/(n+5)
        //3. 爆伤 1.5
        while (p1.getHealth() >0 && p2.getHealth()>0){
            critp1 = (int) (Math.random() * 101);
            result.add(critp1+"");
            result.add(p1.getCritical() * 100 +"");
            critp2 = (int) (Math.random() * 101);
            if (critp1 <= p1.getCritical() * 100){
                critp1 = 1.5;
                result.add("1111");
            }else {
                critp1 = 1;
            }
            if (critp2<=p2.getCritical() * 100){
                critp2 = 1.5;
            }else {
                critp2 = 1;
            }
            if (priorityFlag){
                p2.setHealth(p2.getHealth() - (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1));
                if (p2.getHealth()<=0){
                    result.add("第"+roundCount+"回合："+
                            "玩家1给玩家2造成了"+
                            (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1)+"点伤害，" +
                            "玩家2死亡");
                    break;
                }
                p1.setHealth(p1.getHealth() - (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2));
                if (p1.getHealth()<=0){
                    result.add("第"+roundCount+"回合："+
                            "玩家2给玩家1造成了"+
                            (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2)+"点伤害，" +
                            "玩家1死亡");
                    break;
                }
                result.add("第"+roundCount+"回合："+
                        "玩家1给玩家2造成了"+
                        (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1)+"点伤害，" +
                        "玩家2还剩"+p2.getHealth()+"点血。"+
                        "玩家2给玩家1造成了"+
                        (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2)+"点伤害，" +
                        "玩家1还剩"+p1.getHealth()+"点血。");
                roundCount ++;
            }else {
                p1.setHealth(p1.getHealth() - (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2));
                if (p1.getHealth()<=0){
                    result.add("第"+roundCount+"回合："+
                            "玩家2给玩家1造成了"+
                            (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2)+"点伤害，" +
                            "玩家1死亡");
                    break;
                }
                p2.setHealth(p2.getHealth() - (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1));
                if (p2.getHealth()<=0){
                    result.add("第"+roundCount+"回合："+
                            "玩家1给玩家2造成了"+
                            (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1)+"点伤害，" +
                            "玩家2死亡");
                    break;
                }
                result.add("第"+roundCount+"回合："+
                        "玩家2给玩家1造成了"+
                        (int)((p2.getAttack()*p1.getDefensive()/(p1.getDefensive() + 5)) * critp2)+"点伤害，" +
                        "玩家1还剩"+ p1.getHealth()+"点血。"+
                        "玩家1给玩家2造成了"+
                        (int)((p1.getAttack()*p2.getDefensive()/(p2.getDefensive() + 5)) * critp1)+"点伤害，" +
                        "玩家2还剩"+p2.getHealth()+"点血。");
                roundCount ++;
            }
        }
        //3. 结算战斗  获取经验   升级---->基础属性的提升
        //ps：获胜的一方 直接升级 --> 攻防+1  血量+5
        if (p1.getHealth()>0){
            p1.setAttack(p1.getAttack()+1);
            p1.setDefensive(p1.getDefensive()+1);
            p1.setHealth(p1Health+5);
            result.add("恭喜您升级了！攻防+1，血量+5");
        }else {
            p2.setAttack(p2.getAttack()+1);
            p2.setDefensive(p2.getDefensive()+1);
            p2.setHealth(p2Health+5);
            result.add("恭喜您升级了！攻防+1，血量+5");
        }
        return result;
    }
}
