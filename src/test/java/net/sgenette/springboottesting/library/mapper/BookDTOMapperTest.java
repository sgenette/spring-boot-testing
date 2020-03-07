package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.web.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static net.sgenette.springboottesting.library.model.data.BookData.CLEAN_CODE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookDTOMapperTest {

    @Autowired
    private BookDTOMapper mapper;

    @Test
    public void book_shouldMapToBookDTO() {
        BookDTO actualBookDTO = mapper.bookToBookDTO(CLEAN_CODE);

        assertThat(actualBookDTO).isNotNull();
        assertThat(actualBookDTO.getIsbn()).isEqualTo("9781861978769");
        assertThat(actualBookDTO.getTitle()).isEqualTo("Clean code");
        assertThat(actualBookDTO.getAuthor().getFirstName()).isEqualTo("Robert");
        assertThat(actualBookDTO.getAuthor().getLastName()).isEqualTo("Martin");
    }

    @Test
    public void nullBook_shouldMapToNullBookDTO() {
        BookDTO actualBookDTO = mapper.bookToBookDTO(null);

        assertThat(actualBookDTO).isNull();
    }
}
