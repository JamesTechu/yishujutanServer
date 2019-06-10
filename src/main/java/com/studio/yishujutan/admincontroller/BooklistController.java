package com.studio.yishujutan.admincontroller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class BooklistController {
    @Autowired
    private BookService bookService;
    @GetMapping("/booklist")
    public ModelAndView booklist(@RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                                 Map<String,Object> map){
        PageHelper.startPage(currentPage,pageSize);
        List<Book> bookList=bookService.findAll();
        PageInfo<Book> pageInfo=new PageInfo<>(bookList);
        map.put("booklist",pageInfo);
        map.put("currentPage",currentPage);
        return new ModelAndView("booklist");
    }

}
