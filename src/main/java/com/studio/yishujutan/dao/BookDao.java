package com.studio.yishujutan.dao;

import com.studio.yishujutan.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Pageable;
import java.util.List;

@Mapper
public interface BookDao {
    List<Book> getBookInformation();   //首页随机获取书的信息
    List<Book> getAllBookInformation();   //首页随机获取书的信息
    List<Book> getSearchBook(@Param("news") String news);   //查找书籍
    List<Book> getBookContent(String book_id);    //通过书籍名称获取书籍
    List<Book> getNoteInformation();  //获取笔记的信息
    List<Book> getAllbook();
    List<Book> getAllnotebook();
}
