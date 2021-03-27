package com.jk.game.legend.server.service;

/**
 * @author xiayuyang
 * @create 2021-03-26-20:05
 */
public interface HandleFriendRequestService {

    /**
     * 处理自己的好友请求，P1是否同意P2的好友申请
     * @param isAdd
     * @return
     */
    void manageFriendRequest(boolean isAdd,String userNameP1,String userNamep2);
}
