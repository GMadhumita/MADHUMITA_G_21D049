package SmartOffice;

import java.util.HashMap;
import java.util.Map;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private final Map<Integer, Room> rooms = new HashMap<>();

    private OfficeConfiguration() {}

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRoom(int roomId, int maxCapacity) {
        rooms.put(roomId, new Room(roomId, maxCapacity));
        System.out.println("Room " + roomId + " configured with capacity " + maxCapacity + ".");
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }
}


