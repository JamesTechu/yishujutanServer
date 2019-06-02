package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Dislike;

public interface DislikeService {

    Dislike isDisliked(String user_id, String essay_id);

    void doDislike(Dislike dislike);

    void cancelDislike(Dislike dislike);
}
