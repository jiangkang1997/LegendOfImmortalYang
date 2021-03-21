package com.jk.game.legend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;


/**
 * Data：自动生成get，set方法,自动重写toString
 * NoArgsConstructor：自动生成无参构造
 * @author xiayuyang
 */
@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    /**
     *用户ID
     */
    private Integer userId;

    /**
     * 用户攻击
     */
     private Integer attack;

    /**
     *用户防御
     */
    private Integer defensive;

    /**
     * 用户血量
     */
    private Integer health;

    /**
     *暴击率
     */
    private Double critical;

    /**
     * 速度
     */
    private Integer speed;


    public UserInfo(Integer attack, Integer defensive, Integer health, double critical, Integer speed){
        this.attack = attack;
        this.defensive = defensive;
        this.health = health;
        this.critical = critical;
        this.speed = speed;
    }

    public UserInfo(Integer userId){
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userId, userInfo.userId);
    }
}
