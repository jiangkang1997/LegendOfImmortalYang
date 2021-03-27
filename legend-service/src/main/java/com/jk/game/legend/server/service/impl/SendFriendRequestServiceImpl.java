package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.HandleMyFriendRequestMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.SendFriendRequestService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:37
 */
public class SendFriendRequestServiceImpl implements SendFriendRequestService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private HandleMyFriendRequestMapper handleMyFriendRequestMapper;

    /**
     * p1给p2发送好友请求
     * @param userNamep1
     * @param userNamep2
     * @return
     * @throws BusinessException
     */
    @Override
    public String getUserInfoByUserName(String userNamep1,String userNamep2) throws BusinessException {
        //通过玩家二的用户名在user表里查询是否存在
        User user2 =userMapper.getByUserName(userNamep2);
        if (user2 != null){
            //通过玩家一的用户名在user表里找到玩家一
            User user1 = userMapper.getByUserName(userNamep1);
            //在user_friend表里通过玩家二的ID，添加新的好友请求
            handleMyFriendRequestMapper.updateFriendRequest(user2.getUserFriend().getFriendrequest()+user1.getUserId());
            return "请求已发送";
        }
        throw new BusinessException("该玩家不存在！");
    }
}
