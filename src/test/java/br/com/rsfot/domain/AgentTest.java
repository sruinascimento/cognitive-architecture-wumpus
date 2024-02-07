package br.com.rsfot.domain;

import org.junit.jupiter.api.*;

import static br.com.rsfot.domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    @DisplayName("Agent should shoot if has arrow")
    void shoot__agent_should_shoot_if_has_arrow() {
        assertThat(agent.hasArrow()).isTrue();
        agent.shoot();
        assertThat(agent.hasArrow()).isFalse();
    }

    @Test
    @DisplayName("Agent should not shoot f hasn't arrow")
    void shoot__agent_should_not_shoot_if_has_not_arrow() {
        agent.setArrow(false);
        assertThat(agent.hasArrow()).isFalse();
        agent.shoot();
        assertThat(agent.hasArrow()).isFalse();
    }
}
