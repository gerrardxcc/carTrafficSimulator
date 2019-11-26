package view;

import model.Vehicle;

import java.awt.*;

public class VehicleRectangle extends Rectangle {
    private Vehicle vehicle;
    private RoadRectangle roadRectangle;


    public VehicleRectangle(Vehicle vehicle) {
        this.vehicle = vehicle;
        width = vehicle.getVehicleLength() * 4;
        height = 20;
    }

    public RoadRectangle currentOnRectangle() {
        return roadRectangle;
    }

    public void setRoadRectangle(RoadRectangle roadRectangle) {
        this.roadRectangle = roadRectangle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public RoadRectangle getRoadRectangle() {
        return roadRectangle;
    }
}
