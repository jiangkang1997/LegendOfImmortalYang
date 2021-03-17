package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * mapper后缀是为了查数据库
 * UserIdMapper的实现类UserIdMapper.xml文件
 * @author xiayuyang
 */
@Mapper
@Component
public interface UserInfoMapper {
    /**
     * 根据用户id查询用户
     * @param userId
     * @return
     */
    UserInfo getUserInfoByUserId(@Param("userId") Integer userId);
}
