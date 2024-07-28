package SmartOffice;

import java.time.LocalDateTime;

public class Room {
    private final int roomId;
    private final int capacity;
    private boolean occupied = false;
    private LocalDateTime bookedUntil = null;

    public Room(int roomId, int capacity) {
        this.roomId = roomId;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public LocalDateTime getBookedUntil() {
        return bookedUntil;
    }

    public void setBookedUntil(LocalDateTime bookedUntil) {
        this.bookedUntil = bookedUntil;
    }
}

