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
    //uc5-Availablity of slots
    @Test
    public void TestAvailablity_Parking_Lot(){
        List<List<String>> arr=new ArrayList<>();
        arr.add(List.of("2","Tn1236","deepakkumar","11:00pm"));
        ParkingLot parkingLot=new ParkingLot(60);
        AirportSecurity airportSecurity=new AirportSecurity();
        int available=parkingLot.getCapacity()-arr.size();
        if(available ==0){
            Assert.assertEquals("Parking lot is full. Redirecting security staff.",airportSecurity.update());
        }
        else {
            Assert.assertEquals(available,ParkingService_JDBC.Total_slots());
            Assert.assertEquals("Parking lot has space again",parkingLot.available_slots(arr.size()));
        }
    }
//   //uc-6 parkingAttendantTest
   @Test
    public  void parkingAttendantTest(){
        ArrayList<ArrayList<String>> arr=new ArrayList<>();
        ArrayList<String> arr1=new ArrayList();
       Driver driver=new Driver(1,"Tn1234","deepak","11:00pm");
       arr1.add(String.valueOf(driver.getSlotNo()));
       arr1.add(driver.getCarNo());
       arr1.add("2023-12-29 10:57:39");
       arr.add(arr1);
       ArrayList<String> arr2=new ArrayList<>();
       Driver driver1=new Driver(2,"Tn1236","deepakkumar","11:00pm");
       arr2.add(String.valueOf(driver1.getSlotNo()));
       arr2.add(driver1.getCarNo());
       arr2.add("2023-12-29 10:57:39");
       arr.add(arr2);
       Assert.assertEquals(arr,ParkingService_JDBC.DisplayParking_details());
    }
    //uc7 find the car in which slot
    @Test
    public  void TestToFindTheCar(){
        Assert.assertEquals(1,ParkingService_JDBC.FindTheCar("Tn1234"));
    }
    //uc8-car in time
    @Test
    public void TestCarInTime(){
        Assert.assertEquals("10:57:39",ParkingService_JDBC.FindTheTime("Tn1234"));
    }
    //uc9-lots distribution
    @Test
    public void TestLotsDistribution(){
        ParkingLot parkingLot=new ParkingLot(1,60,60);
        ParkingLot parkingLot1=new ParkingLot(2,30,30);
        ParkingLot parkingLot2=new ParkingLot(3,50,50);
        ParkingService_JDBC.lotDistributionTable(parkingLot);
        ParkingService_JDBC.lotDistributionTable(parkingLot1);
        ParkingService_JDBC.lotDistributionTable(parkingLot2);
        List<List<Integer>> arr=new ArrayList<>();
        arr.add( List.of(1,60,60));
        arr.add( List.of(2,30,30));
        arr.add( List.of(3,50,50));
        Assert.assertEquals(arr,ParkingService_JDBC.DisplayParkinglot_details());


    }

}
