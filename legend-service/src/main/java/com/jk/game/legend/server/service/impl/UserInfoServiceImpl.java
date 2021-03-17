package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.UserInfoMapper;
import com.jk.game.legend.server.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author xiayuyang
 */
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByUserId(Integer userId) throws BusinessException {
        UserInfo userInfo = userInfoMapper.getUserInfoByUserId(userId);
        if(userInfo== null){
            throw new BusinessException("该id不存在");
        }
        return userInfo;
    }
}
