package net.sgenette.springboottesting.library.core.service;

import net.sgenette.springboottesting.library.core.model.Book;
import net.sgenette.springboottesting.library.core.model.Isbn13;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBook(Isbn13 isbn13);

    List<Book> getAllBooks();

    Book saveBook(Book book);
}
