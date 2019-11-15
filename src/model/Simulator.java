package model;

import view.VehicleRectangle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulator {
    private int newCity;
    private int start;
    private int save;
    private int exit;
    List<Road> roads;
    List<Vehicle>vehicles;
    private int s1;
    private int s2;
    // traffic lights
    // vehicles



    //constructor - create empty list of road objects


    public Simulator() {
        roads = new ArrayList<>();
        vehicles = new ArrayList<>();
    }


    public Road getRoad(int i) {
        return roads.get(i);
    }

    public boolean load(String fileName) {
        try {

            roads.clear();

            // part 1 - create roads
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                int roadID = Integer.parseInt(words[0]);
                int length = Integer.parseInt(words[1]);
                Road road = new Road(roadID, length);
                roads.add(road);
            }
            scanner.close();

            // part 2 - connect roads
            int i=0;

            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                if(words[2].equals("n")){
                    ++i;
                    continue;
                }
                int nextID = Integer.parseInt(words[2]);
                Road road  = roads.get(i++);
                road.setNextRoad(roads.get(nextID-1));
            }
            scanner.close();

            return true;

        } catch (IOException e) {
            System.err.println("File no found");
            return false;
        }
    }

    public boolean save(String filename) {
       try{
           File file = new File("");
           PrintWriter printWriter = new PrintWriter(new FileWriter(filename));
           for (Road road:roads){
               printWriter.println(road.getId()+","+road.getLength());
           }
           printWriter.close();


           return true;

       } catch (IOException e) {
           System.err.println("File no found");
           return false;
       }


    }
    public void start(){
        vehicles.clear();
    }

    public void update(){

        // add new vehicle 20% of the time
        Random random = new Random();
        int value = random.nextInt(100);
        if (value <= 20){
            Vehicle vehicle = new Vehicle(roads.get(0));
            vehicles.add(vehicle);
        }

        // remove inactive vehicles
        for (int i = 0; i < vehicles.size(); ++i) {
            if (!vehicles.get(i).getIsActive()) {
                vehicles.remove(i);
                --i;
            }
        }

        // update all vehicles
        for (Vehicle vehicle : vehicles){
            vehicle.update();
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
        System.out.println();
    }

    public void setNewCity(int newCity) {
        this.newCity = newCity;
    }

    public int getNewCity() {
        return newCity;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getSave() {
        return save;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }

    public int getExit() {
        return exit;
    }


    public List<Road> roads(String s) {
        return roads;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public void setS1(int s1) {
        this.s1 = s1;
    }

    public void setS2(int s2) {
        this.s2 = s2;
    }

    public int getS1() {
        return s1;
    }

    public int getS2() {
        return s2;
    }
}
