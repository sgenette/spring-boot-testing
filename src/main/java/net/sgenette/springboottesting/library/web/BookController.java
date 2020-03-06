package net.sgenette.springboottesting.library.web;

import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> books() {
        return bookService.getAllBooks();
    }
}
