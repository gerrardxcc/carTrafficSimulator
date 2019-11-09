package view;

import model.Road;
import model.Vehicle;
import javax.swing.*;
import java.awt.*;

public class VehicleRectangle extends Rectangle {
    private Vehicle vehicle;



    public VehicleRectangle(Vehicle vehicle){
        this.vehicle = vehicle;
        width = vehicle.getVehicleLength()*4;
        height = 2;
        x=y=0;

    }


}

