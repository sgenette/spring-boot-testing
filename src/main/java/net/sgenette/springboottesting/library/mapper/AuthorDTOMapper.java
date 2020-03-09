package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.web.dto.AuthorDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = NameMapper.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AuthorDTOMapper {

    AuthorDTO authorToAuthorDTO(Author author);
}
