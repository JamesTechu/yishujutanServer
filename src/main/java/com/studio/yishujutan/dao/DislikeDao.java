package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Dislike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DislikeDao {

    Dislike isDisliked(@Param("user_id")String user_id, @Param("essay_id")String essay_id);

    void doDislike(Dislike dislike);

    void cancelDislike(Dislike dislike);
}
