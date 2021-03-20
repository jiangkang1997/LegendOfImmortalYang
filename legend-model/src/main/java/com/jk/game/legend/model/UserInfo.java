package com.jk.game.legend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

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
    Integer userId;

    /**
     * 用户攻击
     */
     Integer attack;

    /**
     *用户防御
     */
    Integer defensive;

    /**
     * 用户血量
     */
    Integer health;

    /**
     *暴击率
     */
    Double critical;

    /**
     * 速度
     */
    Integer speed;


    public UserInfo(String s){
        attack = 5;
        defensive = 5;
        health = 5;
        critical = 0.05;
        speed = 5;
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
