package com.wwn.service;

import com.wwn.pojo.Books;

import java.awt.print.Book;
import java.util.List;

/**
 * @author wwn
 * @creat 2022-03-07-15:16
 */
public interface BookService {

    //增加一本书
    int addBook( Books books);

    //删除一本书
    int deleteBookById( Integer id);

    //更新一本书
    int updateBook( Books books);

    //查询一本书
    Books queryBookById( Integer id);

    //查询所有书
    List<Books> queryAllBooks();

    Books queryBookByName(String bookName);
}
