package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.UserFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author xiayuyang
 * @create 2021-03-27-21:40
 */
@Mapper
@Component
public interface SeeMyFriendMapper {
    /**
     * 获取玩家好友请求
     * @param userId
     * @return
     */
    String getFriendRequest(@Param("userId") Integer userId);

    /**
     * 获取玩家好友信息
     * @param userId
     * @return
     */
    UserFriend getUserFriendById(@Param("userId") Integer userId);
}
