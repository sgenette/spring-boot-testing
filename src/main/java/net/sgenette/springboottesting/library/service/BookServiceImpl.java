package net.sgenette.springboottesting.library.service;

import net.sgenette.springboottesting.library.core.Book;
import net.sgenette.springboottesting.library.core.Isbn13;
import net.sgenette.springboottesting.library.db.BookEntity;
import net.sgenette.springboottesting.library.db.BookRepository;
import net.sgenette.springboottesting.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Optional<Book> getBook(Isbn13 isbn13) {
        if (isbn13 == null) {throw new IllegalArgumentException();}

        Long isbn = Long.valueOf(isbn13.getIsbn13());
        Optional<BookEntity> maybeBookEntity = this.bookRepository.findBookByIsbn(isbn);
        return maybeBookEntity.map(bookEntity -> bookMapper.bookEntityToBook(bookEntity));
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterableBookEntity = this.bookRepository.findAll();

        List<Book> books = new ArrayList<>();
        iterableBookEntity.forEach(bookEntity -> books.add(bookMapper.bookEntityToBook(bookEntity)));

        return books;
    }

    @Override
    public Book saveBook(Book book) {
        if (book == null) {throw new IllegalArgumentException();}

        BookEntity bookEntity = bookMapper.bookToBookEntity(book);
        BookEntity savedBookEntity = bookRepository.save(bookEntity);
        return bookMapper.bookEntityToBook(savedBookEntity);
    }
}
