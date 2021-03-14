package com.jk.game.legend.server.service;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.BusinessException;

/**
 * @author jk
 */
public interface UserService {

    /**
     * 注册
     * @param userName
     * @param password
     * @throws BusinessException
     */
     void register(String userName, String password) throws BusinessException;

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     * @throws BusinessException
     */
    User login(String userName, String password) throws BusinessException;

    /**
     * 检查用户是否存在
     * @param userName
     * @return
     * @throws Exception
     */
    boolean isUserExist(String userName);
}
