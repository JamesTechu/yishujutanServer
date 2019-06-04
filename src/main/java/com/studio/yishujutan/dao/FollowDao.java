package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Follow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowDao {

    String[] getFollowsByUserID(String user_id);

    Follow isFollowed(@Param("user_id") String user_id, @Param("friends_id") String friends_id);

    void doFollow(Follow follow);

    void cancelFollow(Follow follow);
}
