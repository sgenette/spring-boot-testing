package net.sgenette.springboottesting.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class Author {

    @NonNull private final Name firstName;
    @NonNull private final Name lastName;
}
