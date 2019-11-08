import model.Road;
import model.Simulator;
import view.MainFrame;
import view.MapView;
import view.RoadRectangle;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;

public class Controller {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        Simulator simulator = new Simulator();

        Road road = new Road(10,1);//c
        RoadRectangle roadRectangle = new RoadRectangle(road);//c

        MapView mapView = new MapView();//c
        mainFrame.add(mapView, BorderLayout.CENTER);//c add mapveiw to mainframe

        mainFrame.pack();

        // make frame visible for user


        mainFrame.setVisible(true); //c
        mainFrame.addNewActionListener(event ->{

        });
        mainFrame.addOpenActionListener(event -> {
            simulator.load("roads.csv");
        });
        mainFrame.addSaveActionListener(event -> {
            simulator.save("data.csv");
        });
        mainFrame.addExitActionListener(event ->System.exit(0) );
    }

}
