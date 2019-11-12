package view;

import model.Road;
import model.Simulator;
import model.TrafficLights;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapView extends JPanel implements ActionListener {
    Simulator simulator;

    List<RoadRectangle> roadRectangles;
    List<TrafficLightView>trafficLightViews;
    List<VehicleRectangle>vehicleRectangles;


    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
        simulator.load("roads.csv");
    }

    public boolean load(String filename) {
        roadRectangles.clear();
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                int roadID = Integer.parseInt(words[0]);
                int x = Integer.parseInt(words[1]);
                int y = Integer.parseInt(words[2]);

                Road road = simulator.getRoad(roadID - 1);
                RoadRectangle roadRectangle = new RoadRectangle(road);
                roadRectangle.setLocation(x,y);
                roadRectangles.add(roadRectangle);
            }
            scanner.close();
            return true;

        } catch (IOException e){
            System.err.println("File no found");
            return false;
        }
    }
    public boolean save(String filename) {
        try{
            PrintWriter printWriter = new PrintWriter(new FileWriter(filename));
            for (RoadRectangle roadRectangle:roadRectangles){
                printWriter.println(roadRectangle.getID()+","+roadRectangle.x+","+roadRectangle.y);
            }
            printWriter.close();


            return true;

        } catch (IOException e) {
            System.err.println("File no found");
            return false;
        }


    }
    public MapView() {
        Timer timer = new Timer(24, this);
        timer.start();

        setPreferredSize(new Dimension(1000, 500));
        setBackground(Color.cyan);
        roadRectangles = new ArrayList<>();
        trafficLightViews = new ArrayList<>();
        vehicleRectangles = new ArrayList<>();
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
          graphics.setColor(Color.black);
          graphics2D.draw(roadRectangle);
        }
        for (VehicleRectangle vehicleRectangle:vehicleRectangles){
            graphics2D.setColor(Color.blue);
            graphics2D.draw(vehicleRectangle);
        }
        for(TrafficLightView trafficLightView:trafficLightViews){
            graphics2D.setColor(Color.green);
            graphics2D.draw(trafficLightView);
        }



    }
}
