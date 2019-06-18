package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByEssayId(String essay_id);

    void insertComment(Comment comment);
}
