package com.jk.game.legend.client.service;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.model.User;

/**
 * @author jk
 * @date 2021/3/18 23:53
 */
public interface UserService {

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    HttpResponseBuilder login(String userName, String password);

    /**
     * 注册
     * @param userName
     * @param password
     * @return
     */
    HttpResponseBuilder register(String userName, String password);
}
