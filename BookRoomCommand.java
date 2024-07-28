package SmartOffice;
import java.time.LocalDateTime;

public class BookRoomCommand {
    private final int roomId;
    private final LocalDateTime startTime;
    private final int duration;

    public BookRoomCommand(int roomId, LocalDateTime startTime, int duration) {
        this.roomId = roomId;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String execute() {
        return BookingSystem.getInstance().bookRoom(roomId, startTime, duration);
    }
}


