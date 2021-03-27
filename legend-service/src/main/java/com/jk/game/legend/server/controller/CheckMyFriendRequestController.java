package com.jk.game.legend.server.controller;


import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.service.CheckMyFriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-19:37
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class CheckMyFriendRequestController {

    @Resource
    private CheckMyFriendRequestService checkMyFriendRequestService;

    @PostMapping("/CheckFriend")
    public HttpResponseBuilder addFriendControer(String userName)  {
        String respond = checkMyFriendRequestService.checkMyFriendRequest(userName);
        return HttpResponseBuilder.builderSuccess(respond);
    }
}
