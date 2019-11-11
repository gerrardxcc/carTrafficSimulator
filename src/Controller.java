import model.Road;
import model.Simulator;
import view.MainFrame;
import view.MapView;
import view.RoadRectangle;
import view.TrafficLightView;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;

public class Controller {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        Simulator simulator = new Simulator();

        MapView mapView = new MapView();//c
        mapView.setSimulator(simulator);
        mapView.load("positions.csv");

        mainFrame.add(mapView, BorderLayout.CENTER);//c add mapview to mainframe

        mainFrame.pack();

        // make frame visible for user


        mainFrame.setVisible(true); //c
        mainFrame.addNewActionListener(event ->{
            simulator.getNewCity();
        });

        mainFrame.addOpenActionListener(event -> {
            simulator.load("data.csv");
        });
        mainFrame.addSaveActionListener(event -> {
            simulator.save("data.csv");
        });

        mainFrame.addExitActionListener(event ->System.exit(0) );
    }

}
