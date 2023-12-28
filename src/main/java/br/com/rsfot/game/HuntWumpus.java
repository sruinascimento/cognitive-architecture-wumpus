package br.com.rsfot.game;

import br.com.rsfot.domain.*;

import static br.com.rsfot.domain.Direction.*;
import static br.com.rsfot.domain.Rotation.LEFT;
import static br.com.rsfot.domain.Rotation.RIGHT;

public class HuntWumpus {
    private Agent agent = new Agent();
    private Environment environment = new Environment(4);

    public Agent getAgent() {
        return agent;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void turnAgentTo(Rotation rotation) {
        if (LEFT.equals(rotation)) {
            turnAgentLeft();
        }
        if (RIGHT.equals(rotation)) {
            turnAgentRight();
        }
    }

    private void turnAgentLeft() {
        switch (agent.getFacingDirection()) {
            case NORTH -> agent.setFacingDirection(WEST);
            case WEST -> agent.setFacingDirection(SOUTH);
            case SOUTH -> agent.setFacingDirection(EAST);
            case EAST -> agent.setFacingDirection(NORTH);
        }
    }

    private void turnAgentRight() {
        switch (agent.getFacingDirection()) {
            case NORTH -> agent.setFacingDirection(EAST);
            case EAST -> agent.setFacingDirection(SOUTH);
            case SOUTH -> agent.setFacingDirection(WEST);
            case WEST -> agent.setFacingDirection(NORTH);
        }
    }

    public void moveForward() {
        if (canWalk()) {
            agent.moveForward();
        }
    }

    private boolean canWalk() {
        switch (agent.getFacingDirection()) {
            case NORTH:
                return agent.getCoordinateY() < environment.getDimension() - 1;
            case SOUTH:
                return agent.getCoordinateY() > 0;
            case EAST:
                return agent.getCoordinateX() < environment.getDimension() - 1;
            case WEST:
                return agent.getCoordinateX() > 0;
            default:
                return false;
        }
    }
}
