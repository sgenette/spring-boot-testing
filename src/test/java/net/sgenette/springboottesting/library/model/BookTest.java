package net.sgenette.springboottesting.library.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookTest {

    @Test
    public void newBookIsValid() {
        Isbn13 isbn13 = new Isbn13("978 1 86197 876 9");
        String title = "Clean code";
        Author author = Author.builder().firstName(new Name("Robert")).lastName(new Name("Martin")).build();

        Book actualBook = new Book(isbn13, title, author);

        assertAll(
                () -> assertThat(actualBook).isNotNull(),
                () -> assertThat(actualBook.getIsbn13()).isEqualTo(isbn13),
                () -> assertThat(actualBook.getTitle()).isEqualTo(title),
                () -> assertThat(actualBook.getAuthor()).isEqualTo(author));
    }

}
