package net.sgenette.springboottesting.library.db.repository;

import net.sgenette.springboottesting.library.db.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

    Optional<BookEntity> findBookByIsbn(Long isbn);
}
