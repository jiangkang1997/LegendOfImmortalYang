package com.jk.game.legend.server.controller;


import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.service.SeeMyFriendRequestService;
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
@RequestMapping("/see")
@Slf4j
public class SeeMyFriendRequestController {

    @Resource
    private SeeMyFriendRequestService seeMyFriendRequestService;

    @PostMapping("/friendRequest")
    public HttpResponseBuilder seeMyFriendRequestControer(String userName)  {
        return HttpResponseBuilder.builderSuccess(seeMyFriendRequestService.seeMyFriendRequest(userName));
    }
}
