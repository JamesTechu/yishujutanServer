package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Praise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PraiseDao {

    Praise isPraised(@Param("user_id")String user_id,@Param("essay_id")String essay_id);

    void doPraise(Praise praise);

    void cancelPraise(Praise praise);
}
