import java.util.*;

public class CancelTicket {
    static Scanner s = new Scanner(System.in);

    public static void cancelticket() {

        System.out.println("Enter ticket ID:");
        int id = s.nextInt();

        if (BookTicket.TicketID.contains(id)) {
            if (App.RAC < 15 && BookTicket.TicketID.indexOf(id)<63) {
                int berthpreference = BookTicket.Berth.get(BookTicket.Berth.indexOf(id) + 1);
                BookTicket.Berth.set(64, berthpreference);
                App.RAC++;
            } else {
                int berthpreference = BookTicket.Berth.get(BookTicket.Berth.indexOf(id) + 1);
                if (berthpreference == 1)
                    App.upperberth++;
                else if (berthpreference == 2)
                    App.middleberth++;
                else if (berthpreference == 3)
                    App.lowerberth++;

            }
            BookTicket.TicketID.remove(BookTicket.TicketID.indexOf(id));
            System.out.println("Your Ticket is Successfully canceled");
        } else {
            System.out.println("Invalid Ticket ID.");
        }
    }
}
