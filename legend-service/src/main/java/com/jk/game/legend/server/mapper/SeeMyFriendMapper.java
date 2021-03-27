package com.jk.game.legend.server.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author xiayuyang
 * @create 2021-03-27-21:40
 */
public interface SeeMyFriendMapper {
    /**
     * 获取玩家好友请求
     * @param userId
     * @return
     */
    String getFriendRequest(@Param("userId") Integer userId);
}
