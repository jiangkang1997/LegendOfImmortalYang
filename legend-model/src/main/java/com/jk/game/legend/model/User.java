package com.jk.game.legend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jk
 */
@Data
@NoArgsConstructor
public class User implements Serializable {

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 玩家好友
     */
    private String userFriend;

    /**
     * 玩家好友请求
     */
    private String friendrequest;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return getUserId().equals(user.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}