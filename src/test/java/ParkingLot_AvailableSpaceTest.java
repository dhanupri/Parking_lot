import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot_AvailableSpaceTest {
    @Test
    public void TestParkingCheck(){
        List<List<String>> arr=new ArrayList<>();
        Driver driver=new Driver(1,"Tn1234","deepak","11:00pm");
        Driver driver1=new Driver(2,"Tn1236","deepakkumar","11:00pm");
        arr.add(List.of("1","Tn1234","deepak","11:00pm"));
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        ParkingService_JDBC.insertParking_details(driver);
        ParkingService_JDBC.insertParking_details(driver1);
        Assert.assertEquals(arr,ParkingService_JDBC.Display());
    }
    @Test
    public void TestUnPark(){
        ParkingService_JDBC.Delete(1);
        List<List<String>> arr=new ArrayList<>();
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        Assert.assertEquals(arr,ParkingService_JDBC.Display());
    }
}
