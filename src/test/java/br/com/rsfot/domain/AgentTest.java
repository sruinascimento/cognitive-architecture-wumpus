package br.com.rsfot.domain;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static br.com.rsfot.domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AgentTest {
    private Agent agent;

    @BeforeEach
    void setup() {
        agent = new Agent();
    }

    @Test
    @DisplayName("Agent should increase x when direction is east")
    void moveTo__should_increase_x_when_direction_is_east() {
        agent.moveTo(EAST);
        assertThat(agent.getCoordinateY()).isEqualTo(0);
        assertThat(agent.getCoordinateX()).isEqualTo(1);

    }

    @Test
    @DisplayName("Agent should decrease x when direction is west")
    void moveTo__should_decrease_x_when_direction_is_west() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.moveTo(WEST);
        assertThat(agent.getCoordinateX()).isEqualTo(1);
        assertThat(agent.getCoordinateY()).isEqualTo(2);
    }

    @Test
    @DisplayName("Agent should decrease y when direction is south")
    void moveTo__should_decrease_y_when_direction_is_south() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.moveTo(SOUTH);
        assertThat(agent.getCoordinateX()).isEqualTo(2);
        assertThat(agent.getCoordinateY()).isEqualTo(1);
    }

    @Test
    @DisplayName("Agent should increase y when direction is north")
    void moveTo__should_increase_y_when_direction_is_north() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.moveTo(NORTH);
        assertThat(agent.getCoordinateX()).isEqualTo(2);
        assertThat(agent.getCoordinateY()).isEqualTo(3);
    }

    @Test
    @DisplayName("Agent should change facing direction to west when current facing direction is north")
    void turnTo__should_change_facing_direction_to_west_when_current_facing_direction_is_north() {
        agent.setFacingDirection(NORTH);
        agent.turnTo(WEST);
        assertThat(agent.getFacingDirection()).isEqualTo(WEST);
    }

    @Test
    @DisplayName("Agent should change facing direction to east when current facing direction is north")
    void turnTo__should_change_facing_direction_to_east_when_current_facing_direction_is_north() {
        agent.setFacingDirection(NORTH);
        agent.turnTo(EAST);
        assertThat(agent.getFacingDirection()).isEqualTo(EAST);
    }

    @Test
    @DisplayName("Agent should change facing direction to east when current facing direction is south")
    void turnTo__should_change_facing_direction_to_east_when_current_facing_direction_is_south() {
        agent.setFacingDirection(SOUTH);
        agent.turnTo(EAST);
        assertThat(agent.getFacingDirection()).isEqualTo(EAST);
    }

    @Test
    @DisplayName("Agent should change facing direction to west when current facing direction is south")
    void turnTo__should_change_facing_direction_to_west_when_current_facing_direction_is_south() {
        agent.setFacingDirection(SOUTH);
        agent.turnTo(WEST);
        assertThat(agent.getFacingDirection()).isEqualTo(WEST);
    }

    @Test
    @DisplayName("Agent should change facing direction to east when current facing direction is north")
    void turnTo__should_change_facing_direction_to_north_when_current_facing_direction_is_east() {
        agent.setFacingDirection(EAST);
        agent.turnTo(NORTH);
        assertThat(agent.getFacingDirection()).isEqualTo(NORTH);
    }

    @Test
    @DisplayName("Agent should change facing direction to south when current facing direction is east")
    void turnTo__should_change_facing_direction_to_south_when_current_facing_direction_is_east() {
        agent.setFacingDirection(EAST);
        agent.turnTo(SOUTH);
        assertThat(agent.getFacingDirection()).isEqualTo(SOUTH);
    }

    @Test
    @DisplayName("Agent should change facing direction to south when current facing direction is west")
    void turnTo__should_change_facing_direction_to_south_when_current_facing_direction_is_west() {
        agent.setFacingDirection(WEST);
        agent.turnTo(SOUTH);
        assertThat(agent.getFacingDirection()).isEqualTo(SOUTH);
    }

    @Test
    @DisplayName("Agent should change facing direction to north when current facing direction is west")
    void turnTo__should_change_facing_direction_to_north_when_current_facing_direction_is_west() {
        agent.setFacingDirection(WEST);
        agent.turnTo(NORTH);
        assertThat(agent.getFacingDirection()).isEqualTo(NORTH);
    }

    @ParameterizedTest
    @DisplayName("Agent should throw IllegalArgumentException when current facing direction is not adjacent to the new facing direction")
    @MethodSource("provideDirections")
    void turnTo__should_throw_IllegalArgumentException_when_current_facing_direction_is_not_adjacent_to_the_new_facing_direction(Direction currentFacingDirection, Direction newFacingDirection) {
        agent.setFacingDirection(currentFacingDirection);
        assertThatThrownBy(() -> agent.turnTo(newFacingDirection))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Impossible turn to %s from %s".formatted(newFacingDirection, agent.getFacingDirection()));
    }
    private static Stream<Arguments> provideDirections() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.SOUTH),
                Arguments.of(Direction.NORTH, Direction.NORTH),
                Arguments.of(Direction.EAST, Direction.WEST),
                Arguments.of(Direction.EAST, Direction.EAST),
                Arguments.of(Direction.SOUTH, Direction.NORTH),
                Arguments.of(Direction.SOUTH, Direction.SOUTH),
                Arguments.of(Direction.WEST, Direction.EAST),
                Arguments.of(Direction.WEST, Direction.WEST)
        );
    }
}
