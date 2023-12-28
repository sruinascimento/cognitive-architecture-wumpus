package br.com.rsfot.domain;

import static br.com.rsfot.domain.Direction.EAST;

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
            case NORTH -> this.coordinateY--;
            case SOUTH -> this.coordinateY++;
            case EAST -> this.coordinateX++;
            case WEST -> this.coordinateX--;
        }
    }

    @Override
    public String toString() {
        return "Agent{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", name='" + name + '\'' +
                ", arrow=" + arrow +
                ", score=" + score +
                ", facingDirection=" + facingDirection +
                '}';
    }
}
