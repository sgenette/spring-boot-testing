package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.web.dto.BookDTO;
import org.junit.jupiter.api.Test;

import static net.sgenette.springboottesting.library.model.data.BookData.CLEAN_CODE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookDTOMapperTest {

    private BookDTOMapper mapper;

    public BookDTOMapperTest() {
        this.mapper = new BookDTOMapperImpl(new NameMapper(), new Isbn13Mapper());
    }

    @Test
    public void book_shouldMapToBookDTO() {
        BookDTO actualBookDTO = mapper.bookToBookDTO(CLEAN_CODE);

        assertAll(
                () -> assertThat(actualBookDTO).isNotNull(),
                () -> assertThat(actualBookDTO.getIsbn()).isEqualTo("9781861978769"),
                () -> assertThat(actualBookDTO.getTitle()).isEqualTo("Clean code"),
                () -> assertThat(actualBookDTO.getAuthor()).isNotNull(),
                () -> assertThat(actualBookDTO.getAuthor().getFirstName()).isEqualTo("Robert"),
                () -> assertThat(actualBookDTO.getAuthor().getLastName()).isEqualTo("Martin"));
    }

    @Test
    public void nullBook_shouldMapToNullBookDTO() {
        BookDTO actualBookDTO = mapper.bookToBookDTO(null);

        assertThat(actualBookDTO).isNull();
    }
}
