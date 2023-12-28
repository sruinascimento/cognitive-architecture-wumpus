package br.com.rsfot.game;

import br.com.rsfot.domain.*;

import static br.com.rsfot.domain.Direction.*;

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
        switch (rotation) {
            case LEFT -> turnAgentLeft();
            case RIGHT -> turnAgentRight();
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

//    public void moveForward() {
//        if (canWalk())
//            switch (agent.getFacingDirection()) {
//                case NORTH -> agent.setCoordinateY(agent.getCoordinateY() + 1);
//                case SOUTH -> agent.setCoordinateY(agent.getCoordinateY() - 1);
//                case EAST -> agent.setCoordinateX(agent.getCoordinateX() + 1);
//                case WEST -> agent.setCoordinateX(agent.getCoordinateX() - 1);
//            }
//        }
//    }
//
//    public boolean canWalk() {
//        return agent.getCoordinateX() < environment.getCave().length - 1
//                &&
//                agent.getCoordinateY() < environment.getCave().length - 1;
//    }
}
