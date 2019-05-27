package com.studio.yishujutan.controller.community;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/*
 获取首页书籍信息
 网址 /bookinformation
 */
@RestController
public class GetBookInformation {

    @Autowired
    BookService bookService;

    private JSONArray jsonArray;


    @GetMapping("/bookinformation")

    public String GetBookInformation(HttpServletRequest request) {
        JSONObject result;
        jsonArray =new JSONArray();
        List<Book> books=null;
        books=bookService.getBookInformation();
        int realNumber = books.size();
        Book book;

        for (int i = 0; i < realNumber; i++) {
           book= books.get(i);
           result=new JSONObject();
           result.put("book_name",book.getBook_name());
           jsonArray.add(result);
        }
        System.out.println(books);
        return jsonArray.toString();
    }


}

//    public String GetBookInformation(HttpServletRequest request){
//        //String book_name=request.getParameter("book_name");
//        String book_name="shuai";
//        return "hello SpringBoot";
//    }



//public String  {
//    @GetMapping(value="/bookinformation")
//    public String hello() {
//        List<Book> book = new ArrayList<>();
//        int news = book.size();
//        for (int i = 0; i < news; i++) {
//            book.add( );
//
//
//        }
//    }
//    }
