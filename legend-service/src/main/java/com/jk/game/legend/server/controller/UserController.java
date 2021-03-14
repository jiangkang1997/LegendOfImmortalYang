package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.BusinessException;
import com.jk.game.legend.server.common.RoleCheck;
import com.jk.game.legend.server.service.UserService;
import com.jk.game.legend.server.common.HttpResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author jk
 */
//spring mvc框架
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * spring 框架的作用 单例模式
     */
    @Resource
    private UserService userService;

    @PostMapping("/login")
    @GetMapping
    public HttpResponseBuilder login(String userName, String password, HttpSession session){
        if(!StringUtils.hasText(userName)  || !StringUtils.hasText(password)){
            return HttpResponseBuilder.builderFail("账号或密码不能为空");
        }
        User user;
        try {
            user = userService.login(userName, password);
            session.setAttribute("user",user);
        }catch (BusinessException e){
            return HttpResponseBuilder.builderFail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess(user);
    }

    @PostMapping("/register")
    public HttpResponseBuilder register(String userName, String password){
        if(!StringUtils.hasText(userName)  || !StringUtils.hasText(password)){
            return HttpResponseBuilder.builderFail("账号或密码不能为空");
        }
        try {
            userService.register(userName, password);
        }catch (BusinessException e){
            return HttpResponseBuilder.builderFail(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess();
    }

    @PostMapping("/isUserExist")
    public HttpResponseBuilder isUserExist(String userName){
        if(!StringUtils.hasText(userName)){
            return HttpResponseBuilder.builderFail("参数不能为空");
        }
        Boolean exist;
        try {
            exist = userService.isUserExist(userName);
        }catch (Exception e) {
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }
        return HttpResponseBuilder.builderSuccess(exist);
    }

    @RoleCheck
    @PostMapping("/getUser")
    public HttpResponseBuilder getUser(HttpSession session){
        try{
            User user = (User) session.getAttribute("user");
            return HttpResponseBuilder.builderSuccess(user);
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return HttpResponseBuilder.builderFail("系统错误");
        }

    }
}
