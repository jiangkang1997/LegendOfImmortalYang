package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserFriend;
import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.AddFriendMapper;
import com.jk.game.legend.server.mapper.UserInfoMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Service就是为了做具体的业务逻辑
 * Impl为后缀就是实现类
 * @author jk
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserInfoMapper userInfoMapper;
    @Resource
    private AddFriendMapper AddFriendMapper ;


    @Override
    public synchronized void register(String userName, String password) throws BusinessException {
        if(userMapper.getByUserName(userName) != null){
            throw new BusinessException("该id已存在");
        }
        //创建user1对象，将对象加到数据库
        User user1 = new User(userName,password);
        userMapper.insert(user1);
        //初始化玩家信息和好友信息
        User user2 = userMapper.getByUserName(userName);
        userInfoMapper.insert(user2.getUserId());
        AddFriendMapper.insertByUserId(user2.getUserId());
    }

    @Override
    public User login(String userName, String password) throws BusinessException {
        User user = userMapper.login(userName, password);
        if(user == null){
            throw new BusinessException("账号或密码错误");
        }
        return user;
    }

    @Override
    public boolean isUserExist(String userName){
        return userMapper.getByUserName(userName) != null;
    }
}
