import java.util.ArrayList;
import java.util.Scanner;

public class FerretHealthReportGenerator {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<FerretBMI> list = new ArrayList<>();
        String cont = "Y";

        while (cont.equalsIgnoreCase("Y")) {
            // Name
            String name = "";
            while (name.trim().equals("")) {
                System.out.print("Enter the ferret's name: ");
                name = kb.nextLine();
                if (name.trim().equals("")) {
                    System.out.println("ERROR: NAME CAN NOT BE LEFT BLANK. TRY AGAIN.\n");
                }
            }

            // Length
            double length = 0;
            boolean valid = false;
            while (!valid) {
                System.out.print("Enter " + name + "'s length in inches (min: 2 inches - max: 24 inches): ");
                if (kb.hasNextDouble()) {
                    length = kb.nextDouble();
                    if (length < 2)
                        System.out.println("ERROR: LENGTH IS LESS THAN 2. TRY AGAIN.");
                    else if (length > 24)
                        System.out.println("ERROR: LENGTH IS GREATER THAN 24. TRY AGAIN.");
                    else valid = true;
                } else {
                    System.out.println("ERROR: INVALID INPUT. ENTER A NUMBER.");
                    kb.next();
                }
            }

            // Weight
            double weight = 0;
            valid = false;
            while (!valid) {
                System.out.print("Enter " + name + "'s weight in pounds (min: 0.01lb - max: 6.5 lb): ");
                if (kb.hasNextDouble()) {
                    weight = kb.nextDouble();
                    if (weight < 0.01)
                        System.out.println("ERROR: WEIGHT IS LESS THAN 0.01. TRY AGAIN.");
                    else if (weight > 6.5)
                        System.out.println("ERROR: WEIGHT IS GREATER THAN 6.5. TRY AGAIN.");
                    else valid = true;
                } else {
                    System.out.println("ERROR: INVALID INPUT. ENTER A NUMBER.");
                    kb.next();
                }
            }

            kb.nextLine(); // clear buffer

            // Gender
            System.out.println("\nGender:");
            System.out.println("1. Female");
            System.out.println("2. Male");
            int choice = 0;
            valid = false;
            while (!valid) {
                System.out.print("Select " + name + "'s gender (Enter 1 or 2): ");
                if (kb.hasNextInt()) {
                    choice = kb.nextInt();
                    kb.nextLine();
                    if (choice == 1 || choice == 2) valid = true;
                    else System.out.println("ERROR: MENU CHOICE MUST BE 1 OR 2. TRY AGAIN.");
                } else {
                    System.out.println("ERROR: INVALID INPUT. ENTER 1 OR 2.");
                    kb.nextLine();
                }
            }

            String gender = (choice == 1 ? "female" : "male");

            // Create objects
            Ferret f = new Ferret(name, length, weight, gender);
            FerretBMI fbmi = new FerretBMI(f);
            list.add(fbmi);

            System.out.print("\nDo you wish to enter information for another ferret (Y/N)?: ");
            cont = kb.nextLine();
            System.out.println();
        }

        // Print report
        System.out.println("\nFerret Health Report\n-----------------------------------\n");

        double totalBMI = 0;
        int uw = 0, h = 0, ow = 0;

        for (FerretBMI b : list) {
            System.out.println(b.toString() + "\n");
            totalBMI += b.calcBMI();

            String s = b.determineWeightStatus();
            if (s.equals("Underweight")) uw++;
            else if (s.equals("Healthy")) h++;
            else ow++;
        }

        System.out.println("Summary Report\n-----------------------------------");
        System.out.println("Total ferrets: " + Ferret.getFerretCount());
        System.out.println("Average BMI: " + String.format("%.2f", totalBMI / list.size()));

        System.out.println("\nFerret BMI Status Breakdown:\n");
        System.out.println("              Underweight: " + uw);
        System.out.println("              Healthy: " + h);
        System.out.println("              Overweight: " + ow);

        kb.close();
    }
}


