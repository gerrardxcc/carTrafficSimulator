package view;

import model.Road;

import java.awt.*;

public class RoadRectangle extends Rectangle {
    private Road road;

    public RoadRectangle(Road road) {
        this.road = road;
        updateSize();
        height = 30;
        x = y = 0;
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
        width = road.getLength() * 30;
    }

    public Road getRoad() {
        return road;
    }
}
