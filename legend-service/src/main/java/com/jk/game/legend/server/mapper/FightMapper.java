package com.jk.game.legend.server.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
@author xiayuyang
@create 2021-04-13 20:47 
*/
@Mapper
@Component
public interface FightMapper {

    /**
     * 通过Id更新玩家的等级
     * @param userId
     * @param number
     */
    void updateLevelByUserId (@Param("userId") Integer userId,Integer number);

    /**
     * 通过Id更新玩家的攻击力
     * @param userId
     * @param number
     */
    void updateAttackByUserId(@Param("userId") Integer userId,Integer number);

    /**
     * 通过Id更新玩家的防御
     * @param userId
     * @param number
     */
    void updateDefensiveByUserId(@Param("userId") Integer userId,Integer number);

    /**
     * 通过Id更新玩家的血量
     * @param userId
     * @param number
     */
    void updateHealthByUserId(@Param("userId") Integer userId,Integer number);

    /**
     * 通过Id更新玩家的基本信息
     * @param userId
     * @param attack
     * @param defensive
     * @param health
     */
    void updateInfo(@Param("userId") Integer userId,
                    @Param("attack") Integer attack,
                    @Param("defensive") Integer defensive,
                    @Param("health") Integer health
                    );

}
