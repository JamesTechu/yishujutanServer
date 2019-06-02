package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.DislikeDao;
import com.studio.yishujutan.entity.Dislike;
import com.studio.yishujutan.service.DislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DislikeServiceImp implements DislikeService {

    @Autowired
    DislikeDao dislikeDao;
    @Override
    public Dislike isDisliked(String user_id, String essay_id) {
        return dislikeDao.isDisliked(user_id, essay_id);
    }

    @Override
    public void doDislike(Dislike dislike) {
        dislikeDao.doDislike(dislike);
    }

    @Override
    public void cancelDislike(Dislike dislike) {
        dislikeDao.cancelDislike(dislike);
    }
}
