package com.jk.game.legend.server.mapper;

import com.jk.game.legend.model.User;
import com.jk.game.legend.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * mapper后缀是为了查数据库
 * UserIdMapper的实现类为UserIdMapper.xml文件
 * @author xiayuyang
 */
@Mapper
@Component
public interface UserInfoMapper {
    /**
     * param注解是为了让数据库里访问到形参userId
     * 根据用户id在数据库里查询用户
     * @param userId
     * @return
     */
    UserInfo getUserInfoByUserId(@Param("userId") Integer userId);

    /**
     * 通过Id插入
     * @param userInfo
     * @return
     */
    void insert(UserInfo userInfo);
}
