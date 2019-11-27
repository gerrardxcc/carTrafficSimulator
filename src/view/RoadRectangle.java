package view;

import model.Road;

import java.awt.*;

public class RoadRectangle extends Rectangle {
    private Road road;
    public static final int SEGMENT_SIZE = 30;

    public RoadRectangle() {
        height = 80;
        x = y = 0;
    }

    public void setRoad(Road road) {
        this.road = road;
        updateSize();
    }

    public Road getRoad(){
        return road;
    }

    public int getID() {
        return road.getId();
    }

    public void grow() {
        road.setLength(road.getLength() + 1);
        updateSize();
    }

    public void shrink(){
        road.setLength(road.getLength() - 1);
        updateSize();
    }

    private void updateSize() {
        width = road.getLength() * SEGMENT_SIZE;
    }

    @Override
    public String toString() {
        return road.toString();
    }
}
