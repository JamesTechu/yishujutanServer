package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    //获得关注列表所需要显示的用户信息
    User getUserIconAndNickNameById(String user_id);

    User getUserPageInfo(String user_id);

    //判断用户是否已经注册
    User isRegister(String user_id);

    //注册
    void register(User user);

    List<User> getAlluser();
}
