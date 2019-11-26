package model;

import model.Road;

public class Vehicle{
    private int vehiclePosition;
    private Road currentOn;
    private int speed=1;
    private int vehicleLength;
    private boolean isActive = true;

    public Vehicle(Road currentOn){
           this.currentOn=currentOn;

    }
    public int getVehiclePosition(){
        return vehiclePosition;
    }
    public void setVehiclePosition(int p){
        this.vehiclePosition = p;
    }
    public Road getCurrentOn(){
        return currentOn;
    }

    public void setCurrentOn(Road currentOn) {
        this.currentOn = currentOn;
    }

    public void update(){
        // if position is at the end of the current road then goto the next road
        if (vehiclePosition >= currentOn.getLength()) {
            currentOn = currentOn.getNextRoad();
            if (currentOn == null){
                isActive = false;
            }
            vehiclePosition = 1;
        } else {

            this.vehiclePosition += speed;
        }
    }

    public boolean getIsActive() {
        return isActive;
    }

    public int getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(int vehicleLength) {
        this.vehicleLength = vehicleLength;
    }

    @Override
    public String toString() {
        int id = currentOn == null ? -1 : currentOn.getId();
        return String.format("pos %d current road %d", vehiclePosition, id);
    }
}
