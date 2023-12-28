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
                String cab_no = resultSet.getNString("Cab_No");
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


}
