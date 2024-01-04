package br.com.rsfot.game;

import br.com.rsfot.domain.*;

import static br.com.rsfot.domain.Direction.*;
import static br.com.rsfot.domain.EnvironmentFeelings.GLITTER;
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
            System.out.println("Moved forward");
            return;
        }
        System.out.println("Can't move forward");
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
        if (agent.hasGold()) {
            System.out.println("Already has gold");
            return;
        }
        if (environment.getFeelingsByCoordinate().get(agent.getStringCoordinate()).contains(GLITTER)) {
            agent.grab();
            System.out.println("Grabbed gold");
            return;
        }
        System.out.println("No gold to grab");
    }

    public void shoot() {
        if (agent.hasArrow()) {
            agent.shoot();
            System.out.println("Shot");
            return;
        }
        System.out.println("No arrow to shoot");
    }
}
