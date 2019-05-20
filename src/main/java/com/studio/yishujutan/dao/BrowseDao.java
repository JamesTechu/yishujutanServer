package com.studio.yishujutan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BrowseDao {

    String[] getCircleIds(@Param("user_id")String user_id, @Param("number")int number);
}
