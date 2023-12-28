import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ParkingLot_AvailableSpaceTest {
    @Test
    public void TestParkingCheck(){
        ArrayList<Integer> arr=new ArrayList<>();
        Driver driver=new Driver(1,"Tn1234","deepak","11:00pm");
        Driver driver1=new Driver(2,"Tn1236","deepak","11:00pm");
        arr.add(driver.getSlotNo());
        arr.add(driver1.getSlotNo());
        ParkingService_JDBC.insertParking_details(driver);
        ParkingService_JDBC.insertParking_details(driver1);
        Assert.assertEquals(arr,ParkingService_JDBC.Display());
    }
}
