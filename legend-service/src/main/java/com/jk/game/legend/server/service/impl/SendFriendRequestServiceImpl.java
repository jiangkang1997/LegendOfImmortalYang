package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserFriend;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.HandleMyFriendRequestMapper;
import com.jk.game.legend.server.mapper.SeeMyFriendMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.SendFriendRequestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:37
 */
@Service
public class SendFriendRequestServiceImpl implements SendFriendRequestService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private HandleMyFriendRequestMapper handleMyFriendRequestMapper;

    @Resource
    private SeeMyFriendMapper seeMyFriendMapper;

    /**
     * p1给p2发送好友请求
     * @param userIdp1
     * @param userNamep2
     * @return
     * @throws BusinessException
     */
    @Override
    public String getUserInfoByUserName(Integer userIdp1,Integer userNamep2) throws BusinessException {
        //通过玩家二的用户名在user表里查询是否存在
        UserFriend userFriendp1 = seeMyFriendMapper.getUserFriendById(userIdp1);
        if (userFriendp1 != null){
            //在user_friend表里添加新的好友请求
            handleMyFriendRequestMapper.updateFriendRequest(userFriendp1.getFriendRequest() + "," + userNamep2,userIdp1);
            return "请求已发送";
        }
        throw new BusinessException("该玩家不存在！");
    }
}
