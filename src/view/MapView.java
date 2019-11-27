package view;

import model.Road;
import model.Simulator;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapView extends JPanel implements ActionListener {
    Simulator simulator;
    private boolean running;

    List<RoadRectangle> roadRectangles;
    List<TrafficLightView> trafficLightViews;
    List<VehicleRectangle> vehicleRectangles;


    //

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
                RoadRectangle roadRectangle = new RoadRectangle();
                roadRectangle.setLocation(x, y);
                roadRectangle.setRoad(road);
                roadRectangles.add(roadRectangle);
            }
            scanner.close();
            return true;

        } catch (IOException e) {
            System.err.println("File no found");
            return false;
        }
    }

    public boolean save(String filename) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(filename));
            for (RoadRectangle roadRectangle : roadRectangles) {
                printWriter.println(roadRectangle.getID() + "," + roadRectangle.x + "," + roadRectangle.y);
            }
            printWriter.close();


            return true;

        } catch (IOException e) {
            System.err.println("File no found");
            return false;
        }


    }

    public MapView() {
        Timer timer = new Timer(100, this);
        timer.start();

        setPreferredSize(new Dimension(1000, 500));
        setBackground(Color.cyan);
        roadRectangles = new ArrayList<>();
        trafficLightViews = new ArrayList<>();
        vehicleRectangles = new ArrayList<>();
    }

    public RoadRectangle roadSelect(Point point) {
        for (RoadRectangle roadRectangle : roadRectangles) {
            if (roadRectangle.contains(point)) {
                return roadRectangle;
            }
        }

        return null;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("running is " + running);
        if (running) {
            Vehicle vehicle = simulator.spawnVehicle();
            if (vehicle != null) {
                System.out.println("Created vehicle rectangle");
                VehicleRectangle vehicleRectangle = new VehicleRectangle(vehicle);
                vehicleRectangles.add(vehicleRectangle);
            }

            // TODO for any inactive vehicle in the simulator delete the corresponding vehcilerectangle here in mapview
            List<Vehicle> inactives = simulator.getInactiveVehicles();
            // for each inactive in inactives find it's vehicleRectangle and remove it from vehicleRectangles;
            List<VehicleRectangle> inactiveVehicleRectangles = new ArrayList<>();
            for (VehicleRectangle vehicleRectangle : vehicleRectangles) {
                if (inactives.contains(vehicleRectangle.getVehicle())) {
                    inactiveVehicleRectangles.add(vehicleRectangle);
                }
            }

            for (VehicleRectangle inactiveVehicleRectangle : inactiveVehicleRectangles) {
                System.out.println("removing: " + inactiveVehicleRectangle.getVehicle());
                vehicleRectangles.remove(inactiveVehicleRectangle);
            }

            simulator.destroyInactiveVehicles();

            synchroniseViewObjects();

            simulator.update();
        }

        repaint();
    }

    private void synchroniseViewObjects() {
        for (VehicleRectangle vehicleRectangle : vehicleRectangles) {
            Vehicle vehicle = vehicleRectangle.getVehicle();
            Road current = vehicle.getCurrentOn();
            int roadID = current.getId();
            RoadRectangle currentRoadRect = roadRectangles.get(roadID - 1);

            vehicleRectangle.setLocation((int) (vehicle.getVehiclePosition()*RoadRectangle.SEGMENT_SIZE + currentRoadRect.getX()), (int) currentRoadRect.getY());
        }
    }


    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;// downcast
//        graphics2D.draw(roadRectangle);
        // for each roadRectangle in roadRectangles: draw(roadRectangle)
        System.out.println("number of road rectangles: " + roadRectangles.size());
        for (RoadRectangle roadRectangle : roadRectangles) {
            graphics.setColor(Color.gray);
            graphics2D.fill(roadRectangle);
        }

        System.out.println("number of vehicle rectangles: " + vehicleRectangles.size());
        for (VehicleRectangle vehicleRectangle : vehicleRectangles) {
            graphics2D.setColor(Color.blue);
            graphics2D.fill(vehicleRectangle);
            System.out.println("vehicle " + vehicleRectangle.getVehicle() + " position: " + vehicleRectangle.getLocation());
        }

        System.out.println("number of traffic light rectangles: " + trafficLightViews.size());
        for (TrafficLightView trafficLightView : trafficLightViews) {
            graphics2D.setColor(Color.green);
            graphics2D.fill(trafficLightView);
        }
    }

    public void startSimulation() {
        vehicleRectangles.clear();
        simulator.start();
        running = true;
    }

    public void stopSimulation() {
        running = false;
    }
}