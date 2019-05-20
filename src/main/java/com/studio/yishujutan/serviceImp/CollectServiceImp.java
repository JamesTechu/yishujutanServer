package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.CollectDao;
import com.studio.yishujutan.entity.Collect;
import com.studio.yishujutan.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectServiceImp implements CollectService {

    @Autowired
    CollectDao collectDao;


    @Override
    public String[] getCircleIds(String user_id) {
        return collectDao.getCircleIds(user_id);
    }
}
