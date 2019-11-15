package model;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Road road = new Road(5, 1);
        Road road2 = new Road(6, 2);
        Vehicle vehicle = new Vehicle(road);
        TrafficLights trafficLights = new TrafficLights();
        road.setNextRoad(road2);
        road.setNextTrafficLight(trafficLights);
        Random random = new Random();
        for (int i=0; i<100;i++){
            float value = random.nextFloat();
            float rateOfChange = value*100;
            if (value<0.1){
                System.out.println(rateOfChange);
                trafficLights.toggleGreen();
            }
            int currentRoadID = vehicle.getCurrentOn().getId();
            System.out.print("Road "+currentRoadID+" ");
            if (trafficLights.isGreen()){
                System.out.print("TrafficLight is GREEN, ");
                System.out.println("Car is moving.");
            } else {
                System.out.print("TrafficLight is RED, ");
                System.out.println("Car is stop.");
            }
            vehicle.update();

        }



    }
}

