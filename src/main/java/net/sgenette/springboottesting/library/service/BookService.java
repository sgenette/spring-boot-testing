package net.sgenette.springboottesting.library.service;

import net.sgenette.springboottesting.library.core.Book;
import net.sgenette.springboottesting.library.core.Isbn13;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBook(Isbn13 isbn13);

    List<Book> getAllBooks();

    Book saveBook(Book book);
}
