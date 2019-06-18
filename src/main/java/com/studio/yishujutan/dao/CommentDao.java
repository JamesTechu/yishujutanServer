package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {

    List<Comment> getCommentsByEssayId(String essay_id);

    void insertComment(Comment comment);

}
