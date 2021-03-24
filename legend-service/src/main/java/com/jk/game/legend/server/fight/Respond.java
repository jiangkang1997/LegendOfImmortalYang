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
     * 伤害汇总，记录每次在基础伤害上增加或减少的值
     */
    double harmCollect;

    /**
     * 判断玩家是否死亡，true代表死亡
     */
    boolean isDie;

    /**
     * 玩家1
     */
    UserInfo p1;

    /**
     * 玩家2
     */
    UserInfo p2;

    public Respond(List<String> fightProcess, double harmCollect , boolean isDie) {
        this.fightProcess = fightProcess;
        this.harmCollect = harmCollect;
        this.isDie = isDie;
    }
}
