package com.studio.yishujutan.service;


import com.github.pagehelper.PageInfo;
import com.studio.yishujutan.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBookInformation();   //获取书名
    List<Book> getAllBookInformation();  //获取书籍和笔记
    List<Book> getSearchBook(String news);  //查询书籍
    List<Book> getBookContent(String book_id);  //通过书名查询书籍
    List<Book> getNoteInformation(); //获取笔记
    List<Book> findAll();
    List<Book> getAllnotebook();


}
