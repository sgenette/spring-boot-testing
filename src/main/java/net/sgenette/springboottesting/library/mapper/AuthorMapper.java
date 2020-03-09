package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.db.entity.AuthorEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = NameMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AuthorMapper {

    @Mapping(target = "id", ignore = true)
    AuthorEntity authorToAuthorEntity(Author author);

    @InheritInverseConfiguration
    Author authorEntityToAuthor(AuthorEntity authorEntity);
}
