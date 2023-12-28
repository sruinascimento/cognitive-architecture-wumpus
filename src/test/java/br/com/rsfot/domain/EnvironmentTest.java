package br.com.rsfot.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class EnvironmentTest {
    @Test
    void Environment__should_throw_IllegalArgumentException_when_dimension_is_less_than_4() {
       assertThatThrownBy(() -> new Environment(3))
               .isInstanceOf(IllegalArgumentException.class)
               .hasMessage("Dimension must be at least 4");
    }

}
