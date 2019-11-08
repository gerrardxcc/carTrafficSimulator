package CarTrafficSimulator;

public class Vehicle{
    private int vehiclePosition;
    private Road currentOn;
    private int speed=1;

    public Vehicle(Road currentOn){
           this.currentOn=currentOn;

    }
    public int getVehiclePosition(){
        return vehiclePosition;
    }
    public void setVehiclePosition(int p){
        this.vehiclePosition = p;
    }
    public Road getCurrentOn(){
        return currentOn;
    }

    public void setCurrentOn(Road currentOn) {
        this.currentOn = currentOn;
    }
    public void Update(){
        this.vehiclePosition += speed;
    }
}
