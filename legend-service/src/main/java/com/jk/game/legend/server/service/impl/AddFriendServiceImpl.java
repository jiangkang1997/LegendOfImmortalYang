package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.UserInfoMapper;
import com.jk.game.legend.server.service.AddFriendService;
import com.jk.game.legend.server.service.UserService;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:37
 */
public class AddFriendServiceImpl implements AddFriendService {

    @Resource
    private UserService userService;

    @Override
    public boolean getUserInfoByUserName(String userName) throws BusinessException {
        boolean addFriend = userService.isUserExist(userName);
        if (!addFriend){
            throw new BusinessException("该用户不存在");
        }
        return true;
    }
}
