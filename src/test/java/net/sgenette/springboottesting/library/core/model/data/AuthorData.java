package net.sgenette.springboottesting.library.core.model.data;

import net.sgenette.springboottesting.library.core.model.Author;
import net.sgenette.springboottesting.library.core.model.Name;

public final class AuthorData {

    public static final Author MARTIN_FOWLER = Author.builder()
            .firstName(new Name("Martin"))
            .lastName(new Name("Fowler"))
            .build();

}
