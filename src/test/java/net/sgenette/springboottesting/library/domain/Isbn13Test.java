package net.sgenette.springboottesting.library.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Isbn13Test {

    @Test
    public void isbn10WithHyphens_shouldBeOk() {
        String validIsbn10 = "0-19-853453-1";

        Isbn13 actualIsbn13 = new Isbn13(validIsbn10);

        assertThat(actualIsbn13.getIsbn13()).isInstanceOf(String.class).hasSize(13);
    }

    @Test
    public void isbn10WithoutHyphens_shouldBeOk() {
        String validIsbn10 = "0198534531";

        Isbn13 actualIsbn13 = new Isbn13(validIsbn10);

        assertThat(actualIsbn13.getIsbn13()).isInstanceOf(String.class).hasSize(13);
    }

    @Test
    public void isbn13WithHyphens_shouldBeOk() {
        String validIsbn13 = "978-1-56619-909-4";

        Isbn13 actualIsbn13 = new Isbn13(validIsbn13);

        assertThat(actualIsbn13.getIsbn13()).isInstanceOf(String.class).hasSize(13);
    }

    @Test
    public void isbn13WithoutHyphens_shouldBeOk() {
        String validIsbn13 = "9781566199094";

        Isbn13 actualIsbn13 = new Isbn13(validIsbn13);

        assertThat(actualIsbn13.getIsbn13()).isInstanceOf(String.class).hasSize(13);
    }

    @Test
    public void invalidIsbn_shouldThrowIllegalArgumentException() {
        String invalidIsbn = "12345678901";

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn13(invalidIsbn)
        );
    }

    @Test
    public void emptyIsbn_shouldThrowIllegalArgumentException() {
        String invalidIsbn = "";

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn13(invalidIsbn)
        );
    }

    @Test
    public void nullIsbn_shouldThrowIllegalArgumentException() {
        String invalidIsbn = null;

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Isbn13(invalidIsbn)
        );
    }

}
