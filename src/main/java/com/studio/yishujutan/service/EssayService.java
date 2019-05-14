package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Essay;

import java.util.List;

public interface EssayService {

    void insertIntoEssay(Essay essay);

    List<Essay> selectEssaysByHotDegree(int number);
}
