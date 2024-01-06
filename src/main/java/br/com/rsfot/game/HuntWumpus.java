package br.com.rsfot.game;

import br.com.rsfot.domain.*;

import static br.com.rsfot.domain.Direction.*;
import static br.com.rsfot.domain.EnvironmentFeelings.GLITTER;
import static br.com.rsfot.domain.EnvironmentObject.PIT;
import static br.com.rsfot.domain.Rotation.LEFT;
import static br.com.rsfot.domain.Rotation.RIGHT;

public class HuntWumpus {
    private Agent agent = new Agent();
    private Environment environment = new Environment(4);

    public HuntWumpus() {

    }

    public HuntWumpus(Agent agent, Environment environment) {
        this.agent = agent;
        this.environment = environment;
    }

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
        if (canWalk() && agent.isAlive()) {
            agent.moveForward();
            if(isTheAgentDead()) {
                agent.die();
            }
        }
    }

    private boolean canWalk() {
        switch (agent.getFacingDirection()) {
            case NORTH:
                return agent.getCoordinateY() - 1 >= 0;
            case SOUTH:
                return agent.getCoordinateY() + 1 <= environment.getDimension() -1;
            case EAST:
                return agent.getCoordinateX() + 1 <= environment.getDimension() - 1;
            case WEST:
                return agent.getCoordinateX() -1 >= 0;
            default:
                return false;
        }
    }

    public void grabGold() {
        if (environment.getFeelingsByCoordinate().get(agent.getStringCoordinate()).contains(GLITTER)) {
            agent.grab();
        }
    }

    public void shoot() {
        if (agent.hasArrow()) {
            agent.shoot();
        }
    }

    public boolean isTheAgentDead() {
        boolean agentFallIntoAPit = environment.isThereAPitAt(agent.getCoordinateX(), agent.getCoordinateY());
        boolean agentDevoredByWumpus = environment.isThereAWumpusAt(agent.getCoordinateX(), agent.getCoordinateY());
        return agentFallIntoAPit || agentDevoredByWumpus;
    }
}
