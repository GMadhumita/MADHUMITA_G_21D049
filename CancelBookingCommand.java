package SmartOffice;
public class CancelBookingCommand {
    private final int roomId;

    public CancelBookingCommand(int roomId) {
        this.roomId = roomId;
    }

    public String execute() {
        return BookingSystem.getInstance().cancelBooking(roomId);
    }
}
