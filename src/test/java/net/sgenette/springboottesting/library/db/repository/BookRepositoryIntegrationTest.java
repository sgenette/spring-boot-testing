package net.sgenette.springboottesting.library.db.repository;

import net.sgenette.springboottesting.library.db.entity.AuthorEntity;
import net.sgenette.springboottesting.library.db.entity.BookEntity;
import net.sgenette.springboottesting.library.db.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DataJpaTest
public class BookRepositoryIntegrationTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findBookById() {
        BookEntity book = BookEntity.builder().id(1L).isbn(9780132350884L).title("Clean Code").
                author(AuthorEntity.builder().id(1L).firstName("Robert").lastName("Martin").build()).
                build();

        Optional<BookEntity> actualBook = bookRepository.findById(1L);

        assertThat(actualBook).isPresent().hasValue(book);
    }

    @Test
    public void deleteBook() {
        BookEntity book = BookEntity.builder().id(1L).build();

        bookRepository.delete(book);

        assertAll(
                () -> assertThat(bookRepository.count()).isEqualTo(2L),
                () -> assertThat(bookRepository.findById(1L)).isEmpty()
        );
    }

    @Test
    public void addBook() {
        BookEntity book = BookEntity.builder().title("Accelerate").isbn(9781942788331L).
                author(AuthorEntity.builder().firstName("Nicole").lastName("Forsgren").build()).
                build();

        bookRepository.save(book);

        assertThat(bookRepository.count()).isEqualTo(4L);
    }

}
