package view;

import model.TrafficLights;

import javax.swing.*;
import java.awt.*;


public class TrafficLightView extends Rectangle {
    private TrafficLights trafficLights;

    public TrafficLightView(TrafficLights trafficLights){
        this.trafficLights =trafficLights;
        width = 5;
        height = 6;
    }



}
