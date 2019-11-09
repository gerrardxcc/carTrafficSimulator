package view;

import model.Road;
import model.Simulator;
import model.TrafficLights;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MapView extends JPanel implements ActionListener {
    Simulator simulator;
    List<RoadRectangle> roadRectangles;


    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }

    public MapView() {
        Timer timer = new Timer(24, this);
        timer.start();

        setPreferredSize(new Dimension(600, 400));
        roadRectangles = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;// downcast
//        graphics2D.draw(roadRectangle);
        // for each roadRectangle in roadRectangles: draw(roadRectangle)
        for (RoadRectangle roadRectangle : roadRectangles){
            graphics2D.draw(roadRectangle);
            graphics2D.setColor(Color.blue);
        }
        for (VehicleRectangle vehicleRectangle:roadRectangles){

        }

    }
}
