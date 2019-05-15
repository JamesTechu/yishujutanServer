package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EssayDao {

    void insertIntoEssay(Essay essay);

    List<Essay> selectEssaysByHotDegree(int number);

    List<Essay> selectEssaysByFollows(@Param("number")int number, @Param("user_id")String user_id);

    Essay selectLastEssayById(String user_id);

}
