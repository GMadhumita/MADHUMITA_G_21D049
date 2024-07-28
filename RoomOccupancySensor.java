package SmartOffice;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class RoomOccupancySensor {
    private static RoomOccupancySensor instance;
    private final List<RoomController> observers = new ArrayList<>();
    private final Map<Integer, Boolean> occupancy = new HashMap<>();

    private RoomOccupancySensor() {}

    public static RoomOccupancySensor getInstance() {
        if (instance == null) {
            instance = new RoomOccupancySensor();
        }
        return instance;
    }

    public void attach(RoomController observer) {
        observers.add(observer);
    }

    public void detach(RoomController observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int roomId, boolean occupied) {
        for (RoomController observer : observers) {
            observer.update(roomId, occupied);
        }
    }

    public String updateOccupancy(int roomId, int peopleCount) {
        Map<Integer, Room> rooms = OfficeConfiguration.getInstance().getRooms();
        if (!rooms.containsKey(roomId)) {
            return "Room " + roomId + " does not exist.";
        }

        boolean occupied = peopleCount >= 2;
        occupancy.put(roomId, occupied);
        notifyObservers(roomId, occupied);

        Room room = rooms.get(roomId);
        room.setOccupied(occupied);
        if (occupied) {
            System.out.println("Room " + roomId + " is now occupied by " + peopleCount + " persons. AC and lights turned on.");
        } else {
            System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
        }
        return "Occupancy updated.";
    }
}
