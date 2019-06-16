package com.studio.yishujutan.admincontroller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.entity.Essay;
import com.studio.yishujutan.service.EssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@RestController
public class EssayController {
        @Autowired
        private EssayService essayService;
        @GetMapping("/essaylist")
        public ModelAndView getEssay(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                         @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                         Map<String,Object> map){
            PageHelper.startPage(currentPage,pageSize);
            List<Essay> essayList=essayService.getAllessay();
            PageInfo<Essay> pageInfo=new PageInfo<>(essayList);
            map.put("essayList",pageInfo);
            map.put("currentPage",currentPage);
            return new ModelAndView("essay/essay");
        }

}
