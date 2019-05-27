package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.PraiseDao;
import com.studio.yishujutan.entity.Praise;
import com.studio.yishujutan.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PraiseServiceImp implements PraiseService {

    @Autowired
    PraiseDao praiseDao;

    @Override
    public Praise isPraised(String user_id, String essay_id) {
        return praiseDao.isPraised(user_id, essay_id);
    }

    @Override
    public void doPraise(Praise praise) {
        praiseDao.doPraise(praise);
    }

    @Override
    public void cancelPraise(Praise praise) {
        praiseDao.cancelPraise(praise);
    }
}
