package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulator {
    private int newCity;
    private int start;
    private int save;
    private int exit;
    List<Road> roads;
    // traffic lights
    // vehicles



    //constructor - create empty list of road objects


    public Simulator() {
        roads = new ArrayList<>();
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


    public void setNewCity(int newCity) {
        this.newCity = newCity;
    }

    public int getNewCity() {
        return newCity;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
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
}
