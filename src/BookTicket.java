import java.util.*;

public class BookTicket {
    static int id = 1;
    static Scanner s = new Scanner(System.in);
    static ArrayList<Integer> TicketID = new ArrayList<Integer>();
    static ArrayList<String> info = new ArrayList<String>();
    static ArrayList<Integer> Berth = new ArrayList<Integer>();
    private static  String name, gender;
    private static int age,berth;

    public static void bookticket() {

        System.out.print("Enter Your Name: ");
        name = s.nextLine();
        System.out.print("Enter your Age: ");
        age = s.nextInt();
        System.out.print("Enter your Gender: ");
        gender = s.next();
        System.out.print("Berth preference(1-Upper/2-Middle/3-Lower): ");
        berth = s.nextInt();
        s.nextLine();
        Validator();
    }

    private static void Validator() {

        if (age <= 5) {

            info.add("ID:Child" + "  Name: " + name + "  Age: " + age + "  Gender: " + gender + "  Berth: "+Berth);
            System.out.println("-->Sorry, children below 5 age are not Allowed.");

        } else {
            if (berth == 1 && App.upperberth > 0) {

                    System.out.println("-->Your ticket has been booked in Upper Berth, Your ID: "+id);
                    App.upperberth--;
                    info.add("ID:" + id + "  Name: " + name + "  Age: " + age + "  Gender: " + gender);
                    TicketID.add(id);
                    Berth.add(id++);
                    Berth.add(berth);

            } else if (berth == 2 && App.middleberth > 0) {
    
                    System.out.println("-->Your ticket has been booked in Middle Berth, Your ID: "+id);
                    App.middleberth--;
                    info.add("ID:" + id + "  Name: " + name + "  Age: " + age + "  Gender: " + gender);
                    TicketID.add(id);
                    Berth.add(id++);
                    Berth.add(berth);

            } else if (berth == 3 && App.lowerberth > 0) {

                    System.out.println("-->Your ticket has been booked in Lower Berth, Your ID: "+id);
                    App.lowerberth--;
                    info.add("ID:" + id + "  Name: " + name + "  Age: " + age + "  Gender: " + gender);
                    TicketID.add(id);
                    Berth.add(id++);
                    Berth.add(berth);

            } else checkavailability();
        }
    }

    private static void checkavailability() {

        if (App.upperberth > 0)
            System.out.println("Upper Berth is Available, Enter 1 to Book");
        else if (App.middleberth > 0)
            System.out.println("Middle Berth is Available, Enter 2 to Book");
        else if (App.lowerberth > 0)
            System.out.println("Lower Berth is Available, Enter 3 to Book");
        else if (App.upperberth + App.middleberth + App.lowerberth > 0) {
            berth = s.nextInt();
            Validator();
        } else
            RAC_waiting();
    }

    private static void RAC_waiting() {

        System.out.println("-->No Berth is Available");

        if (App.RAC > 0) {
            System.out.print("-->Are you wiiling to book RAC ticket(Yes/No): ");
            String c = s.nextLine();
            if (c.equalsIgnoreCase("yes")) {
                App.RAC--;
                info.add("Name: " + name + "  Age: " + age + "  Gender: " + gender);
                TicketID.add(id);
                Berth.add(id++);
                Berth.add(berth);
                System.out.println("-->Your ticket is Booked in RAC List, Your ID: "+id);
            } else
                System.out.println("*Thank you*");
        } else if (App.RAC == 0 && App.waitinglist > 0) {
            System.out.println("-->RAC Tickects also Over");
            System.out.println("-->Are willing to add your Ticket in waiting list(Yes/No):");
            String c = s.nextLine();
            if (c.equalsIgnoreCase("yes")) {
                App.waitinglist--;
                info.add("ID:" + id + "  Name: " + name + "  Age: " + age + "  Gender: " + gender);
                TicketID.add(id);
                Berth.add(id++);
                Berth.add(berth);
                System.out.println("Your  ticket is Booked in Waiting List, Your ID: "+id);
            } else
                System.out.println("*Thank you*");
        } else
            System.out.println("-->Tickets are not available :-(");
    }
    /////SHOW ALL THE BOOKED LIST
    public static void BookedList() {
        for (String i : info) {
            System.out.println(i + "\n");
        }
    }
}
