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


    //constructor - create empty list of road objects


    public Simulator() {
        roads = new ArrayList<>();
    }

    public boolean load(String filename) {
        try {

            roads.clear();

            Scanner scanner = new Scanner(new File("roads.csv"));
            Scanner scanner1 = new Scanner(new File("position.csv"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                int roadID = Integer.parseInt(words[0]);
                int length = Integer.parseInt(words[1]);
                Road road = new Road(roadID, length);
                roads.add(road);
            }
            while (scanner1.hasNextLine()){
                String line = scanner1.nextLine();
                String[] words = line.split(",");
                int roadID = Integer.parseInt(words[2]);
                int length = Integer.parseInt(words[3]);
                Road road = new Road(roadID,length);
                roads.add(road);
            }

            scanner.close();
            scanner1.close();
            return true;

        } catch (IOException e) {
            System.err.println("File no found");
            return false;
        }
    }


    public boolean save(String filename) {
       try{
           File file = new File(filename);
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


    // load()
    //  clear the list
    //  open the file
    //  read each line of the file
    //  create a road object based on the id and road length
    //  save that road object into the roads list
    //  close the file


    // save()
    //  open the file for writing
    //  for each road in roads:
    //      write the road id and road length comma-separated
    //  close file


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


    public Road[] roads(String s) {
    }
}
