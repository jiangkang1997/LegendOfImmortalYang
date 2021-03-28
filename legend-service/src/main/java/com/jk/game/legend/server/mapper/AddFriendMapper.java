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
public interface AddFriendMapper {

    /**
     * 获取玩家好友信息
     * @param userId
     * @return
     */
    UserFriend getUserFriendById(@Param("userId") Integer userId);

    /**
     * 加好友
     * @param userId
     * @return
     */
    void addFriendByUserId(@Param("userId") Integer userId,
                           @Param("userFriend") String userFriend);

    /**
     * 根据ID在user_friend表中插入初始化好友信息
     * @param userFriend
     */
    void insertByUserId(UserFriend userFriend);

    /**
     * 处理好友请求
     * @param friendRequest
     */
    void updateFriendRequest(@Param("friendRequest")String friendRequest,
                             @Param("userId")Integer userId );
}
