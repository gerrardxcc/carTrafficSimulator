package view;

import model.Road;

import java.awt.*;

public class RoadRectangle extends Rectangle {
    private Road road;

    public RoadRectangle(Road road) {
        this.road = road;
        width = road.getLength() * 10;
        height = 10;
        x = y = 0;
    }


}
