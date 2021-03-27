package com.jk.game.legend.server.service.impl;


import com.jk.game.legend.model.User;
import com.jk.game.legend.server.mapper.AddFriendMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.CheckMyFriendRequestService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-19:42
 */
public class CheckMyFriendServiceImpl implements CheckMyFriendRequestService {


    @Resource
    private UserMapper userMapper;

    @Resource
    private AddFriendMapper addFriendMapper;

    @Override
    public String checkMyFriendRequest(String userName) {
        //通过用户名在user表里查user
        User user = userMapper.getByUserName(userName);
        //查到user，通过ID在user_friend表里查user，从而得到好友请求信息
        User user1 = addFriendMapper.checkFriendRequest(user.getUserId());
        return user1.getFriendrequest();
    }
}
