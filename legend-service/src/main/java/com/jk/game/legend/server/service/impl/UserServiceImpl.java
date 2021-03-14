package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jk
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public synchronized void register(String userName, String password) throws BusinessException {
        if(userMapper.getByUserName(userName) != null){
            throw new BusinessException("该id已存在");
        }
        User user = new User(userName,password);
        userMapper.insert(user);
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
