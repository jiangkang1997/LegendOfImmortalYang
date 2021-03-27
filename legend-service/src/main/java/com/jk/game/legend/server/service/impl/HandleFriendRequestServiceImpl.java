package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.server.mapper.HandleMyFriendRequestMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.HandleFriendRequestService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-20:59
 */
public class HandleFriendRequestServiceImpl implements HandleFriendRequestService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private HandleMyFriendRequestMapper handleMyFriendRequestMapper;

    @Override
    public void handleFriendRequest(boolean isAdd, String userNameP1,String userNameP2) {
        //获取玩家1，2的信息
        User user1 = userMapper.getByUserName(userNameP1);
        User user2 = userMapper.getByUserName(userNameP2);
        //将玩家1中玩家2的好友请求清除，然后将处理好的新字符串插入到玩家1的好友请求中。
        handleMyFriendRequestMapper.updateFriendRequest(user1.getUserFriend().getFriendrequest().replace(String.valueOf(user2.getUserId()), ""));
        if (isAdd){
            //同意请求，在p1玩家的好友列表加入p2
            user1.getUserFriend().setSumUserFriend(user1.getUserFriend().getSumUserFriend()+user2.getUserId());
            //通过p1玩家的Id修改p1的好友列表，更改数据库
            handleMyFriendRequestMapper.addFriendByUserId(user1.getUserId());
        }
    }
}