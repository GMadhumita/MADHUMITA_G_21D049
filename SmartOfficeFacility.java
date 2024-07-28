package SmartOffice;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SmartOfficeFacility {
    public static void main(String[] args) {
        OfficeConfiguration officeConfig = OfficeConfiguration.getInstance();
        BookingSystem bookingSystem = BookingSystem.getInstance();
        RoomOccupancySensor sensor = RoomOccupancySensor.getInstance();
        RoomController controller = new RoomController();

        sensor.attach(controller);

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Configure Room");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Update Occupancy");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.println("Enter room ID:");
                    int roomId = scanner.nextInt();
                    System.out.println("Enter room capacity:");
                    int capacity = scanner.nextInt();
                    officeConfig.configureRoom(roomId, capacity);
                    break;

                case 2:
                    System.out.println("Enter room ID:");
                    roomId = scanner.nextInt();
                    System.out.println("Enter start time (HH:mm):");
                    String startTimeStr = scanner.next();
                    LocalTime localTime = LocalTime.parse(startTimeStr, formatter);
                    LocalDateTime startTime = LocalDateTime.now().with(localTime);
                    System.out.println("Enter duration in minutes:");
                    int duration = scanner.nextInt();
                    BookRoomCommand bookCommand = new BookRoomCommand(roomId, startTime, duration);
                    System.out.println(bookCommand.execute());
                    break;

                case 3:
                    System.out.println("Enter room ID:");
                    roomId = scanner.nextInt();
                    CancelBookingCommand cancelCommand = new CancelBookingCommand(roomId);
                    System.out.println(cancelCommand.execute());
                    break;

                case 4:
                    System.out.println("Enter room ID:");
                    roomId = scanner.nextInt();
                    System.out.println("Enter number of people:");
                    int peopleCount = scanner.nextInt();
                    UpdateOccupancyCommand updateOccupancyCommand = new UpdateOccupancyCommand(roomId, peopleCount);
                    System.out.println(updateOccupancyCommand.execute());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
               	


