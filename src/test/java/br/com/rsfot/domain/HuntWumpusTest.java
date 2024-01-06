package br.com.rsfot.domain;

import br.com.rsfot.game.HuntWumpus;
import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.Set;

import static br.com.rsfot.domain.Direction.*;
import static br.com.rsfot.domain.EnvironmentFeelings.GLITTER;
import static br.com.rsfot.domain.EnvironmentObject.PIT;
import static br.com.rsfot.domain.EnvironmentObject.WUMPUS;
import static br.com.rsfot.domain.Rotation.LEFT;
import static br.com.rsfot.domain.Rotation.RIGHT;
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
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(NORTH);

        huntWumpus.turnAgentTo(LEFT);
        assertThat(huntWumpus.getAgent().getFacingDirection()).isEqualTo(WEST);

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

    @Test
    @DisplayName("Agent should grab gold, if gold is in the same position")
    void grabGold__() {
        int[] goldCoordinate = retrieveGoldCoordinate(huntWumpus.getEnvironment().getFeelingsByCoordinate());
        huntWumpus.getAgent().setCoordinateX(goldCoordinate[0]);
        huntWumpus.getAgent().setCoordinateY(goldCoordinate[1]);

        huntWumpus.grabGold();

        assertThat(huntWumpus.getAgent().hasGold()).isTrue();
    }

    private int[] retrieveGoldCoordinate(Map<String, Set<EnvironmentFeelings>> feelingsByCoordinate) {
        for (Map.Entry<String, Set<EnvironmentFeelings>> feelings : feelingsByCoordinate.entrySet()) {
            if (feelings.getValue().contains(GLITTER)) {
                return buildCoordinateFromString(feelings.getKey()); // Retorna a chave (coordenada) correspondente ao valor
            }
        }
        throw new IllegalArgumentException("Environment should have gold");
    }
    private int[] buildCoordinateFromString(String coordinate){
        String[] coordinates = coordinate.split(",");
        return new int[]{Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1])};

    }

    @Test
    @DisplayName("Agent should not grab gold if gold is not in the same position")
    void grabGold__should_not_grab_gold_if_gold_is_not_in_the_same_position() {
        huntWumpus.getAgent().setCoordinateX(0);
        huntWumpus.getAgent().setCoordinateY(0);
        huntWumpus.grabGold();

        assertThat(huntWumpus.getAgent().hasGold()).isFalse();
    }

    @Test
    @DisplayName("Agent should die if it moves to a position where there is a pit")
    void moveForward__agent_must_die_if_it_moves_to_a_position_where_there_is_a_pit() {
        HuntWumpus huntWumpusCustomized = createHuntWumpusWithPitsCustomized();
        assertThat(huntWumpusCustomized.getAgent().isAlive()).isTrue();
        huntWumpusCustomized.moveForward();
        assertThat(huntWumpusCustomized.getAgent().isAlive()).isFalse();
    }

    private HuntWumpus createHuntWumpusWithPitsCustomized() {
        String[][] cave = {
                {"", PIT.name(), "", ""},
                {PIT.name(), PIT.name(), "", ""},
                {"", "", "", ""},
                {"", "", "", ""}
        };

        Environment environment = new Environment(cave, 4);

        Agent agent = new Agent();
        return new HuntWumpus(agent, environment);
    }

    @Test
    @DisplayName("Agent should die if it moves to a position where there is a wumpus")
    void moveForward__agent_must_die_if_it_moves_to_a_position_where_there_is_a_wumpus() {
        HuntWumpus huntWumpusCustomized = createHuntWumpusWithWumpusCustomized();
        assertThat(huntWumpusCustomized.getAgent().isAlive()).isTrue();
        huntWumpusCustomized.moveForward();
        assertThat(huntWumpusCustomized.getAgent().isAlive()).isFalse();
    }

    private HuntWumpus createHuntWumpusWithWumpusCustomized() {
        String[][] cave = {
                {"", WUMPUS.name(), "", ""},
                {"", "", "", ""},
                {"", "", "", ""},
                {"", "", "", ""}
        };

        Environment environment = new Environment(cave, 4);

        Agent agent = new Agent();
        return new HuntWumpus(agent, environment);
    }
}