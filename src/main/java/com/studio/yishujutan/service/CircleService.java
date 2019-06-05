package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Circle;

import java.util.List;

public interface CircleService {

    List<Circle> getCirclesIconAndName(String[] circle_id);

    Circle getCircleInfo(String circle_id);

    void applyCircle(Circle circle);

    int getMaxCircleId();


    //模糊查询帖子
    List<Circle> getCirclesFuzzily(String key);

}
