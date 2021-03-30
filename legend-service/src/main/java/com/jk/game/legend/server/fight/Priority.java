package com.jk.game.legend.server.fight;

import com.jk.game.legend.model.UserInfo;

/**
 * @author xiayuyang
 * @create 2021-03-30-19:37
 */
public class Priority {

    public static boolean priority(UserInfo p1, UserInfo p2){
        //速度相等则优先级随机,0为p1优先
        if (p1.getSpeed().equals(p2.getSpeed())){
            return (int) (Math.random() * 2) == 0;
        }
        return p1.getSpeed() > p2.getSpeed();
    }
}
