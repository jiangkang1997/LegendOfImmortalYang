package com.jk.game.legend.server.service;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:42
 */
public interface AddFriendService {
    /**
     * 通过游戏名查询用户信息
     * @param userName
     * @return UserInfo
     * @throws BusinessException
     */
    boolean getUserInfoByUserName(String userName) throws BusinessException;
}