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

    private String Adress="http://127.0.0.1:8080/";

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
        //PageHelper.startPage(currentPage, pageSize);
        List<Book> bookList=bookDao.getAllbook();
//        JSONArray jsonArray = new JSONArray();
//        Book book;
//        JSONObject jsonObject;
//        for (int i = 0; i < bookList.size(); i++) {
//            jsonObject = new JSONObject();
//            book = bookList.get(i);
//            jsonObject.put("book_id", book.getBook_id());
//            jsonObject.put("book_name", book.getBook_name());
//            jsonObject.put("issue_date", book.getIssue_date());
//            jsonObject.put("book_picture", Adress + book.getBook_picture());
//            jsonObject.put("user_id", book.getUser_id());
//            jsonArray.add(jsonObject);
//        }
//        List<Book> bookList1=jsonArray.toJavaList(Book.class);

        return bookList;
    }


}
