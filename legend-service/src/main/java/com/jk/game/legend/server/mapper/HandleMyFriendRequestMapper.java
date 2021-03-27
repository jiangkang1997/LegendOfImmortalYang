package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserFriend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author xiayuyang
 * @create 2021-03-26-21:01
 */
@Mapper
@Component
public interface HandleMyFriendRequestMapper {

    /**
     * 根据p1的ID加入到p2的好友列表
     * @param userID
     * @return
     */
    void addFriendByUserId(@Param("userID") Integer userID);

    /**
     * 根据ID在user_friend表中插入初始化好友信息
     * @param userFriend
     */
    void insertByUserId(@Param("userFriend") UserFriend userFriend);

    /**
     * 处理好友请求
     * @param friendRequest
     */
    void updateFriendRequest(@Param("friendRequest")String friendRequest,
                             @Param("userId")Integer userId );

}
