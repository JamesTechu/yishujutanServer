package com.studio.yishujutan.controller.home.JsonTool;

import com.alibaba.fastjson.JSONObject;
import com.studio.yishujutan.controller.tool.Address;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.entity.Essay;
/*
  首页book的转换json方法
 */
public class Bookjson {
    private String address = Address.LOCAL_ADDRESS;

        public JSONObject bookjson(Book book) {
            JSONObject jsonObject = makeBookJson(book);

            return jsonObject;
        }

            public JSONObject makeBookJson(Book book){
                JSONObject result=new JSONObject();
                result.put("book_name",book.getBook_name());
                result.put("book_id",book.getBook_id());
                result.put("book_picture", Address.LOCAL_ADDRESS+book.getBook_picture());
                result.put("book_price",book.getBook_price());
                result.put("book_category",book.getBook_category());
                result.put("book_press",book.getBook_press());
                result.put("issue_date",book.getIssue_date());
                return result;
            }
}
