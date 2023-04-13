import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        //constant for fees
        final double CarRentalPrice = 29.99;
        final double tollTagPrice = 3.95;
        final double gpsPrice = 2.95;
        final double roadsideAssistanceRate = 3.95;
        final double underAge = 0.3;

        //get user inputs
        Scanner input = new Scanner(System.in);
        System.out.print("Enter pickup date (mm/dd/yyyy): ");
        String pickupday = input.nextLine();
        System.out.print("Enter number of rental days: ");
        int rentalDays = input.nextInt();
        input.nextLine(); //Question
        System.out.print("Do you want an electric toll tag? (y/n)? ");
        String tollTagInput = input.nextLine();
        boolean tolltag = tollTagInput.equals("y") || tollTagInput.equals("yes"); //Question
        System.out.print("Do you want a gps? (y/n)? ");
        String gpsInput = input.nextLine().toLowerCase();
        boolean gps = gpsInput.equals("y") || gpsInput.equals("yes");
        System.out.print("Do you want roadside assistance (y/n)? ");
        String roadsideassistanceInput = input.nextLine().toLowerCase();
        boolean roadsideassistance = roadsideassistanceInput.equals("y") || roadsideassistanceInput.equals("yes");
        System.out.print("Enter your Age: ");
        int age = input.nextInt();

        //Calculations
        double carRentalCosts = CarRentalPrice * rentalDays;
        double optionscost = 0.0;
        if (tolltag) {
            optionscost += tollTagPrice * rentalDays;
        }
        if (gps) {
            optionscost += gpsPrice * rentalDays;
        }
        if (roadsideassistance) {
            optionscost += roadsideAssistanceRate * rentalDays;
        }
        double underAgedriver = 0.0;
        if (age < 25) {
            underAgedriver = carRentalCosts * underAge;
        }
        double totalcost = carRentalCosts + optionscost + underAgedriver;


        System.out.println("\nRental Summary");
        System.out.println("--------------");
        System.out.println("Pickup date: " + pickupday);
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Car rental rate: $" + rentalDays + " per day");
        System.out.println("Options cost: $" + String.format("%.2f", optionscost));
        if (age < 25) {
            System.out.println("Underage driver surcharge: $" + String.format("%.2f", underAgedriver));
        }
        System.out.println("Total cost: $" + String.format("%.2f", totalcost));
    }
}
