package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Circle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CircleDao {

    List<Circle> getCirclesIconAndName(@Param(value = "ids") String[] circle_id);

    //获取单个圈子详细信息的方法
    Circle getCircleInfo(String circle_id);
}

