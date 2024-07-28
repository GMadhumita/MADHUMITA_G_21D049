package SmartOffice;
public class UpdateOccupancyCommand {
    private final int roomId;
    private final int peopleCount;

    public UpdateOccupancyCommand(int roomId, int peopleCount) {
        this.roomId = roomId;
        this.peopleCount = peopleCount;
    }

    public String execute() {
        RoomOccupancySensor sensor = RoomOccupancySensor.getInstance();
        return sensor.updateOccupancy(roomId, peopleCount);
    }
}


