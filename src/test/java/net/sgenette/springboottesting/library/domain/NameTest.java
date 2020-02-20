package net.sgenette.springboottesting.library.domain;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void name_shouldBeValid() {
        Name name = new Name("Robert");

        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations).isEmpty();
    }

    @Test
    public void nameWithLengthOver30_shouldNotBeValid() {
        Name name = new Name("A very long name that exceeds the maximum length");

        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations).hasSize(1);
    }

    @Test
    public void nameWithDigit_shouldNotBeValid() {
        Name name = new Name("Martin1");

        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations).hasSize(1);
    }

    @Test
    public void emptyName_shouldNotBeValid() {
        Name name = new Name("");

        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations).hasSize(1);
    }

    @Test
    public void nullName_shouldNotBeValid() {
        Name name = new Name(null);

        Set<ConstraintViolation<Name>> violations = validator.validate(name);

        assertThat(violations).hasSize(1);
    }

}
