package net.sgenette.springboottesting.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class Author {

    private final Name firstName;
    private final Name lastName;
}
