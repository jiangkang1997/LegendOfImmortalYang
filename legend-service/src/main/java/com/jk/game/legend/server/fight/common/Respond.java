package com.jk.game.legend.server.fight.common;

import com.jk.game.legend.model.UserInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author xiayuyang
 * @create 2021-03-22-22:30
 */
@Data
@NoArgsConstructor
/**
 * 调用技能方法时，每次返回的数据
 */
public class Respond {
    /**
     * 打斗文案，记录战斗的过程
     */
    public List<String> fightProcess;

    /**
     * 对局赢家
     */
    public String winner;

    /**
     * 战斗过程中是否触发技能
     * 1 暴击
     * 2 无影手
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     */
    public List<Integer> isTouchSkills;

    /**
     * 玩家1
     */
    UserInfo p1;

    /**
     * 玩家2
     */
    UserInfo p2;

    int count;

    public static String player1 = "玩家一";

    public static String player2 = "玩家二";

    public Respond(List<String> fightProcess,String winner, List<Integer> isTouchSkills, int count,UserInfo p1, UserInfo p2) {
        this.fightProcess = fightProcess;
        this.winner = winner;
        this.isTouchSkills = isTouchSkills;
        this.count = count;
        this.p1 = p1;
        this.p2 = p2;
    }
}
