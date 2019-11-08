package view;

import model.Road;
import model.Vehicle;
import javax.swing.*;
import java.awt.*;

public class VehicleRectangle extends JPanel {
    private int width = 50,height =60;
    private Vehicle vehicle;
    private int x, y;


    public VehicleRectangle(Vehicle vehicle){
        this.vehicle = vehicle;
        x = 0;
        y = 0;
    }

    public void draw(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
    }


    public void Update(){

    }
}

