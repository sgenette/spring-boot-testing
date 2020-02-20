package net.sgenette.springboottesting.library.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthorTest {

    @Test
    public void newAuthorIsValid() {
        Name firstName = new Name("Robert");
        Name lastName = new Name("Martin");

        Author actualAuthor = new Author(firstName, lastName);

        assertAll(
                () -> assertThat(actualAuthor).isNotNull(),
                () -> assertThat(actualAuthor.getFirstName()).isEqualTo(firstName),
                () -> assertThat(actualAuthor.getLastName()).isEqualTo(lastName));
    }



}
