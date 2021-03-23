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
public class Respond {

    public List<String> fightProcess;
    double harmCollect;
    boolean isDie;
    UserInfo p1;
    UserInfo p2;

    public Respond(List<String> fightProcess, double harmCollect, boolean isDie) {
        this.fightProcess = fightProcess;
        this.harmCollect = harmCollect;
        this.isDie = isDie;
    }
}
