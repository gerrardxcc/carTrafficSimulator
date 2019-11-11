package model;

import model.Road;
import model.Simulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulatorTest {

    @Test
    void loadFailing() {
        Simulator simulator = new Simulator();

        boolean status = simulator.load("badFileName.csv");
        assertFalse(status);
    }

    @Test
    void loadSuccessful() {
        Simulator simulator = new Simulator();
        boolean status = simulator.load("data.csv");
        assertTrue(status);
    }

    @Test
    void loadCorrectData() {
        // testing the data.csv file for 2 roads, and they are:
        // roadID == 1, roadLength == 4, nextID == 2
        // roadID == 2, roadLength == 5, nextID == "n"
        Simulator simulator = new Simulator();
        boolean status = simulator.load("data.csv");
        assertTrue(status);
        for (Road road : simulator.roads("data.csv")) {
            System.out.println(road.getId() + " " + road.getLength() + " " + road.getNextRoad());
        }
    }


    @Test
    void saveCheck() {
        Simulator simulator = new Simulator();
        boolean status = simulator.save("newFile.csv");
        assertTrue(status);
    }

    @Test
    void saveSuccessful() {
        Simulator simulator = new Simulator();
        simulator.load("data.csv");
        simulator.save("other.csv");

        simulator.load("other.csv");

        for (Road road : simulator.roads){
            System.out.println(road.getId()+""+road.getLength());
        }


    }
}