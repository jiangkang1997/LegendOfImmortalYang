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
        //1. 确定先后手 速度一样就随机

        //2. 防御减伤比    n/(n+5)

        //3. 爆伤 1.5

        while (p1.getHealth() >0 && p2.getHealth()>0){

        }

        return result;
    }
}
