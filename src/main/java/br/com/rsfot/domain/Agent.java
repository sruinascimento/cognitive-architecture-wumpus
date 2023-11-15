package br.com.rsfot.domain;

public class Agent {
    private int coordinateX;
    private int coordinateY;

    private String name;

    public Agent() {
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.name = "ANAKIN";
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public String getName() {
        return name;
    }

    public void setCoordinateX(int x) {
        this.coordinateX = x;
    }

    public void setCoordinateY(int y) {
        this.coordinateY = y;
    }
}
