package net.sgenette.springboottesting.library.db.data;

import net.sgenette.springboottesting.library.db.AuthorEntity;
import net.sgenette.springboottesting.library.db.BookEntity;

public final class BookEntityData {

    public static final BookEntity CLEAN_CODE = BookEntity.builder()
            .id(1L)
            .isbn(9781861978769L)
            .title("Clean code")
            .author(
                    AuthorEntity.builder()
                            .id(1L)
                            .firstName("Robert")
                            .lastName("Martin")
                            .build())
            .build();
}
