package model;

public class Road {
    private int length;
    private Road nextRoad;
    private TrafficLights nextTrafficLight;
    private int id;

    public int getId() {
        return id;
    }

    public Road(int id, int length){
        this.length=length;
        this.id=id;
    }
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Road getNextRoad() {
        return nextRoad;
    }

    public void setNextRoad(Road nextRoad) {
        this.nextRoad = nextRoad;
    }
    public void setNextTrafficLight(TrafficLights nextTrafficLight){
        this.nextTrafficLight=nextTrafficLight;
    }

    @Override
    public String toString() {
        return "" + id;
    }
}
