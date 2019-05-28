package com.studio.yishujutan.service;

import com.studio.yishujutan.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookInformation();   //获取书名

    List<Book> getSearchBook(String news);  //查询书籍
}
