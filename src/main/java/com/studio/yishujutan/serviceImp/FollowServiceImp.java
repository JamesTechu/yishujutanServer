package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.FollowDao;
import com.studio.yishujutan.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImp implements FollowService {

    @Autowired
    FollowDao followDao;

    @Override
    public String[] getFollowsByUserID(String user_id) {
        return followDao.getFollowsByUserID(user_id);
    }
}
