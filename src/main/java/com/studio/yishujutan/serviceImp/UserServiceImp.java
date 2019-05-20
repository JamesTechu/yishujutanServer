package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.UserDao;
import com.studio.yishujutan.entity.User;
import com.studio.yishujutan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserIconAndNickNameById(String user_id) {
        return userDao.getUserIconAndNickNameById(user_id);
    }

    @Override
    public User getUserPageInfo(String user_id) {
        return userDao.getUserPageInfo(user_id);
    }
}
