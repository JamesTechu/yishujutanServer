package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.PictureDao;
import com.studio.yishujutan.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImp implements PictureService {

    @Autowired
    PictureDao pictureDao;

    @Override
    public String getUserIconUrl(String user_id) {
        return pictureDao.getUserIconUrl(user_id);
    }
}
