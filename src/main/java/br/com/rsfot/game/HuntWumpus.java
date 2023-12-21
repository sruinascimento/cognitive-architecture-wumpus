package br.com.rsfot.game;

import br.com.rsfot.domain.*;

import static br.com.rsfot.domain.Direction.*;

public class HuntWumpus {
    private Agent agent = new Agent();
    private Environment environment = new Environment(4);

    public void moveAgent() {

    }

    public void turnAgentLeft() {
        switch (agent.getFacingDirection()) {
            case NORTH -> agent.setFacingDirection(WEST);
            case WEST -> agent.setFacingDirection(SOUTH);
            case SOUTH -> agent.setFacingDirection(EAST);
            case EAST -> agent.setFacingDirection(NORTH);
        }
    }

    public void turnAgentRight() {
        switch (agent.getFacingDirection()) {
            case NORTH -> agent.setFacingDirection(EAST);
            case EAST -> agent.setFacingDirection(SOUTH);
            case SOUTH -> agent.setFacingDirection(WEST);
            case WEST -> agent.setFacingDirection(NORTH);
        }
    }
}
