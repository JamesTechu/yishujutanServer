package com.studio.yishujutan.serviceImp;

import com.studio.yishujutan.dao.BookDao;
import com.studio.yishujutan.entity.Book;
import com.studio.yishujutan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> getBookInformation(){
        return bookDao.getBookInformation();
    }

    @Override
    public List<Book> getSearchBook(String news){
        return bookDao.getSearchBook(news);
    }


}
