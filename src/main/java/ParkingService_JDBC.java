import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkingService_JDBC {
    //insert values into table
    public static void insertParking_details(Driver driver){
        Connection connection=null;
        ArrayList<Driver> arr1=new ArrayList<>();
        try {
            connection = Sql_connection.getCon();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO  Driver VALUES(?,?,?,?)");
            ps.setInt(1,driver.getSlotNo());
            ps.setString(2,driver.getCarNo());
            ps.setString(3,driver.getName());
            ps.setString(4,driver.getInTime());
            ps.executeUpdate();
            parkCar(driver.getCarNo(),driver.getSlotNo());



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<List<String>> Display(){
        List<List<String>> arr2=new ArrayList<>();

        Connection connection=null;
        try {
            connection = Sql_connection.getCon();
            Statement ps1 = connection.createStatement();
            ResultSet resultSet = ps1.executeQuery("select * from Driver");
            while (resultSet.next()) {
                ArrayList<String> arr1=new ArrayList<>();
                int slot_id = resultSet.getInt("slotNo");
                String cab_no = resultSet.getNString("Car_No");
                String Name = resultSet.getNString("driverName");
                String inTime = resultSet.getNString("inTime");
                arr1.add(String.valueOf(slot_id));
                arr1.add(cab_no);
                arr1.add(Name);
                arr1.add(inTime);
                arr2.add(arr1);
            }
            return arr2;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    //delete the detail using a slot number
    public static void Delete(int soltNumber){
        Connection connection=null;
        try {
            connection=Sql_connection.getCon();
            PreparedStatement ps=connection.prepareStatement("delete from Driver where slotNo=?");
            ps.setInt(1, soltNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //number of slots parked
    public static int Total_slots(){
        Connection connection=null;
        try{
            connection=Sql_connection.getCon();
            PreparedStatement ps=connection.prepareStatement("SELECT COUNT(*) AS row_count FROM Driver ");
            ResultSet resultSet=ps.executeQuery();
            int rowcount = 0;
            if(resultSet.next()) {
                rowcount = resultSet.getInt("row_count");
                System.out.println("the total number of slots filled" + rowcount);
            }
            ParkingLot parkingLot=new ParkingLot(60);
            parkingLot.setAvailableSpaces(parkingLot.getCapacity()-rowcount);
            if (parkingLot.getAvailableSpaces()==0){
                System.out.println("The parkings are full");
            }
            else {
                System.out.println("The number of slots availabe:"+parkingLot.getAvailableSpaces());
            }
            return parkingLot.getAvailableSpaces();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //park a car
    public static void parkCar(String carNumber, int slotNo ) {
        Connection connection=null;
            try {
                connection = Sql_connection.getCon();
                PreparedStatement ps = connection.prepareStatement("INSERT INTO ParkedCars  VALUES (?, ?, NOW())");
                ps.setString(1, carNumber);
                ps.setInt(2, slotNo);
                ps.executeUpdate();
                System.out.println("Car parked successfully");
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    //find the car
    public static int FindTheCar(String name){
        Connection connection=null;
        try {
            connection=Sql_connection.getCon();
            PreparedStatement ps= connection.prepareStatement("select slotNo from ParkedCars  where carNo=?");
            ps.setString(1,name);
            ResultSet resultSet=ps.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt("slotNo");
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //find the time when car is parked
    public static String FindTheTime(String name){
        Connection connection=null;
        try {
            connection=Sql_connection.getCon();
            PreparedStatement ps= connection.prepareStatement("select * from ParkedCars  where carNo=?");
            ps.setString(1,name);
            ResultSet resultSet=ps.executeQuery();
            if(resultSet.next()){
                return String.valueOf(resultSet.getTime("inTime"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public static List<List<String>> DisplayParking_details(){
        List<List<String>> arr2=new ArrayList<>();

        Connection connection=null;
        try {
            connection = Sql_connection.getCon();
            Statement ps1 = connection.createStatement();
            ResultSet resultSet = ps1.executeQuery("select * from ParkedCars");
            while (resultSet.next()) {
                ArrayList<String> arr1=new ArrayList<>();
                int slot_id = resultSet.getInt("slotNo");
                String cab_no = resultSet.getNString("carNo");
                String inTime = resultSet.getNString("inTime");
                arr1.add(String.valueOf(slot_id));
                arr1.add(cab_no);
                arr1.add(inTime);
                arr2.add(arr1);
            }
            return arr2;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
    //insert in lot distribution table
    public static void lotDistributionTable(ParkingLot parkingLot){
        Connection connection=null;
        try {
            connection = Sql_connection.getCon();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO  ParkingLots VALUES(?,?,?,?)");
            ps.setInt(1,parkingLot.getLotId());
            ps.setString(2,parkingLot.getLot_name());
//            ps.setString(3,parkingLot.getCar_name());
//            ps.setString(4,parkingLot.getCar_no());
            ps.setInt(3,parkingLot.getCapacity());
            ps.setInt(4,parkingLot.getAvailableSpaces());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<List<String>> DisplayParkinglot_details() {
        List<List<String>> arr2 = new ArrayList<>();

        Connection connection = null;
        try {
            connection = Sql_connection.getCon();
            Statement ps1 = connection.createStatement();
            ResultSet resultSet = ps1.executeQuery("select * from ParkingLots ");
            while (resultSet.next()) {
                ArrayList<String> arr1 = new ArrayList<>();
                int lot= resultSet.getInt("lotId");
                String name=resultSet.getString("lot_name");
//                String car_name=resultSet.getString("car_name");
//                String car_no=resultSet.getNString("carNo");
               int capacity = resultSet.getInt("capacity");
                int available = resultSet.getInt("available");
                arr1.add(String.valueOf(lot));
                arr1.add(name);
//                arr1.add(car_name);
//                arr1.add(car_no);
                arr1.add(String.valueOf(capacity));
                arr1.add(String.valueOf(available));
                arr2.add(arr1);
            }
            return arr2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr2;
    }
}
