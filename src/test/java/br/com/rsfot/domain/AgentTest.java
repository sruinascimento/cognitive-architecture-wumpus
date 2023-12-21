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
    @DisplayName("Agent should move forward to same face east direction when facing direction is east")
    void moveForward__agent_should_move_forward_to_same_face_direction_east() {
        agent.setFacingDirection(EAST);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isZero();
        assertThat(agent.getCoordinateX()).isEqualTo(1);
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is west")
    void moveForward__agent_should_move_forward_to_same_face_direction() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(WEST);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(2);
        assertThat(agent.getCoordinateX()).isEqualTo(1);
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is north")
    void moveForward__agent_should_move_forward_to_same_face_direction_north() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(NORTH);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(3);
        assertThat(agent.getCoordinateX()).isEqualTo(2);
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is south")
    void moveForward__agent_should_move_forward_to_same_face_direction_south() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(SOUTH);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(1);
        assertThat(agent.getCoordinateX()).isEqualTo(2);
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
