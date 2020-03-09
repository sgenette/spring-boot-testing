package net.sgenette.springboottesting.library.core.model.data;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.core.model.Book;
import net.sgenette.springboottesting.library.core.model.Isbn13;
import net.sgenette.springboottesting.library.core.model.Name;

public final class BookData {

    public static final Book CLEAN_CODE = Book.builder()
            .isbn13(new Isbn13("978 1 86197 876 9"))
            .title("Clean code")
            .author(Author.builder()
                    .firstName(new Name("Robert"))
                    .lastName(new Name("Martin"))
                    .build())
            .build();

}
