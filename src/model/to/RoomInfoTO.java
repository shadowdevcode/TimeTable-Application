package model.to;

public class RoomInfoTO {
    private String RoomID , RoomName;

    public String getRoomID() {
        return RoomID;
    }

    public void setRoomID(String RoomID) {
        this.RoomID = RoomID;
    }

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String RoomName) {
        this.RoomName = RoomName;
    }

    public Integer getNoofChair() {
        return NoofChair;
    }

    public void setNoofChair(Integer NoofChair) {
        this.NoofChair = NoofChair;
    }
    private Integer NoofChair;
    
    public String toString(){
        return RoomName + " ( " + RoomID + " ) ";
    }
}
