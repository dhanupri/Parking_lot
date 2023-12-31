interface parking_lot_details{
    public Object available_slots(int number_of_slots_parked);
}
public class ParkingLot implements  parking_lot_details {
    public int lotId;
    public String lot_name;
    public String car_name;
    public String car_no;
    public int capacity=60;
    public int availableSpaces;
    ParkingLot(int capacity){
        this.capacity=capacity;
        this.availableSpaces=capacity;
    }
    ParkingLot(int lotId,String lot_name,int capacity,int space){
        this.lotId=lotId;
        this.lot_name=lot_name;
//        this.car_name=car_name;
//        this.car_no=car_no;
        this.capacity=capacity;
        this.availableSpaces=space;
    }

    public String getCar_no() {
        return car_no;
    }

    public void setCar_no(String car_no) {
        this.car_no = car_no;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getLot_name() {
        return lot_name;
    }

    public void setLot_name(String lot_name) {
        this.lot_name = lot_name;
    }

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getAvailableSpaces() {
        return availableSpaces;
    }
    public void setAvailableSpaces(int availableSpaces) {
        this.availableSpaces = availableSpaces;
    }

    @Override
    public String available_slots(int number_of_slots_parked) {
        if(ParkingService_JDBC.Total_slots()!=0){
            System.out.println("Parking lot has space again");
            return "Parking lot has space again";
        }

        return null;
    }

}
