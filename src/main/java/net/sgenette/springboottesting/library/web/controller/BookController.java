package net.sgenette.springboottesting.library.web.controller;

import net.sgenette.springboottesting.library.mapper.BookDTOMapper;
import net.sgenette.springboottesting.library.core.service.BookService;
import net.sgenette.springboottesting.library.web.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private BookService bookService;
    private BookDTOMapper bookMapper;

    @Autowired
    public BookController(BookService bookService, BookDTOMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/books")
    public List<BookDTO> books() {
        return bookService.getAllBooks()
                .stream()
                .map(book -> bookMapper.bookToBookDTO(book))
                .collect(Collectors.toList());
    }
}
