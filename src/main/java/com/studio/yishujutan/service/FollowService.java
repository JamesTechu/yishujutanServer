package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Follow;

public interface FollowService {

    String[] getFollowsByUserID(String user_id);

    Follow isFollowed(String user_id, String friends_id);

    void doFollow(Follow follow);

    void cancelFollow(Follow follow);
}


