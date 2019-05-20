package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.BrowseDao;
import com.studio.yishujutan.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseServiceImp implements BrowseService {

    @Autowired
    BrowseDao browseDao;


    @Override
    public String[] getCircleIds(String user_id, int number) {
        return browseDao.getCircleIds(user_id, number);
    }
}
