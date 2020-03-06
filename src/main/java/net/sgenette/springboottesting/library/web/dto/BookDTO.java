package net.sgenette.springboottesting.library.web.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookDTO {

    String isbn;
    String title;
    AuthorDTO author;
}
