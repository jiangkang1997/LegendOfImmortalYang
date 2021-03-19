package com.jk.game.legend.client.service.impl;

import com.jk.game.legend.client.service.UserService;
import com.jk.game.legend.client.util.HttpUtil;
import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;

/**
 * @author jk
 * @date 2021/3/18 23:54
 */
@Component
public class UserServiceImpl implements UserService {

    @Resource
    HttpUtil httpUtil;

    @Override
    public HttpResponseBuilder login(String userName, String password) {
        String path = "/user/login";
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userName", userName);
        requestEntity.add("password", password);
        return  httpUtil.doPost(path, requestEntity);
    }

    @Override
    public HttpResponseBuilder register(String userName, String password) {
        String path = "/user/register";
        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add("userName", userName);
        requestEntity.add("password", password);
        return  httpUtil.doPost(path, requestEntity);
    }
}
