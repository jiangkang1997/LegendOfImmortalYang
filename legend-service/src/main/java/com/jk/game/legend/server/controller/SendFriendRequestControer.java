package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.service.SendFriendRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
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
@RequestMapping("/send")
@Slf4j
public class SendFriendRequestControer {


    @Resource
    private SendFriendRequestService sendFriendRequestService;

    /**
     * 玩家一给玩家二发送好友请求
     * @param userIdp1
     * @param userIdp2
     * @return
     */
    @GetMapping("/friendRequest")
    public HttpResponseBuilder addFriendControer(Integer userIdp1,Integer userIdp2){
        if (userIdp2==null || userIdp1==null){
            return HttpResponseBuilder.builderFail("游戏ID不能为空！");
        }else if(userIdp1.equals(userIdp2)){
            return HttpResponseBuilder.builderFail("不能加自己好友！");
        }
        String respond;
        try {
            respond = sendFriendRequestService.getUserInfoByUserName(userIdp1,userIdp2);
        }catch (BusinessException e){
            return HttpResponseBuilder.builderFail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess(respond);
    }
}
