import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot_AvailableSpaceTest {
    //uc1- check parking
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
    //uc2 -unpark
    @Test
    public void TestUnPark(){
        ParkingService_JDBC.Delete(1);
        List<List<String>> arr=new ArrayList<>();
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        Assert.assertEquals(arr,ParkingService_JDBC.Display());
    }
    //uc3 - check if parking is full
    @Test
    public  void  TestParkingFull(){
        List<List<String>> arr=new ArrayList<>();
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        ParkingLot parkingLot=new ParkingLot(60);
        int available=parkingLot.getCapacity()-arr.size();
        if(available ==0){
            Assert.assertEquals(0,ParkingService_JDBC.Total_slots());
        }
        else {
            Assert.assertEquals(available, ParkingService_JDBC.Total_slots());
        }
    }
    //uc4-redirect to airport staff
    @Test
    public void TestParkingFull_ToRedirectAirportStaff(){
        List<List<String>> arr=new ArrayList<>();
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        ParkingLot parkingLot=new ParkingLot(60);
        AirportSecurity airportSecurity=new AirportSecurity();
        int available=parkingLot.getCapacity()-arr.size();
        if(available ==0){
            Assert.assertEquals("Parking lot is full. Redirecting security staff.",airportSecurity.update());
        }
        else {
            Assert.assertEquals(available, ParkingService_JDBC.Total_slots());
        }

    }
}
