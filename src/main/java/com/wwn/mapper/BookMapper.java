package com.wwn.mapper;

import com.wwn.pojo.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author wwn
 * @creat 2022-03-07-14:52
 */
public interface BookMapper {
    //增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("id") Integer id);

    //更新一本书
    int updateBook(Books books);

    //查询一本书
    Books queryBookById(@Param("id") Integer id);

    //查询所有书
    List<Books> queryAllBooks();

    //查询一本书
    Books queryBookByName(@Param("bookName") String bookname);
}
