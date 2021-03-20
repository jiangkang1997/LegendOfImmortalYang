package com.jk.game.legend.server.controller;

import com.jk.game.legend.model.HttpResponseBuilder;
import com.jk.game.legend.server.service.FightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author jk
 * @date 2021/3/20 22:15
 */
@RestController
@RequestMapping("/fight")
public class FightController {

    @Resource
    private FightService fightService;


    @GetMapping("/doFight")
    public HttpResponseBuilder doFight(Integer p1Id,Integer p2Id){
        //fightService.doFight(p1Id, p2Id)
        if(p1Id==null || p2Id==null){
            return HttpResponseBuilder.builderFail("参数不能为空");
        }
        return HttpResponseBuilder.builderSuccess();
    }
}
