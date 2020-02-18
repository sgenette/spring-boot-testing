package net.sgenette.springboottesting.library.db;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findBookById() {
        Book book = Book.builder().id(1L).isbn(9780132350884L).title("Clean Code").
                author(Author.builder().id(1L).firstName("Robert").lastName("Martin").build()).
                build();

        Optional<Book> actualBook = bookRepository.findById(1L);

        assertThat(actualBook).isPresent().hasValue(book);
    }

    @Test
    public void deleteBook() {
        Book book = Book.builder().id(1L).build();

        bookRepository.delete(book);

        assertAll(
                () -> assertThat(bookRepository.count()).isEqualTo(2L),
                () -> assertThat(bookRepository.findById(1L)).isEmpty()
        );
    }

    @Test
    public void addBook() {
        Book book = Book.builder().title("Accelerate").isbn(9781942788331L).
                author(Author.builder().firstName("Nicole").lastName("Forsgren").build()).
                build();

        bookRepository.save(book);
        Optional<Book> actualBook = bookRepository.findById(4L);

        assertAll(
                () -> assertThat(bookRepository.count()).isEqualTo(4L),
                () -> assertThat(actualBook).isPresent().hasValue(book)
        );
    }

}
