package com.jk.game.legend.server.service;


import com.jk.game.legend.server.common.BusinessException;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:42
 */
public interface AddFriendService {

    /**
     * 通过游戏名查询用户信息
     * @param userIdp1
     * @param userIdp2
     * @return
     * @throws BusinessException
     */
    String getUserInfoByUserName(Integer userIdp1,Integer userIdp2) throws BusinessException;

    /**
     * 通过ID查看好友请求
     * @param userId
     * @return
     */
    String seeMyFriendRequest(Integer userId) throws BusinessException;


    /**
     * P1是否同意P2的好友申请
     * @param isAdd
     * @return
     */
    void handleFriendRequest(boolean isAdd,Integer userIdp1,Integer userIdp2);
}
