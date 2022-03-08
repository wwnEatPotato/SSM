package com.wwn.controller;

import com.wwn.pojo.Books;
import com.wwn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wwn
 * @creat 2022-03-07-16:01
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BoolServiceImpl")
    private BookService bookService;


    //查询全部的书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("books", books);
        return "allBook";
    }


    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping(value = "/toUpdateBook/{id}")
    public String toUpdateBook(@PathVariable("id") Integer id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("book", books);
        return "updateBook";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Books book) {
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping(value = "/queryBook", method = RequestMethod.POST)
    public String queryBook( String queryBookName,Model model){
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        model.addAttribute("books", list);
        return "allBook";
    }
}
