import java.sql.*;
import java.util.ArrayList;

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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Integer> Display(){
        ArrayList<Integer> arr1=new ArrayList<>();
        Connection connection=null;
        try {
            connection = Sql_connection.getCon();
            Statement ps1 = connection.createStatement();
            ResultSet resultSet = ps1.executeQuery("select * from Driver");
            while (resultSet.next()) {
                int slot_id = resultSet.getInt("slotNo");
                String cab_no = resultSet.getNString("Cab_No");
                String Name = resultSet.getNString("driverName");
                String inTime = resultSet.getNString("inTime");
                Driver driver1 = new Driver(slot_id, cab_no, Name, inTime);
                arr1.add(slot_id);
            }
            return arr1;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return arr1;
    }

}
