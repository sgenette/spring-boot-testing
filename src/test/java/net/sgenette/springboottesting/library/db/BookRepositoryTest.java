package net.sgenette.springboottesting.library.db;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findBookById() {
        Author author = Author.builder().id(1L).firstName("Robert").lastName("Martin").build();
        Book book = Book.builder().id(1L).isbn(9780132350884L).title("Clean Code").author(author).build();

        Optional<Book> actualBook = bookRepository.findById(1L);

        assertThat(actualBook).isPresent().hasValue(book);
    }

}
