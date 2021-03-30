package com.jk.game.legend.server.fight;

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
     *每回合伤害汇总
     */
    int harmCollect;

    /**
     * 对局赢家
     * true代表获胜
     */
    public boolean winner;

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
    public int[] isTouchSkills;

    /**
     * 玩家1
     */
    UserInfo p1;

    /**
     * 玩家2
     */
    UserInfo p2;

    int count;

    public Respond(List<String> fightProcess, int harmCollect ,boolean winner, int[] isTouchSkills, int count) {
        this.fightProcess = fightProcess;
        this.harmCollect = harmCollect;
        this.winner = winner;
        this.isTouchSkills = isTouchSkills;
        this.count = count;
    }
}
