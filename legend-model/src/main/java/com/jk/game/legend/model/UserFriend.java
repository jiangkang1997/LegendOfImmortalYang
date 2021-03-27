package com.jk.game.legend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiayuyang
 * @create 2021-03-26-22:37
 */
@Data
@NoArgsConstructor
public class UserFriend {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 好友列表
     */
    private String userFriend;

    /**
     * 好友请求
     */
    private String friendRequest;

    public UserFriend(String userFriend, String friendRequest) {
        this.userFriend = userFriend;
        this.friendRequest = friendRequest;
    }
}
