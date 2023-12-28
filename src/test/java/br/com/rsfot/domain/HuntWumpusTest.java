package br.com.rsfot.domain;

import br.com.rsfot.game.HuntWumpus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Map;
import java.util.stream.Stream;

import static br.com.rsfot.domain.Direction.*;
import static br.com.rsfot.domain.Rotation.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HuntWumpusTest {
    private HuntWumpus huntWumpus;

    @BeforeEach
    void setUp() {
        huntWumpus = new HuntWumpus();
    }

    @Test
    @DisplayName("Agent should turn left")
    void turnAgentLeft__should_turn_agent_turn_left() {
        huntWumpus.turnAgentTo(LEFT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(Direction.NORTH);

        huntWumpus.turnAgentTo(LEFT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(Direction.WEST);

        huntWumpus.turnAgentTo(LEFT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(SOUTH);

        huntWumpus.turnAgentTo(LEFT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(EAST);
    }

    @Test
    @DisplayName("Agent should turn right")
    void turnAgentRight__should_turn_agent_turn_right() {
        huntWumpus.turnAgentTo(RIGHT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(SOUTH);

        huntWumpus.turnAgentTo(RIGHT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(WEST);

        huntWumpus.turnAgentTo(RIGHT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(NORTH);

        huntWumpus.turnAgentTo(RIGHT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(EAST);
    }
}
