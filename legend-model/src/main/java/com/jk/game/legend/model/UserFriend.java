package com.jk.game.legend.model;

/**
 * @author xiayuyang
 * @create 2021-03-26-22:37
 */
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
    private String friendrequest;

    public UserFriend(Integer userId, String userFriend, String friendrequest) {
        this.userId = userId;
        this.userFriend = userFriend;
        this.friendrequest = friendrequest;
    }
}
