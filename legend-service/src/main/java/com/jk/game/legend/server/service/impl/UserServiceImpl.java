package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
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

    @Override
    public synchronized void register(String userName, String password) throws BusinessException {
        if(userMapper.getByUserName(userName) != null){
            throw new BusinessException("该id已存在");
        }
        User user = new User(userName,password);
        userMapper.insert(user);
        //创建初始化人物，插入到userinfo表
        UserInfo userInfo = new UserInfo(5,5,5,0.05);
        userInfo.setUserId(userMapper.getByUserName(userName).getUserId());
        userInfoMapper.insert(userInfo);
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
