package test;

import device.Device;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import other.House;
import other.Room;

import java.util.List;

import static org.junit.Assert.*;

public class HouseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void decode_json() {
        House house = House.getInstance();
        //House house1 = new House();
        //house1.create_house();
        //assertEquals(house,house1);
    }
}