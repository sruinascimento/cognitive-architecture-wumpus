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
    void moveForward__agent_should_move_forward_to_same_face_direction_east_and_increase_y() {
        agent.setFacingDirection(EAST);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isOne();
        assertThat(agent.getCoordinateX()).isZero();
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is west")
    void moveForward__agent_should_move_forward_to_same_face_direction_and_decrease_y() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(WEST);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(1);
        assertThat(agent.getCoordinateX()).isEqualTo(2);
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is north")
    void moveForward__agent_should_move_forward_to_same_face_direction_north_and_decrease_x() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(NORTH);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(2);
        assertThat(agent.getCoordinateX()).isEqualTo(1);
    }

    @Test
    @DisplayName("Agent should move forward to same face direction when facing direction is south")
    void moveForward__agent_should_move_forward_to_same_face_direction_south_and_increase_x() {
        agent.setCoordinateX(2);
        agent.setCoordinateY(2);
        agent.setFacingDirection(SOUTH);
        agent.moveForward();
        assertThat(agent.getCoordinateY()).isEqualTo(2);
        assertThat(agent.getCoordinateX()).isEqualTo(3);
    }
}
