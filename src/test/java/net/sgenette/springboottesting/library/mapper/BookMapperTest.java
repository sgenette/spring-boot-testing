package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.db.BookEntity;
import net.sgenette.springboottesting.library.db.data.BookEntityData;
import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.model.data.BookData;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BookMapperTest {

    private BookMapper mapper;

    public BookMapperTest() {
        this.mapper = new BookMapperImpl(new NameMapper(), new Isbn13Mapper());
    }

    @Test
    public void book_shouldMapToBookEntity() {
        BookEntity actualBookEntity = mapper.bookToBookEntity(BookData.CLEAN_CODE);

        assertAll(
                () -> assertThat(actualBookEntity.getIsbn().toString()).isEqualTo("9781861978769"),
                () -> assertThat(actualBookEntity.getTitle()).isEqualTo("Clean code"),
                () -> assertThat(actualBookEntity.getAuthor().getFirstName()).isEqualTo("Robert"),
                () -> assertThat(actualBookEntity.getAuthor().getLastName()).isEqualTo("Martin"));
    }

    @Test
    public void nullBook_shouldMapToNullBookEntity() {
        BookEntity actualBookEntity = mapper.bookToBookEntity(null);

        assertThat(actualBookEntity).isNull();
    }

    @Test
    public void bookEntity_shouldMapToBook() {
        Book actualBook = mapper.bookEntityToBook(BookEntityData.CLEAN_CODE);

        assertAll(
                () -> assertThat(actualBook.getIsbn13().getIsbn13()).isEqualTo("9781861978769"),
                () -> assertThat(actualBook.getTitle()).isEqualTo("Clean code"),
                () -> assertThat(actualBook.getAuthor().getFirstName().getName()).isEqualTo("Robert"),
                () -> assertThat(actualBook.getAuthor().getLastName().getName()).isEqualTo("Martin"));
    }

    @Test
    public void nullBookEntity_shouldMapToNullBook() {
        Book actualBook = mapper.bookEntityToBook(null);

        assertThat(actualBook).isNull();
    }
}
