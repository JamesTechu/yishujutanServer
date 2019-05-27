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

    @Override
    public List<Essay> selectEssaysByFollows(int number, String user_id) {
        return essayDao.selectEssaysByFollows(number, user_id);
    }

    @Override
    public Essay selectLastEssayById(String user_id) {
        return essayDao.selectLastEssayById(user_id);
    }

    @Override
    public List<Essay> selectEssaysById(int number, String user_id) {
        return essayDao.selectEssaysById(number, user_id);
    }

    @Override
    public List<Essay> selectEssaysByCircleId(String circle_id, int number1, int number2) {
        return essayDao.selectEssaysByCircleId(circle_id, number1, number2);
    }

    @Override
    public void addPraiseNumber(String essay_id) {
        essayDao.addPraiseNumber(essay_id);
    }

    @Override
    public void reducePraiseNumber(String essay_id) {
        essayDao.reducePraiseNumber(essay_id);
    }


}
