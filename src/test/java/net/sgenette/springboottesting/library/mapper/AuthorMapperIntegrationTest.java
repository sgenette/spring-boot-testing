package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.Author;
import net.sgenette.springboottesting.library.core.Name;
import net.sgenette.springboottesting.library.db.AuthorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest()
public class AuthorMapperIntegrationTest {

    private AuthorMapper mapper;

    @Autowired
    public AuthorMapperIntegrationTest(AuthorMapper mapper) {
        this.mapper = mapper;
    }

    @Test
    public void author_shouldMapToAuthorEntity() {
        Author author = Author.builder().firstName(new Name("Robert")).lastName(new Name("Martin")).build();

        AuthorEntity actualAuthorEntity = mapper.authorToAuthorEntity(author);

        assertAll(
            () -> assertThat(actualAuthorEntity.getFirstName()).isEqualTo("Robert"),
            () -> assertThat(actualAuthorEntity.getLastName()).isEqualTo("Martin")
        );

    }

    @Test
    public void authorEntity_shouldMapToAuthor() {
        AuthorEntity authorEntity = AuthorEntity.builder().id(1L).firstName("Robert").lastName("Martin").build();

        Author author = mapper.authorEntityToAuthor(authorEntity);

        assertAll(
            () -> assertThat(author.getFirstName().getName()).isEqualTo("Robert"),
            () -> assertThat(author.getLastName().getName()).isEqualTo("Martin")
        );
    }
}
