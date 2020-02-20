package net.sgenette.springboottesting.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class Book {

    @NonNull private final Isbn13 isbn13;
    @NonNull private final String title;
    @NonNull private final Author author;
}
