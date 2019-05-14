package com.studio.yishujutan.service;

import org.springframework.stereotype.Service;

public interface FollowService {

    String[] getFollowsByUserID(String user_id);
}
