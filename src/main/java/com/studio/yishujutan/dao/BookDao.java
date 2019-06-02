package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    List<Book> getBookInformation();   //首页随机获取书的信息

    List<Book> getSearchBook(String news);   //查找书籍

}
