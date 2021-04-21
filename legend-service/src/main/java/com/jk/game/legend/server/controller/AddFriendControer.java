package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.common.BusinessException;

import com.jk.game.legend.server.service.AddFriendService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:36
 */
@RestController
@RequestMapping("/friend")
@Slf4j
public class AddFriendControer {


    @Resource
    private AddFriendService addFriendService;

    /**
     * 玩家二给玩家一发送好友请求
     * @param userIdp1
     * @param userIdp2
     * @return
     */
    @GetMapping("/sendRequest")
    public HttpResponseBuilder addFriendController(Integer userIdp1, Integer userIdp2){
        if (userIdp2==null || userIdp1==null){
            return HttpResponseBuilder.builderFail("游戏ID不能为空！");
        }else if(userIdp1.equals(userIdp2)){
            return HttpResponseBuilder.builderFail("不能加自己好友！");
        }
        String respond;
        try {
            respond = addFriendService.getUserInfoByUserName(userIdp1,userIdp2);
        }catch (BusinessException e){
            return HttpResponseBuilder.builderFail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess(respond);
    }

    /**
     * 查看我的好友请求
     * @param userId
     * @return
     */
    @GetMapping("/seeMyFriend")
    public HttpResponseBuilder seeMyFriendRequestController(Integer userId)  {
        String respond;
        try {
            respond = addFriendService.seeMyFriendRequest(userId);
        } catch (BusinessException e) {
            return HttpResponseBuilder.builderFail(e.getMessage());
        }
        return HttpResponseBuilder.builderFail(respond);

    }

    /**
     * 处理好友请求
     * @param isAdd
     * @param userIdp1
     * @param userIdp2
     */
    @GetMapping("/HandleRequest")
    public void manageFriendRequestController(boolean isAdd, Integer userIdp1, Integer userIdp2){
        addFriendService.handleFriendRequest(isAdd,userIdp1,userIdp2);
    }
}
