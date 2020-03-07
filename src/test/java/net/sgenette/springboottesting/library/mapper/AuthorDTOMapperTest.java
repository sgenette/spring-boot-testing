package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.web.dto.AuthorDTO;
import org.junit.jupiter.api.Test;

import static net.sgenette.springboottesting.library.model.data.AuthorData.MARTIN_FOWLER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class AuthorDTOMapperTest {

    private AuthorDTOMapper mapper;

    public AuthorDTOMapperTest() {
        this.mapper = new AuthorDTOMapperImpl(new NameMapper());
    }

    @Test
    public void author_shouldMapToAuthorDTO() {
        AuthorDTO actualAuthorDTO = mapper.authorToAuthorDTO(MARTIN_FOWLER);

        assertAll(
                () -> assertThat(actualAuthorDTO).isNotNull(),
                () -> assertThat(actualAuthorDTO.getFirstName()).isEqualTo("Martin"),
                () -> assertThat(actualAuthorDTO.getLastName()).isEqualTo("Fowler"));
    }

    @Test
    public void nullAuthor_shouldMapToNullAuthorDTO() {
        AuthorDTO actualAuthorDTO = mapper.authorToAuthorDTO(null);

        assertThat(actualAuthorDTO).isNull();
    }
}
