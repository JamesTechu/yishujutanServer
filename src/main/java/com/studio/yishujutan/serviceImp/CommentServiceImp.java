package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.CommentDao;
import com.studio.yishujutan.entity.Comment;
import com.studio.yishujutan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public List<Comment> getCommentsByEssayId(String essay_id) {
        return commentDao.getCommentsByEssayId(essay_id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }
}
