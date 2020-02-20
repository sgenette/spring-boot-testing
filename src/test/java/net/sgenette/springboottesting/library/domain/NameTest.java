package net.sgenette.springboottesting.library.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @Test
    public void name_shouldBeOk() {
        String name = "Robert";

        Name actualName = new Name(name);

        assertThat(actualName.getName()).isEqualTo(name);
    }

    @Test
    public void nameWithLengthOver30_shouldThrowIllegalArgumentException() {
        String name = "A very long name that exceeds the maximum length";

        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    public void nameWithDigit_shouldThrowIllegalArgumentException() {
        String name = "Martin1";

        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    public void emptyName_shouldThrowIllegalArgumentException() {
        String name = "";

        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    public void nullName_shouldThrowIllegalArgumentException() {
        String name = null;

        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

}
