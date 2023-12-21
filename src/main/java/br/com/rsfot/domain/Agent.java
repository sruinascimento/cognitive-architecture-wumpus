package br.com.rsfot.domain;

import java.util.List;

import static br.com.rsfot.domain.Direction.*;

public class Agent {
    private int coordinateX;
    private int coordinateY;
    private String name;
    private boolean arrow;
    private int score;
    private Direction facingDirection;

    public Agent() {
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.name = "ANAKIN";
        this.arrow = true;
        this.score = 1000;
        this.facingDirection = EAST;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
    public String getName() {
        return name;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(Direction facingDirection) {
        this.facingDirection = facingDirection;
    }

    public void moveForward() {
        this.moveTo(this.facingDirection);
    }

    private void moveTo(Direction direction) {
        switch (direction) {
            case NORTH -> this.coordinateY++;
            case SOUTH -> this.coordinateY--;
            case EAST -> this.coordinateX++;
            case WEST -> this.coordinateX--;
        }
    }

    public void turnTo(Direction direction) {
        if (direction == Direction.NORTH && List.of(Direction.EAST, Direction.WEST).contains(this.facingDirection)) {
            this.facingDirection = Direction.NORTH;
        } else if (direction == Direction.SOUTH && List.of(Direction.EAST, Direction.WEST).contains(this.facingDirection)) {
            this.facingDirection = Direction.SOUTH;
        } else if (direction == Direction.EAST && List.of(Direction.NORTH, Direction.SOUTH).contains(this.facingDirection)) {
            this.facingDirection = Direction.EAST;
        } else if (direction == Direction.WEST && List.of(Direction.NORTH, Direction.SOUTH).contains(this.facingDirection)) {
            this.facingDirection = Direction.WEST;
        } else {
            throw new IllegalArgumentException("Impossible turn to %s from %s".formatted(direction, this.facingDirection));
        }
    }
}
