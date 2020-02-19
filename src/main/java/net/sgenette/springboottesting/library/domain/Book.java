package net.sgenette.springboottesting.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class Book {

    @NonNull private final Long isbn;
    @NonNull private final String title;
    @NonNull private final Author author;
}
