package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.model.Author;
import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.model.Isbn13;
import net.sgenette.springboottesting.library.model.Name;
import net.sgenette.springboottesting.library.db.AuthorEntity;
import net.sgenette.springboottesting.library.db.BookEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class BookMapperIntegrationTest {

    @Autowired
    private BookMapper mapper;

    @Test
    public void book_shouldMapToBookEntity() {
        Book book = Book.builder().
                isbn13(new Isbn13("978 1 86197 876 9")).
                title("Clean code").
                author(Author.builder().
                        firstName(new Name("Robert")).
                        lastName(new Name("Martin")).
                        build()).
                build();

        BookEntity actualBookEntity = mapper.bookToBookEntity(book);

        assertAll(
                () -> assertThat(actualBookEntity).isNotNull(),
                () -> assertThat(actualBookEntity.getIsbn().toString()).
                        isEqualTo(book.getIsbn13().getIsbn13()),
                () -> assertThat(actualBookEntity.getTitle()).
                        isEqualTo(book.getTitle()),
                () -> assertThat(actualBookEntity.getAuthor().getFirstName()).
                        isEqualTo(book.getAuthor().getFirstName().getName()),
                () -> assertThat(actualBookEntity.getAuthor().getLastName()).
                        isEqualTo(book.getAuthor().getLastName().getName())
        );
    }

    @Test
    public void bookEntity_shouldMapToBook() {
        BookEntity bookEntity = BookEntity.builder().
                id(1L).
                isbn(9781861978769L).
                title("Clean code").
                author(AuthorEntity.builder().
                        id(1L).
                        firstName("Robert").
                        lastName("Martin").
                        build()).
                build();

        Book actualBook = mapper.bookEntityToBook(bookEntity);

        assertAll(
                () -> assertThat(actualBook).isNotNull(),
                () -> assertThat(actualBook.getIsbn13().getIsbn13()).
                        isEqualTo(bookEntity.getIsbn().toString()),
                () -> assertThat(actualBook.getTitle()).
                        isEqualTo(bookEntity.getTitle()),
                () -> assertThat(actualBook.getAuthor().getFirstName().getName()).
                        isEqualTo(bookEntity.getAuthor().getFirstName()),
                () -> assertThat(actualBook.getAuthor().getLastName().getName()).
                        isEqualTo(bookEntity.getAuthor().getLastName())
        );
    }

}
