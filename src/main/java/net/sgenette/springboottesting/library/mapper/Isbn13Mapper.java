package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.model.Isbn13;
import org.springframework.stereotype.Component;

@Component
public class Isbn13Mapper {

    public String isbn133ToString(Isbn13 isbn13) {
        return isbn13.getIsbn13();
    }

    public Isbn13 stringToIsbn13(String isbn) {
        return new Isbn13(isbn);
    }

}
