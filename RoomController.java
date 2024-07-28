package SmartOffice;
public class RoomController {
    public void update(int roomId, boolean occupied) {
        // This method should contain logic to turn on/off AC and lights
        if (occupied) {
            System.out.println("Turning on AC and lights for room " + roomId);
        } else {
            System.out.println("Turning off AC and lights for room " + roomId);
        }
    }
}
