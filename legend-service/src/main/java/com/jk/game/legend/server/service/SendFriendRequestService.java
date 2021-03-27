package com.jk.game.legend.server.service;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:42
 */
public interface SendFriendRequestService {

    /**
     * 通过游戏名查询用户信息
     * @param userNamep1
     * @param userNamep2
     * @return
     * @throws BusinessException
     */
    String getUserInfoByUserName(String userNamep1,String userNamep2) throws BusinessException;
}
