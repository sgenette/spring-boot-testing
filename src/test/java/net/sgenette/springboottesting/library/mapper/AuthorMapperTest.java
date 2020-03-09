package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.core.model.Name;
import net.sgenette.springboottesting.library.db.entity.AuthorEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthorMapperTest {

    private AuthorMapper mapper;

    public AuthorMapperTest() {
        mapper = new AuthorMapperImpl(new NameMapper());
    }

    @Test
    public void author_shouldMapToAuthorEntity() {
        Author author = Author.builder().
                firstName(new Name("Robert")).
                lastName(new Name("Martin")).
                build();

        AuthorEntity actualAuthorEntity = mapper.authorToAuthorEntity(author);

        assertAll(
                () -> assertThat(actualAuthorEntity.getFirstName()).isEqualTo("Robert"),
                () -> assertThat(actualAuthorEntity.getLastName()).isEqualTo("Martin")
        );

    }

    @Test
    public void nullAuthor_shouldMapToNullAuthorEntity() {
        Author author = null;

        AuthorEntity actualAuthorEntity = mapper.authorToAuthorEntity(author);

        assertThat(actualAuthorEntity).isNull();
    }

    @Test
    public void authorEntity_shouldMapToAuthor() {
        AuthorEntity authorEntity = AuthorEntity.builder().
                id(1L).
                firstName("Robert").
                lastName("Martin").
                build();

        Author author = mapper.authorEntityToAuthor(authorEntity);

        assertAll(
                () -> assertThat(author.getFirstName().getName()).isEqualTo("Robert"),
                () -> assertThat(author.getLastName().getName()).isEqualTo("Martin")
        );
    }

    @Test
    public void nullAuthorEntity_shouldMapToNullAuthor() {
        AuthorEntity authorEntity = null;

        Author author = mapper.authorEntityToAuthor(authorEntity);

        assertThat(author).isNull();
    }

}
