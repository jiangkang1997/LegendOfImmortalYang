package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.server.mapper.AddFriendMapper;
import com.jk.game.legend.server.mapper.HandleMyFriendRequestMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.HandleFriendRequestService;
import com.jk.game.legend.server.service.UserService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-20:59
 */
public class HandleFriendRequestImpl implements HandleFriendRequestService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private AddFriendMapper addFriendMapper;

    @Resource
    private HandleMyFriendRequestMapper handleMyFriendRequestMapper;

    @Override
    public void manageFriendRequest(boolean isAdd, String userNameP1,String userNameP2) {
        //获取玩家1，2的信息
        User user1 = userMapper.getByUserName(userNameP1);
        User user2 = userMapper.getByUserName(userNameP2);
        //将玩家1中玩家2的好友请求清除，然后将处理好的新字符串插入到玩家1的好友请求中。
        addFriendMapper.insertFriendRequest(user1.getFriendrequest().replace(String.valueOf(user2.getUserId()), ""),user1.getUserId());
        if (isAdd){
            //同意请求，将玩家2的ID插入到玩家1的好友列表里

        }
    }
}
