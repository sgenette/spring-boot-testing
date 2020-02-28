package net.sgenette.springboottesting.library.service;

import net.sgenette.springboottesting.library.core.Author;
import net.sgenette.springboottesting.library.core.Book;
import net.sgenette.springboottesting.library.core.Isbn13;
import net.sgenette.springboottesting.library.core.Name;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SpringBootTest
@Transactional
public class BookServiceIntegrationTest {

    private BookService bookService;

    @Autowired
    public BookServiceIntegrationTest(BookService bookService) {
        this.bookService = bookService;
    }

    @Test
    public void isbnInDatabase_shouldReturnBook() {
        Isbn13 isbn13 = new Isbn13("9780134757599");

        Optional<Book> maybeActualBook = bookService.getBook(isbn13);

        assertThat(maybeActualBook).isPresent();
        assertThat(maybeActualBook.get().getIsbn13()).isEqualTo(isbn13);
    }

    @Test
    public void nullIsbn_shouldThrowException() {
        Isbn13 isbn13 = null;

        assertThatIllegalArgumentException().isThrownBy(
                () -> bookService.getBook(isbn13)
        );
    }

    @Test
    public void allBooks_shouldReturn3() {
        assertThat(bookService.getAllBooks()).hasSize(3);
    }

    @Test
    public void book_shouldReturnSavedBook() {
        Book book = Book.builder().
                isbn13(new Isbn13("978 1 86197 876 9")).
                title("Clean code").
                author(Author.builder().
                        firstName(new Name("Robert")).
                        lastName(new Name("Martin")).
                        build()).
                build();

        Book actualSavedBook = bookService.saveBook(book);

        assertThat(actualSavedBook).isNotNull();
        assertThat(actualSavedBook).isEqualTo(book);
    }

    @Test
    public void nullBook_shouldThrowException() {
        Book book = null;

        assertThatIllegalArgumentException().isThrownBy(
                () -> bookService.saveBook(book)
        );
    }

}
