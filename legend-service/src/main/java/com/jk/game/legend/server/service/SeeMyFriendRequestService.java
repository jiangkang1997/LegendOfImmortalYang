package com.jk.game.legend.server.service;

import com.jk.game.legend.server.common.BusinessException;

/**
 * @author xiayuyang
 * @create 2021-03-26-19:39
 */
public interface SeeMyFriendRequestService {

    /**
     * 查看自己的好友请求
     * @param userName
     * @return
     */
    String seeMyFriendRequest(String userName);


}
