package com.studio.yishujutan.controller.home;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.home.JsonTool.Bookjson;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
@RestController
public class GetSearchBook {
    @Autowired
    BookService bookService;

    private JSONArray jsonArray;
    private  Bookjson bookjson;

    @GetMapping("/getsearchbook")
    public String GetSearchbook(String news){
        JSONObject result;
        jsonArray =new JSONArray();
        List<Book> books=null;
        bookjson=new Bookjson();
        books=bookService.getSearchBook(news);
        Book book;
        int realNumber = books.size();
        System.out.println(news);
        System.out.println(books);
        for (int i = 0; i < realNumber; i++) {
            book=books.get(i);
            result=bookjson.bookjson(book);  //引用Bookjson 数据转json格式
//            result=new JSONObject();
//            result.put("book_name",book.getBook_name());
//            result.put("book_id",book.getBook_id());
//            result.put("book_picture", Address.LOCAL_ADDRESS+book.getBook_picture());
//            result.put("book_price",book.getBook_price());
//            result.put("book_category",book.getBook_category());
//            result.put("book_press",book.getBook_press());
//            result.put("issue_date",book.getIssue_date());
            jsonArray.add(result);
        }
        return jsonArray.toString();

    }


}
