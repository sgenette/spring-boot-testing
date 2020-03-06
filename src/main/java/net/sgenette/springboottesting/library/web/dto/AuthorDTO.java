package net.sgenette.springboottesting.library.web.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthorDTO {

    String firstName;
    String lastName;
}
