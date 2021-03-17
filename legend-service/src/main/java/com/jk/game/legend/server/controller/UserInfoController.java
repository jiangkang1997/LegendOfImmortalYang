package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.model.UserInfo;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 */
@RestController
@RequestMapping("/id")
/**
 * Log4J框架 ：log是日志的意思，for是为了的意思，J是java
 * 原意：java的日志
 * 加了注解之后，这个框架会往这个类里面自动放log对象
 * log.info（）：打一般调试的信息
 * log.error（）：主要用来打印错误信息，用来报错
 */
@Slf4j
public class UserInfoController {
    /**
     * spring 框架的作用（把实现类的对象New出来给idService，下面用的idService实际上用的
     *                  UserInfoServiceImpl） 单例模式
     */
    @Resource
    private UserInfoService idService;

    @PostMapping("/info")
    @GetMapping
    public HttpResponseBuilder info(Integer userId){
        if (!StringUtils.hasText(Integer.toString(userId))){
            return HttpResponseBuilder.builderFail("id不能为空");
        }
        UserInfo userInfo;
        try {
            userInfo = idService.search(userId);
        }catch (BusinessException e) {
            return HttpResponseBuilder.builderFail(e.getMessage());
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统异常");
        }
        return HttpResponseBuilder.builderSuccess(userInfo);
    }
}
