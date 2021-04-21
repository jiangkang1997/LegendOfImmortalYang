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
     * 已经添加的好友
     */
    private String addedFriend;

    /**
     * 好友请求
     */
    private String friendRequest;

    public UserFriend(String addedFriend, String friendRequest) {
        this.addedFriend = addedFriend;
        this.friendRequest = friendRequest;
    }
}
