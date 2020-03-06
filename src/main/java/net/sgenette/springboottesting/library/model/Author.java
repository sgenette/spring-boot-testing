package net.sgenette.springboottesting.library.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public final class Author {

    @NonNull Name firstName;
    @NonNull Name lastName;
}
