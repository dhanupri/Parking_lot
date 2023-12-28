public class ParkingLot {
    public   int capacity;
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
}
