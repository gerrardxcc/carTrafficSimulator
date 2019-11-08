package CarTrafficSimulator;

public class TrafficLights{
    private float rateOfChange;
    private boolean green= true;

    public boolean isGreen() {
        return green;
    }

    public void setGreen(boolean green) {
        this.green = green;
    }

    public float getRateOfChange(){
        return rateOfChange;
    }
    public void setRateOfChange(float rateOfChange){
        this.rateOfChange=rateOfChange;
    }
    public void toggleGreen(){
        this.green=!this.green;
    }
}
