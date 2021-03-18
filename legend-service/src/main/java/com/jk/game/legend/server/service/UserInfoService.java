package com.jk.game.legend.server.service;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author xiayuyang
 */
@Component
public interface UserInfoService {

    /**
     * 通过id查询用户信息
     * @param userId
     * @return UserInfo
     * @throws BusinessException
     */
    UserInfo getUserInfoByUserId(Integer userId) throws BusinessException;
}
