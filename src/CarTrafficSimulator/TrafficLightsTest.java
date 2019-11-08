package CarTrafficSimulator;
import model.TrafficLights;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TrafficLightsTest {
    @Test
    void checkTrafficLights(){
        TrafficLights trafficLights = new TrafficLights();
        assertEquals(true,trafficLights.isGreen());
    }
    @Test
    void checkRateOfChange(){
        TrafficLights trafficLights = new TrafficLights();
        assertEquals(0.0,0.0,trafficLights.getRateOfChange());
    }
}
