package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.web.dto.AuthorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.sgenette.springboottesting.library.model.data.AuthorData.MARTIN_FOWLER;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthorDTOMapperTest {

    @Autowired
    AuthorDTOMapper mapper;

    @Test
    public void author_shouldMapToAuthorDTO() {
        AuthorDTO actualAuthorDTO = mapper.authorToAuthorDTO(MARTIN_FOWLER);

        assertThat(actualAuthorDTO).isNotNull();
        assertThat(actualAuthorDTO.getFirstName()).isEqualTo("Martin");
        assertThat(actualAuthorDTO.getLastName()).isEqualTo("Fowler");
    }

    @Test
    public void nullAuthor_shouldMapToNullAuthorDTO() {
        AuthorDTO actualAuthorDTO = mapper.authorToAuthorDTO(null);

        assertThat(actualAuthorDTO).isNull();
    }
}
