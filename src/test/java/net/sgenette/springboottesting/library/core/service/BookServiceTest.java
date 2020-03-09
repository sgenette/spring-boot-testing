package net.sgenette.springboottesting.library.core.service;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.core.model.Book;
import net.sgenette.springboottesting.library.core.model.Isbn13;
import net.sgenette.springboottesting.library.core.model.Name;
import net.sgenette.springboottesting.library.db.entity.AuthorEntity;
import net.sgenette.springboottesting.library.db.entity.BookEntity;
import net.sgenette.springboottesting.library.db.repository.BookRepository;
import net.sgenette.springboottesting.library.mapper.BookMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock private BookRepository bookRepository;

    @Mock private BookMapper bookMapper;

    private BookService bookService;

    @BeforeEach
    public void initTest() {
        bookService = new BookServiceImpl(bookRepository, bookMapper);
        }

    @Test
    public void isbn_shouldReturnBook() {
        Isbn13 isbn13 = new Isbn13("978-1-56619-909-4");

        BookEntity bookEntity = BookEntity.builder().
                id(1L).isbn(9781861978769L).title("Some title").author(
                AuthorEntity.builder().id(1L).firstName("John").lastName("D").build()).
                build();

        Book book = Book.builder().
                isbn13(new Isbn13("978-1-56619-909-4")).
                title("Some title").
                author(Author.builder().
                        firstName(new Name("John")).
                        lastName(new Name("D")).
                        build()).
                build();

        when(bookRepository.findBookByIsbn(anyLong())).thenReturn(Optional.of(bookEntity));
        when(bookMapper.bookEntityToBook(any(BookEntity.class))).thenReturn(book);

        Optional<Book> actualBook = bookService.getBook(isbn13);

        assertThat(actualBook).isNotEmpty();
        assertThat(actualBook.get()).isEqualTo(book);
    }

    @Test
    public void nullIsbn13_shouldThrowException() {
        Isbn13 isbn13 = null;

        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> bookService.getBook(isbn13)
        );
    }

    @Test
    public void allBooks() {
        List<BookEntity> bookEntities = new ArrayList<>();
        bookEntities.add(BookEntity.builder().
                id(1L).isbn(9781861978769L).title("Some title").author(
                AuthorEntity.builder().id(1L).firstName("John").lastName("D").build()).
                build());

        when(bookRepository.findAll()).thenReturn(bookEntities);

        assertThat(bookService.getAllBooks()).hasSize(1);
    }

    @Test
    public void book_shouldReturnBook() {
        BookEntity bookEntity = BookEntity.builder().
                id(1L).isbn(9781861978769L).title("Some title").author(
                AuthorEntity.builder().id(1L).firstName("John").lastName("D").build()).
                build();

        Book book = Book.builder().
                isbn13(new Isbn13("978 1 86197 876 9")).
                title("Clean code").
                author(Author.builder().
                        firstName(new Name("Robert")).
                        lastName(new Name("Martin")).
                        build()).
                build();

        when(bookRepository.save(Mockito.any(BookEntity.class))).thenReturn(bookEntity);
        when(bookMapper.bookEntityToBook(Mockito.any(BookEntity.class))).thenReturn(book);
        when(bookMapper.bookToBookEntity(Mockito.any(Book.class))).thenReturn(bookEntity);

        Book actualSavedBook = bookService.saveBook(book);

        assertThat(actualSavedBook).isNotNull();
        assertThat(actualSavedBook).isEqualTo(book);
    }

    @Test
    public void nullBook_shouldThrowException() {
        Book book = null;

        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> bookService.saveBook(book)
        );
    }

}
