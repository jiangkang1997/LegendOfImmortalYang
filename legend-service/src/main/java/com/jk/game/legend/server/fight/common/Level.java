package com.jk.game.legend.server.fight.common;

import com.jk.game.legend.model.UserInfo;

import java.util.HashMap;
import java.util.Map;

/**
@author xiayuyang
@create 2021-04-13 20:42 
*/

public class Level {

    private static final Map<Integer,Double> levelMap = new HashMap<>();

    static {
         for (int i = 1; i <=100; i++) {
             levelMap.put(i,1.5*i);
         }
     }

    public static void isUpLevel(UserInfo winnerUserInfo,Respond respond){
        //升级所需经验
        Double upExperience = levelMap.get(winnerUserInfo.getLevel());
        //每次胜利默认获取1.5经验值
        respond.fightProcess.add("获得1.5经验值，");
        if (winnerUserInfo.getExperience()+1.5>=upExperience){
            //升级
            winnerUserInfo.setLevel(winnerUserInfo.getLevel()+1);
            respond.fightProcess.add("升级了！");
        }else {
            //没升级，经验+1.5
            winnerUserInfo.setExperience(winnerUserInfo.getExperience()+1.5);
            respond.fightProcess.add("只要"+(upExperience-winnerUserInfo.getExperience()+1.5)+"点经验就升级啦，请继续努力哦！");
        }
    }
}
