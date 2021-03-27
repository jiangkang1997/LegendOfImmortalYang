package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.service.HandleFriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-26-20:04
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class HandleFriendRequestController {

    @Resource
    private HandleFriendRequestService manageFriendRequestService;

    @PostMapping("/HandleFriendRequest")
    public void manageFriendRequestControer(boolean isAdd,String userNameP1,String userNameP2){
        manageFriendRequestService.manageFriendRequest(isAdd,userNameP1,userNameP2);
    }




}
