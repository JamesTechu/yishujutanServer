package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.CircleDao;
import com.studio.yishujutan.entity.Circle;
import com.studio.yishujutan.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleServiceImp implements CircleService {

    @Autowired
    CircleDao circleDao;


    @Override
    public List<Circle> getCirclesIconAndName(String[] circle_id) {
        return circleDao.getCirclesIconAndName(circle_id);
    }

    @Override
    public Circle getCircleInfo(String circle_id) {
        return circleDao.getCircleInfo(circle_id);
    }

    @Override
    public void applyCircle(Circle circle) {
        circleDao.applyCircle(circle);
    }

    @Override
    public int getMaxCircleId() {
        return circleDao.getMaxCircleId();
    }

    @Override
    public List<Circle> getCirclesFuzzily(String key) {
        return circleDao.getCirclesFuzzily(key);
    }
}
