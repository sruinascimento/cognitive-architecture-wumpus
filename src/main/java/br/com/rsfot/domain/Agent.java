package br.com.rsfot.domain;

import static br.com.rsfot.domain.Direction.EAST;

public class Agent {
    private int coordinateX;
    private int coordinateY;
    private String name;
    private boolean arrow;
    private int score;
    private Direction facingDirection;
    private boolean gold;
    private boolean alive;

    public Agent() {
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.name = "ANAKIN";
        this.arrow = true;
        this.score = 1000;
        this.facingDirection = EAST;
        this.gold = false;
        this.alive = true;
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
            case NORTH -> this.coordinateX--;
            case SOUTH -> this.coordinateX++;
            case EAST -> this.coordinateY++;
            case WEST -> this.coordinateY--;
        }
    }

    public void shoot() {
        if (arrow) {
            arrow = false;
        }
    }

    public boolean hasArrow() {
        return arrow;
    }

    public void setArrow(boolean arrow) {
        this.arrow = arrow;
    }

    public boolean hasGold() {
        return gold;
    }

    public void grab() {
        this.gold = true;
    }

    public boolean isAlive() {
        return alive;
    }

    public void die() {
        this.alive = false;
    }

    public int getScore() {
        return score;
    }

    public String getStringCoordinate() {
        return coordinateX + "," + coordinateY;
    }

    public void decreasePointByAction() {
        this.score--;
    }

    public void decreasePointByShoot() {
        this.score -= 10;
    }
    public void decreasePointByDeath() {
        this.score -= 1000;
    }

    public void increasePointByGrabGoldAndWinTheGame() {
        this.score += 1000;
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
                ", gold=" + gold +
                ", alive=" + alive +
                '}';
    }
}
