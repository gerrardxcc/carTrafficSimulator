package CarTrafficSimulator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoadTest{
    @Test
    void checkConstructor(){
            Road road = new Road(10,1);
            assertEquals(10, road.getLength());
            assertEquals(1,road.getId());
    }
    @Test
    void checkNextRoad(){
        Road road = new Road(10,1);
        assertEquals(null, road.getNextRoad());
    }

}

