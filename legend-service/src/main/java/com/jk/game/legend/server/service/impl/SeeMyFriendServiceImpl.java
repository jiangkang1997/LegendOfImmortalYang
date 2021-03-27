package com.jk.game.legend.server.service.impl;


import com.jk.game.legend.model.User;
import com.jk.game.legend.server.mapper.SeeMyFriendMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.SeeMyFriendRequestService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-19:42
 */
public class SeeMyFriendServiceImpl implements SeeMyFriendRequestService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private SeeMyFriendMapper seeMyFriendMapper;

    @Override
    public String seeMyFriendRequest(String userName) {
        //通过用户名在user表里查user
        User user = userMapper.getByUserName(userName);
        //返回user的好友请求
        String userFriendRequest =seeMyFriendMapper.getFriendRequest(user.getUserId());
        return userFriendRequest;
    }
}
