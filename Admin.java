import model.*;
import service.SchoolService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SchoolService service = new SchoolService(scanner);

        printBanner();

        boolean appRunning = true;
        while (appRunning) {

            System.out.println("\n|======================================|");
            System.out.println("|     SCHOOL MANAGEMENT SYSTEM         |");
            System.out.println("|=======================================|");
            System.out.println("  [1] Login");
            System.out.println("  [0] Exit");
            System.out.print("  Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> {
                    System.out.print("  Email   : ");
                    String email = scanner.nextLine().trim();
                    System.out.print("  Password: ");
                    String password = scanner.nextLine().trim();

            
                    Person user = service.login(email, password);

                    if (user == null) {
                        System.out.println("  ✗ Invalid credentials. Try again.");
                    } else {
                        System.out.println("  ✓ Welcome, " + user.getName()
                                + " (" + user.getRole() + ")");

                    
                        if (user instanceof Admin)   service.runAdminMenu((Admin) user);
                        else if (user instanceof Teacher) service.runTeacherMenu((Teacher) user);
                        else if (user instanceof Student) service.runStudentMenu((Student) user);
                    }
                }
                case "0" -> {
                    System.out.println("\n  Goodbye! Thank you for using SMS.");
                    appRunning = false;
                }
                default -> System.out.println("  Invalid option.");
            }
        }

        scanner.close();
    }

    private static void printBanner() {
        System.out.println("|==============================================|");
        System.out.println("|                                              |");
        System.out.println("|    SCHOOL MANAGEMENT SYSTEM (SMS)            |");
        System.out.println("|                                              |");
        System.out.println("|==============================================|");
        System.out.println("| DEFAULT LOGIN CREDENTIALS                   |"); 
        System.out.println("| Admin  : admin@school.edu   / admin123      |");
        System.out.println("| Teacher: nadia@school.edu   / nadia123      |");
        System.out.println("| Student: ali@student.edu    / ali123        |");
        System.out.println("|==============================================|");
    }
}
