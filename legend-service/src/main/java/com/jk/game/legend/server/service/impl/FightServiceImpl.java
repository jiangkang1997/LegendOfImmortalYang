package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.fight.FightManage;
import com.jk.game.legend.server.mapper.UserInfoMapper;
import com.jk.game.legend.server.service.FightService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jk
 * @date 2021/3/20 22:20
 */
@Component
public class FightServiceImpl implements FightService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public List<String> doFight(int p1Id, int p2Id) throws BusinessException {

        //todo： 玩家的等级   经验值   每一级对应多少经验
        //1. 通过id查出双方玩家的属性
        UserInfo userInfop1 = userInfoMapper.getUserInfoByUserId(p1Id);
        UserInfo userInfop2 = userInfoMapper.getUserInfoByUserId(p2Id);
        //2. 模拟对战 封装 result 对象
        List<String> result = FightManage.doFight(userInfop1,userInfop2);


        return new ArrayList<>(result);
    }
}
