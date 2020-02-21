package net.sgenette.springboottesting.library.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.apache.commons.validator.routines.RegexValidator;

@Getter
@EqualsAndHashCode
final class Name {

    @NonNull private final String name;

    public Name(String name) {
        boolean validName = new RegexValidator("^[A-Za-z]{1,30}$").isValid(name);

        if (validName) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

}
