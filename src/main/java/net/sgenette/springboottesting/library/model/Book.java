package net.sgenette.springboottesting.library.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public final class Book {

    @NonNull Isbn13 isbn13;
    @NonNull String title;
    @NonNull Author author;
}
