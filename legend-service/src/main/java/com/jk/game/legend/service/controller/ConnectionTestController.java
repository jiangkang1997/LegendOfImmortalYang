package com.jk.game.legend.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jk
 * @date 2021/3/13 21:29
 */
@RestController
@RequestMapping("/test")
public class ConnectionTestController {

    @RequestMapping("/connection")
    public String connectionTest(){
        return "成功连接到服务器";
    }
}
