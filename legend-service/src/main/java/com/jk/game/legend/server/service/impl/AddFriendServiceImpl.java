package com.jk.game.legend.server.service.impl;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserFriend;
import com.jk.game.legend.server.common.BusinessException;
import com.jk.game.legend.server.mapper.AddFriendMapper;
import com.jk.game.legend.server.mapper.UserMapper;
import com.jk.game.legend.server.service.AddFriendService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xiayuyang
 * @create 2021-03-23-22:37
 */
@Service
public class AddFriendServiceImpl implements AddFriendService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private AddFriendMapper addFriendMapper;

    /**
     * p1给p2发送好友请求
     * @param userIdp1
     * @param userIdp2
     * @return
     * @throws BusinessException
     */
    @Override
    public String getUserInfoByUserName(Integer userIdp1,Integer userIdp2) throws BusinessException {
        //通过玩家二的用户名在user表里查询是否存在
        UserFriend userFriendp1 = addFriendMapper.getUserFriendById(userIdp1);
        if (userFriendp1 != null){
            //是否已经发送过请求或者已经是好友
            if (userFriendp1.getFriendRequest().contains(String.valueOf(userIdp2))){
                throw new BusinessException("请等待对方审核");
            }else if (userFriendp1.getUserFriend().contains(String.valueOf(userIdp2))){
                throw new BusinessException("对方已经是你的好友");
            }
            //好友请求列表为空
            if ("0".equals(userFriendp1.getFriendRequest())){
                addFriendMapper.updateFriendRequest("" + userIdp2,userIdp1);
                return "好友请求已发送";
            }
            //在user_friend表里添加新的好友请求
            addFriendMapper.updateFriendRequest(userFriendp1.getFriendRequest() + "," + userIdp2,userIdp1);
            return "好友请求已发送";
        }
        throw new BusinessException("该玩家不存在！");
    }

    @Override
    public String seeMyFriendRequest(Integer userId) {
        UserFriend userFriend = addFriendMapper.getUserFriendById(userId);
        return userFriend.getFriendRequest();
    }

    @Override
    public void handleFriendRequest(boolean isAdd, Integer userIdp1,Integer userIdp2) {
        //获取p1的好友信息
        UserFriend userFriendp1= addFriendMapper.getUserFriendById(userIdp1);
        //更新p1的好友请求
        //当好友请求只有一个时
        if (userFriendp1.getFriendRequest().contains(String.valueOf(userIdp2))){
            addFriendMapper.updateFriendRequest(userFriendp1.getFriendRequest().replace(String.valueOf(userIdp2), "0"),userIdp1);
        }else{
            addFriendMapper.updateFriendRequest(userFriendp1.getFriendRequest().replace(","+userIdp2, ""),userIdp1);
        }
        if (isAdd){
            //同意请求
            //好友列表为空
            if ("0".equals(userFriendp1.getUserFriend())){
                addFriendMapper.addFriendByUserId(userIdp1,""+userIdp2);
            }else {
                //在p1玩家的好友列表加入p2
                userFriendp1.setUserFriend(userFriendp1.getUserFriend()+","+userIdp2);
                //通过p1玩家的Id修改p1的好友列表，更改数据库
                addFriendMapper.addFriendByUserId(userIdp1,userFriendp1.getUserFriend());
            }
        }
    }
}
