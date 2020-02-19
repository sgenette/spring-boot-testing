package net.sgenette.springboottesting.library.domain;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookTest {

    @Test
    public void newBookIsValid() {
        Long isbn = 9780132350884L;
        String title = "Clean code";
        Author author = new Author("Robert", "Martin");

        Book actualBook = new Book(isbn, title, author);

        assertAll(
                () -> assertThat(actualBook).isNotNull(),
                () -> assertThat(actualBook.getIsbn()).isEqualTo(isbn),
                () -> assertThat(actualBook.getTitle()).isEqualTo(title),
                () -> assertThat(actualBook.getAuthor()).isEqualTo(author));
    }

    @Test
    public void equalsHashCode() {
        EqualsVerifier.forClass(Book.class).verify();
    }

}
