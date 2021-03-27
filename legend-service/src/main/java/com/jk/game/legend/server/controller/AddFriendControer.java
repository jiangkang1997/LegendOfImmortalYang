package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.service.AddFriendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:36
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class AddFriendControer {


    @Resource
    private AddFriendService addFriendService;

    /**
     * 玩家一给玩家二发送好友请求
     * @param userNamep1
     * @param userNamep2
     * @return
     */
    @PostMapping("/AddFriend")
    public HttpResponseBuilder addFriendControer(String userNamep1,String userNamep2){
        if (userNamep1.equals(userNamep2)){
            return HttpResponseBuilder.builderFail("不能加自己好友！");
        }else if(!StringUtils.hasText(userNamep2)){
            return HttpResponseBuilder.builderFail("游戏ID不能为空！");
        }
        String respond;
        try {
            respond = addFriendService.getUserInfoByUserName(userNamep1,userNamep2);
        }catch (BusinessException e){
            return HttpResponseBuilder.builderFail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess(respond);
    }
}
