package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Essay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EssayDao {

    //模糊查询帖子
    List<Essay> selectEssaysFuzzily(@Param("key") String key);

    //插入一条帖子
    void insertIntoEssay(Essay essay);

    //根据热度获取帖子
    List<Essay> selectEssaysByHotDegree(int number);

    //点赞
    void addPraiseNumber(String essay_id);

    //取消点赞
    void reducePraiseNumber(String essay_id);

    //根据Essay_id获取帖子
    Essay selectEssayByEssayId(String essay_id);

    //获取关注好友发布的帖子
    List<Essay> selectEssaysByFollows(@Param("number")int number, @Param("user_id")String user_id);

    //根据用户ID获取最近发布的一条帖子
    Essay selectLastEssayById(String user_id);

    //根据用户ID获取指定数量的帖子
    List<Essay> selectEssaysById(@Param("number")int number, @Param("user_id")String user_id);

    //根据circle_id获取贴子
    List<Essay> selectEssaysByCircleId(@Param("circle_id")String circle_id, @Param("number1")int number1, @Param("number2")int number2);

    //查询所有的帖子
    List<Essay> getAllessay();
}
