package net.sgenette.springboottesting.library.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthorTest {

    @Test
    public void newAuthorIsValid() {
        String firstName = "Robert";
        String lastName = "Martin";

        Author actualAuthor = new Author(firstName, lastName);

        assertAll(
                () -> assertThat(actualAuthor).isNotNull(),
                () -> assertThat(actualAuthor.getFirstName()).isEqualTo(firstName),
                () -> assertThat(actualAuthor.getLastName()).isEqualTo(lastName));
    }

    @Test
    public void sameAuthorIsValid() {
        String firstName = "Kent";
        String lastName = "Beck";

        Author actualAuthor = new Author(firstName, lastName);
        Author sameActualAuthor = new Author(firstName, lastName);

        assertAll(
                () -> assertThat(actualAuthor).isNotNull(),
                () -> assertThat(sameActualAuthor).isNotNull(),
                () -> assertThat(actualAuthor).isEqualTo(sameActualAuthor));
    }

}
