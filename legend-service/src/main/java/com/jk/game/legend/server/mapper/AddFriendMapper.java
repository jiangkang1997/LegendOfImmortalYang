package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserFriend;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiayuyang
 * @create 2021-03-25-10:32
 */
public interface AddFriendMapper {

    /**
     * 根据用户ID查询user_friend表
     * @param userId
     * @return
     */
    User checkFriendRequest(@Param("userId") Integer userId);

    /**
     * 根据用户ID在user_friend表中插入好友请求
     * @param friendRequest
     * @return
     */
    void insertFriendRequest(@Param("userId") String friendRequest,Integer userID);

    /**
     * 根据用户ID在user_friend表中添加新好友
     * @param userFriend
     * @return
     */
    void insertFriend(@Param("userId") String userFriend,Integer userID);

    /**
     * 根据ID在user_friend表中插入
     * @param userFriend
     */
    void insertByUserId(@Param("userFriend") UserFriend userFriend);
}
