import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingService_JDBC {
    public static void insertCab_details(Driver driver){
        Connection connection=null;
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
   
}
