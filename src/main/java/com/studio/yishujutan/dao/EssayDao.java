package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayDao {

    void insertIntoEssay(Essay essay);

    List<Essay> selectEssaysByHotDegree(int number);
}
