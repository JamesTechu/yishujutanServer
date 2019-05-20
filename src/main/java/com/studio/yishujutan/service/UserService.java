package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.User;

public interface UserService {

    //获得关注列表所需要显示的用户信息
    User getUserIconAndNickNameById(String user_id);

    User getUserPageInfo(String user_id);
}
