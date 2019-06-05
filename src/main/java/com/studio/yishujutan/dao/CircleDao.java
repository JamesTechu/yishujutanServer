package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Circle;
import com.studio.yishujutan.entity.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CircleDao {

    List<Circle> getCirclesIconAndName(@Param(value = "ids") String[] circle_id);

    //获取单个圈子详细信息的方法
    Circle getCircleInfo(String circle_id);

    //用户申请创建新圈子
    void applyCircle(Circle circle);

    //获取最大圈子id
    int getMaxCircleId();

    //模糊查询帖子
    List<Circle> getCirclesFuzzily(@Param("key") String key);
}

