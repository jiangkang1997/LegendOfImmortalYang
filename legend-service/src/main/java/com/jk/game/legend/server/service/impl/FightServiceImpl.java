package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.service.FightService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/3/20 22:20
 */
@Component
public class FightServiceImpl implements FightService {


    @Override
    public List<String> doFight(int p1Id, int p2Id) throws BusinessException {

        //todo： 玩家的等级   经验值   每一级对应多少经验

        //1. 通过id查出双方玩家的属性

        //2. 模拟对战 封装 result 对象
        //List<String> result = FightManage.doFight(p1,p2);

        //3. 结算战斗  获取经验   升级---->基础属性的提升
        //ps：获胜的一方 直接升级 --> 攻防+1  血量+5

        return new ArrayList<>();
    }
}
