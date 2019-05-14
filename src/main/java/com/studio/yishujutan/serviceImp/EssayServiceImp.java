package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.EssayDao;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EssayServiceImp implements EssayService {

    @Autowired
    EssayDao essayDao;

    @Override
    public void insertIntoEssay(Essay essay) {
        essayDao.insertIntoEssay(essay);
    }

    @Override
    public List<Essay> selectEssaysByHotDegree(int number) {
        return essayDao.selectEssaysByHotDegree(number);
    }


}
