import java.util.*;

public class App {
    static Scanner s = new Scanner(System.in);
    static int upperberth = 21, middleberth = 21, lowerberth = 21, RAC = 15, waitinglist = 10;

    public static void main(String[] args) {
        Boolean bo = true;
        while (bo) {
            System.out.println("--------------------------------------------");
            System.out.println(
                    "1. Book  Ticket \n2. Cancel  Ticket \n3. Check Status \n4. Check Availabilty \n5. Booked List \n6.Enter 5 to Exit.");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    BookTicket.bookticket();
                    break;
                case 2:
                    CancelTicket.cancelticket();
                    break;
                case 3:
                    CheckStatus();
                    break;
                case 4:
                    CheckAvailability();
                    break;
                case 5:
                    BookTicket.BookedList();
                    break;
                case 6:
                    bo = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    ////Check Available Seats
    private static void CheckAvailability() {
        System.out.println("No of Upper Berth Available: "+ upperberth);
        System.out.println("No of Middle Berth Available: "+ middleberth);
        System.out.println("No of Lower Berth Available: "+ lowerberth);
    }

    ///Check Status
    public static void CheckStatus() {
        System.out.println("Enter your ID:");
        int userid = s.nextInt();
        if (BookTicket.TicketID.indexOf(userid) < 63 && BookTicket.TicketID.indexOf(userid) >= 0) {
            System.out.println("Your Ticket is Confirmed");
            System.out
                    .println("Your Berth Preference is :" + BookTicket.Berth.get(BookTicket.Berth.indexOf(userid) + 1));
        } else if (BookTicket.TicketID.indexOf(userid) >= 63 && BookTicket.TicketID.indexOf(userid) < 78) {
            System.out.println("Your Ticket is in RAC List ");
        } else if (BookTicket.TicketID.indexOf(userid) >= 78) {
            System.out.println("Your Ticket is in Waiting List");
        } else {
            System.out.println("User Id not found");
        }
    }
}