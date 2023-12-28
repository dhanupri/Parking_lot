public class Driver {
    public String carNo;
    public String inTime;
    public String Name;
    public  int slotNo;
   Driver(int slotNo,String carNo,String Name,String inTime){
       this.carNo=carNo;
       this.Name=Name;
       this.inTime=inTime;
       this.slotNo=slotNo;
   }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }
}
