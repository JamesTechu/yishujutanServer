package com.studio.yishujutan.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectDao {

    String[] getCircleIds(String user_id);

}
