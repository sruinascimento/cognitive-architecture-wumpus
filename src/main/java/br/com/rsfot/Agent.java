package br.com.rsfot;

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
}
