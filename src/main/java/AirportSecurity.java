interface Observer {
    Object update();
}
public class AirportSecurity implements Observer {
    @Override
    public Object update() {
        if(ParkingService_JDBC.Total_slots()==0){
            System.out.println("Parking lot is full. Redirecting security staff.");
            return "Parking lot is full. Redirecting security staff.";
        }
        return null;
    }
}
