package net.sgenette.springboottesting.library.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
final class Name {

    @NotNull
    @Pattern(regexp = "^[A-Za-z]{1,30}$")
    final private String name;
}
