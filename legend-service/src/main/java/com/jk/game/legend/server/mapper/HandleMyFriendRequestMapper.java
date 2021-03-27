package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiayuyang
 * @create 2021-03-26-21:01
 */
public interface HandleMyFriendRequestMapper {

    /**
     * 根据ID加入好友列表
     * @param userID
     * @return
     */
    void addFriend(@Param("userID") Integer userID);
}
