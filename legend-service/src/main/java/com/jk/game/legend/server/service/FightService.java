package com.jk.game.legend.server.service;

import com.jk.game.legend.server.common.BusinessException;

import java.util.List;

/**
 * @author jk
 * @date 2021/3/20 22:19
 */
public interface FightService {

    /**
     * 玩家一 与 玩家二决斗
     * @param p1Id
     * @param p2Id
     * @return 双方玩家的对战过程
     * @throws BusinessException
     */
    List<String> doFight(int p1Id, int p2Id) throws BusinessException;
}
