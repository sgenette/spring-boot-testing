package net.sgenette.springboottesting.library.core.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.validator.routines.ISBNValidator;

import java.util.Optional;

@EqualsAndHashCode
public final class Isbn13 {

    @Getter
    private final String isbn13;

    private static final Boolean CONVERT_TO_ISBN13 = Boolean.TRUE;

    public Isbn13(String isbn) {
        String validatedIsbn = ISBNValidator.getInstance(CONVERT_TO_ISBN13).validate(isbn);
        this.isbn13 = Optional.ofNullable(validatedIsbn).orElseThrow(
                () -> new IllegalArgumentException("Invalid ISBN")
        );
    }

}
