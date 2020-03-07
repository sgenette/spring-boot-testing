package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.web.dto.BookDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = {NameMapper.class, Isbn13Mapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookDTOMapper {

    @Mapping(target = "isbn", source = "isbn13")
    BookDTO bookToBookDTO(Book book);
}
