package net.sgenette.springboottesting.library.model.data;

import net.sgenette.springboottesting.library.model.Author;
import net.sgenette.springboottesting.library.model.Book;
import net.sgenette.springboottesting.library.model.Isbn13;
import net.sgenette.springboottesting.library.model.Name;

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
