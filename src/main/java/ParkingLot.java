interface parking_lot_details{
    public void available_slots(int number_of_slots_parked);
}
public class ParkingLot implements  parking_lot_details {
    public int capacity=60;
    public int availableSpaces;
    ParkingLot(int capacity){
        this.capacity=capacity;
        this.availableSpaces=capacity;
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
    public void available_slots(int number_of_slots_parked) {

    }
}
