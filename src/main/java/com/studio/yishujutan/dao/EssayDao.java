package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EssayDao {

    void insertIntoEssay(Essay essay);

    List<Essay> selectEssaysByHotDegree(int number);

    //点赞
    void addPraiseNumber(String essay_id);

    //取消点赞
    void reducePraiseNumber(String essay_id);

    List<Essay> selectEssaysByFollows(@Param("number")int number, @Param("user_id")String user_id);

    Essay selectLastEssayById(String user_id);

    List<Essay> selectEssaysById(@Param("number")int number, @Param("user_id")String user_id);

    //根据circle_id获取贴子
    List<Essay> selectEssaysByCircleId(@Param("circle_id")String circle_id, @Param("number1")int number1, @Param("number2")int number2);
}
