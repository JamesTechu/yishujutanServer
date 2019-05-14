package com.studio.yishujutan.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PictureDao {

    String getUserIconUrl(String user_id);
}
