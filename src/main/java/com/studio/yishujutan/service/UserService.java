package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    //获得关注列表所需要显示的用户信息
    User getUserIconAndNickNameById(String user_id);
}
