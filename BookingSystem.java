package SmartOffice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BookingSystem {
    private static BookingSystem instance;
    private final Map<Integer, Booking> bookings = new HashMap<>();

    private BookingSystem() {}

    public static BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    public String bookRoom(int roomId, LocalDateTime startTime, int duration) {
        Map<Integer, Room> rooms = OfficeConfiguration.getInstance().getRooms();
        if (!rooms.containsKey(roomId)) {
            return "Room " + roomId + " does not exist.";
        }

        Room room = rooms.get(roomId);
        LocalDateTime endTime = startTime.plusMinutes(duration);

        // Check if the room is already booked during the requested time
        if (room.getBookedUntil() != null && room.getBookedUntil().isAfter(LocalDateTime.now())) {
            return "Room " + roomId + " is already booked during this time. Cannot book.";
        }

        room.setBookedUntil(endTime);
        bookings.put(roomId, new Booking(roomId, startTime, endTime));
        System.out.println("Room " + roomId + " booked from " + startTime.toLocalTime() + " for " + duration + " minutes.");
        return "Booking successful.";
    }

    public String cancelBooking(int roomId) {
        Map<Integer, Room> rooms = OfficeConfiguration.getInstance().getRooms();
        if (!rooms.containsKey(roomId)) {
            return "Room " + roomId + " does not exist.";
        }

        if (!bookings.containsKey(roomId)) {
            return "Room " + roomId + " is not booked. Cannot cancel booking.";
        }

        bookings.remove(roomId);
        rooms.get(roomId).setBookedUntil(null);
        System.out.println("Booking for Room " + roomId + " cancelled successfully.");
        return "Cancellation successful.";
    }
}

       




