/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

public class testRun {

    public static void main(String[] args) {

//      Make Admin Array and create the main Admin
        Admin[] adminArray = new Admin[3];
        adminArray[0] = new Admin("1", "yamjason04@gmail.com", "0168962213", "1");
        //Create an array list for booking
        ArrayList<Booking> bookingArrList = new ArrayList<>();

        Scanner s1 = new Scanner(System.in);

        while (true) {
            //Main screen, select option
            System.out.print("Please Choose an Option\n"
                    + "1. Admin\n"
                    + "2. Attendee\n"
                    + "Enter your choice: ");
            int choice = s1.nextInt();
            while (choice != 1 && choice != 2) {

                System.out.print("\nInvalid choice!\n"
                        + "Enter a valid choice: ");
                choice = s1.nextInt();

            }
            s1.nextLine();
            switch (choice) {

                case 1: {

                    //Admin login screen
                    System.out.println("\n---Admin Login---");
                    System.out.print("Enter your name: ");
                    String name = s1.nextLine();
                    System.out.print("Enter your password: ");
                    String password = s1.nextLine();

                    // Iterate through the AdminArray
                    boolean loggedIn = false;
                    for (int i = 0; i < adminArray.length; i++) {
                        if (adminArray[i] != null && adminArray[i].getName() != null && adminArray[i].getPassword() != null
                                && adminArray[i].getName().equals(name) && adminArray[i].getPassword().equals(password)) {
                            loggedIn = true;
                            System.out.println("Login successful. Welcome, " + adminArray[i].getName() + "!");

                            //admin functions
                            boolean adminLoginStatus = true;
                            while (adminLoginStatus) {

                                System.out.print("\nPlease Choose an Option\n"
                                        + "1. Event Management\n"
                                        + "2. Exhibitor Profile Management\n"
                                        + "3. Analytics Report\n"
                                        + "4. Back\n"
                                        + "Enter your choice: "
                                );
                                int adminChoice = s1.nextInt();

                                while (adminChoice != 1 && adminChoice != 2 && adminChoice != 3 && adminChoice != 4) {
                                    System.out.print("\nInvalid choice!\n"
                                            + "Enter a valid choice: ");
                                    adminChoice = s1.nextInt();
                                }
                                s1.nextLine();
                                switch (adminChoice) {
                                    //event management
                                    case 1: {
                                        System.out.print("Please Choose an Option\n"
                                                + "1. Create Booking\n"
                                                + "2. Delete Booking\n"
                                                + "3. Update Booking\n"
                                                + "4. View Bookings\n"
                                                + "5. Back\n"
                                                + "Enter your choice: "
                                        );
                                        int EventChoice = s1.nextInt();

                                        while (EventChoice != 1 && EventChoice != 2 && EventChoice != 3 && EventChoice != 4 && EventChoice != 5) {
                                            System.out.println("Invalid choice!\n"
                                                    + "Enter a valid choice: ");
                                            EventChoice = s1.nextInt();
                                        }
                                        s1.nextLine();

                                        switch (EventChoice) {
                                            //Create Booking
                                            case 1: {
                                                //--------------------------Create Exhibitor

                                                //-Exhibitor name
                                                System.out.print("Enter Exhibitor Name: ");
                                                String exName = s1.nextLine();

                                                //-Email
                                                System.out.print("Enter Exhibitor Email: ");
                                                String exEmail = s1.nextLine();
                                                while (Person.vldEmail(exEmail) == false) {
                                                    System.out.print("Invalid address!\n"
                                                            + "Enter Exhibitor Email: ");
                                                    exEmail = s1.nextLine();
                                                }

                                                //-phoneNo
                                                System.out.print("Enter Phone Number: ");
                                                String phoneNo = s1.nextLine();
                                                while (Person.vldPhoneNumber(phoneNo) == false) {
                                                    System.out.print("Invalid Phone Number!\n"
                                                            + "Enter Phone Number: ");
                                                    phoneNo = s1.nextLine();
                                                }

                                                //-Input companyName
                                                System.out.print("Enter companyName: ");
                                                String companyName = s1.nextLine();

                                                //-Input IC
                                                System.out.print("Enter IC: ");
                                                String exIC = s1.nextLine();
                                                while (Exhibitor.vldIC(exIC) == false) {
                                                    System.out.print("Invalid IC!\n"
                                                            + "Enter IC: ");
                                                    exIC = s1.nextLine();
                                                }
                                                //-ArrayList<Product> products
                                                ArrayList<Product> productArrList = new ArrayList<>();
                                                System.out.print("Enter the number of products: ");
                                                int productNum = s1.nextInt();

                                                for (int j = 0; j < productNum; j++) {
                                                    s1.nextLine();
                                                    System.out.println("Enter product details for product " + (j + 1) + ":");
                                                    //prod name
                                                    System.out.print("Enter Product Name: ");
                                                    String prodName = s1.nextLine();
                                                    //prod desc
                                                    System.out.print("Enter Product Description: ");
                                                    String prodDesc = s1.nextLine();
                                                    //prod price
                                                    System.out.print("Enter Product Price: ");
                                                    double prodPrice = s1.nextDouble();

                                                    Product product = new Product(prodName, prodDesc, prodPrice);
                                                    productArrList.add(product);
                                                }

                                                //Invoke Exhibitor Constructor 
                                                Exhibitor exhibitor = new Exhibitor(companyName, exIC, productArrList, exName, exEmail, phoneNo);

                                                //------------------Create Event
                                                System.out.println("\nEnter Details About the Event");

                                                //-eventName
                                                System.out.print("Enter Event Name: ");
                                                String eventName = s1.nextLine();

                                                //-eventDate
                                                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                                                LocalDate currentDate = LocalDate.now();

                                                LocalDate eventDate = null;

                                                boolean isValidInput = false;

                                                while (!isValidInput) {
                                                    System.out.print("Enter Event Date (YYYY-MM-DD): ");
                                                    String dateInput = s1.nextLine();

                                                    try {
                                                        eventDate = LocalDate.parse(dateInput, dateFormatter);

                                                        // Check if the event date is at least 15 days in the future
                                                        long daysUntilEvent = ChronoUnit.DAYS.between(currentDate, eventDate);

                                                        if (daysUntilEvent >= 15) {
                                                            isValidInput = true;
                                                        } else {
                                                            System.out.println("Event date must be at least 15 days in the future.");
                                                        }
                                                    } catch (Exception e) {
                                                        System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                                                    }

                                                }

                                                //-eventTime
                                                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                                                LocalTime currentTime = LocalTime.now();
                                                LocalTime eventTime = null;
                                                isValidInput = false;

                                                while (!isValidInput) {
                                                    System.out.print("Enter Event Time (HH:mm): ");
                                                    String timeInput = s1.nextLine();

                                                    try {
                                                        eventTime = LocalTime.parse(timeInput, timeFormatter);
                                                        isValidInput = true;

                                                    } catch (Exception e) {
                                                        System.out.println("Invalid time format. Please use HH:mm.");
                                                    }
                                                }

                                                //-eventVenue
                                                venueType[] venues = venueType.values();
                                                System.out.println("\nVenue List:");
                                                for (int j = 0; j < venues.length; j++) {
                                                    System.out.println((j + 1) + ". " + venues[j]);
                                                }

                                                System.out.print("Enter Event Venue (1-" + venues.length + "): ");
                                                int eventVenueNum = s1.nextInt();
                                                while (vldIntInput(1, 3, eventVenueNum) == false) {
                                                    System.out.print("\nInvalid Input!\n"
                                                            + "Enter again: ");
                                                    eventVenueNum = s1.nextInt();
                                                }
                                                s1.nextLine();
                                                venueType venueType = venues[eventVenueNum - 1];

                                                //-decoration
                                                decorationType[] decoration = decorationType.values();
                                                System.out.println("\nDecoration List:");
                                                for (int k = 0; k < decoration.length; k++) {
                                                    System.out.println((k + 1) + ". " + decoration[k]);
                                                }

                                                System.out.print("Enter Event Decoration (1-" + decoration.length + "): ");
                                                int eventDecorationNum = s1.nextInt();
                                                while (vldIntInput(1, 3, eventVenueNum) == false) {
                                                    System.out.print("\nInvalid Input!\n"
                                                            + "Enter again: ");
                                                    eventDecorationNum = s1.nextInt();
                                                }
                                                s1.nextLine();
                                                decorationType decorationType = decoration[eventDecorationNum - 1];

                                                //-eventProducts ArrayList<Product> use = to do reference to the productArrList created when creating exhibitor
                                                ArrayList<Product> eventProduct = productArrList;

                                                //-participantArr: ArrayList<Participant>
                                                ArrayList<Participant> participantArrList = new ArrayList<>();
                                                
                                                //Invoke the event constructor
                                                Event event = new Event(eventName, eventDate, eventTime, venueType, decorationType, eventProduct, participantArrList);
                                                
                                                //Make Payment
                                                
                                                

                                                //Create the Booking
//                                                Booking booking = new Booking(exhibitor, event, payment);
//                                                bookingArrList.add(booking);

                                                break;

                                            }
                                            //Delete Booking
                                            case 2: {

                                                break;

                                            }
                                            //View Booking
                                            case 3: {

                                                break;

                                            }
                                            //Update Booking
                                            case 4: {

                                                break;

                                            }
                                            //Back
                                            case 5: {

                                            }
                                        }
                                        break;
                                    }
                                    //Exhibitor Profile Management
                                    case 2: {
                                        break;

                                    }
                                    //Analytics Report
                                    case 3: {
                                        break;
                                    }
                                    //Back, prompt to log out
                                    case 4: {
                                        s1.nextLine();
                                        System.out.print("Log out? (Y/N)");
                                        char adminLogout = s1.nextLine().charAt(0);
                                        while (adminLogout != 'Y' && adminLogout != 'N') {
                                            System.out.println("Invalid choice!\n"
                                                    + "Enter a valid choice: ");
                                            adminLogout = s1.nextLine().charAt(0);

                                        }
                                        if (adminLogout == 'Y') {
                                            adminLoginStatus = false;
                                        } else if (adminLogout == 'N') {
                                            // Do nothing if 'N' or 'n' is entered
                                        }
                                    }

                                }

                            }

                        }
                    }

                    if (!loggedIn) {
                        System.out.println("Login failed. Please check your email and password.");
                    }

                    break;

                }
                //attendee screen
                case 2: {

                    break;
                }

            }

        }

    }

    public static boolean vldIntInput(int min, int max, int input) {
        if (input > max || input < min) {
            return false;
        } else {
            return true;
        }
    }

}
