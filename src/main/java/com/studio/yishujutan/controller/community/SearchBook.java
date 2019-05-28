package com.studio.yishujutan.controller.community;

import com.alibaba.fastjson.JSONArray;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchBook {
    @Autowired
    BookService bookService;

    private JSONArray jsonArray;


    @GetMapping("/searchbook")
    private String Searchbook(HttpServletRequest request){
        String showType = request.getParameter("showType");
        jsonArray =new JSONArray();
        List<Book> books=null;


        return jsonArray.toString();
    }
}
