package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Praise;

public interface PraiseService {

    Praise isPraised(String user_id, String essay_id);

    void doPraise(Praise praise);

    void cancelPraise(Praise praise);
}
