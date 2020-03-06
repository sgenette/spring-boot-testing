package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.db.BookEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {NameMapper.class, Isbn13Mapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isbn", source = "isbn13")
    BookEntity bookToBookEntity(Book book);

    @InheritInverseConfiguration
    Book bookEntityToBook(BookEntity bookEntity);
}
