interface parking_lot_details{
    public Object available_slots(int number_of_slots_parked);
}
public class ParkingLot implements  parking_lot_details {
    public int lotId;
    public int capacity=60;
    public int availableSpaces;
    ParkingLot(int capacity){
        this.capacity=capacity;
        this.availableSpaces=capacity;
    }
    ParkingLot(int lotId,int capacity,int space){
        this.lotId=lotId;
        this.capacity=capacity;
        this.availableSpaces=space;
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
