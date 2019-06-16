package com.studio.yishujutan.serviceImp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.studio.yishujutan.dao.BookDao;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Resource
    BookDao bookDao;


    @Override
    public List<Book> getBookInformation(){
        return bookDao.getBookInformation();
    }

    @Override
    public List<Book> getSearchBook(String news){
        return bookDao.getSearchBook(news);
    }
    @Override
    public List<Book>getBookContent(String book_id){
        return bookDao.getBookContent(book_id);
    }
    @Override
    public List<Book> getAllBookInformation() {
        return bookDao.getAllBookInformation();
    }
    @Override
    public List<Book> getNoteInformation(){
        return  bookDao.getNoteInformation();
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList=bookDao.getAllbook();
        return bookList;
    }

    @Override
    public List<Book> getAllnotebook() {
        return bookDao.getAllnotebook();
    }


}
