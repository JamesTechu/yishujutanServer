package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Essay;

import java.util.List;

public interface EssayService {

    void insertIntoEssay(Essay essay);

    List<Essay> selectEssaysByHotDegree(int number);

    List<Essay> selectEssaysByFollows(int number, String user_id);

    Essay selectLastEssayById(String user_id);

    List<Essay> selectEssaysById(int number, String user_id);

    List<Essay> selectEssaysByCircleId(String circle_id, int number, int numebr2);

    void addPraiseNumber(String essay_id);

    void reducePraiseNumber(String essay_id);

    Essay selectEssayByEssayId(String essay_id);
}
