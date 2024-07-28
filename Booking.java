package SmartOffice;
import java.time.LocalDateTime;

public class Booking {
    private final int roomId;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public Booking(int roomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}

