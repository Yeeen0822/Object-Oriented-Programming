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
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testRun {

    public static void main(String[] args) {

//      Make Admin Array and create the main Admin
        Admin[] adminArray = new Admin[3];
        adminArray[0] = new Admin("1", "030822103842", "yamjason04@gmail.com", "0168962213", "1");
        //Create an array list for booking
        ArrayList<Booking> bookingArrList = new ArrayList<>();
        printAdminList(adminArray);
        Scanner s1 = new Scanner(System.in);

        while (true) {
            //Main screen, select option
            System.out.print("Please Choose an Option\n"
                    + "1. Admin\n"
                    + "2. Participant\n"
                    + "Enter your choice: ");
            int choice = s1.nextInt();
            while (choice != 1 && choice != 2) {
                s1.nextLine();
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

                                switch (adminChoice(s1)) {
                                    //Admin Profile Management
                                    case 1: {

                                        break;
                                    }
                                    //Event Management 
                                    case 2: {
                                        bookingManagement(bookingArrList, s1);
                                        break;
                                    }
                                    //Analytics Report
                                    case 3: {
                                        break;
                                    }
                                    //Back, prompt to log out
                                    case 4: {
                                        //will promp yes or no, will return either true or false
                                        adminLoginStatus = checkAdminLogout(s1);
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

    public static void bookingManagement(ArrayList<Booking> bookingArrList, Scanner s1) {

        System.out.print("\nPlease Choose an Option\n"
                + "1. Create Event Booking\n"
                + "2. Update Event Booking\n"
                + "3. View Event Booking\n"
                + "4. Search Event Booking\n"
                + "5. Pay Unpaid Booking\n"
                + "6. Cancel Event Booking\n"
                + "7. View Event\n"
                + "8. Search Event\n"
                + "9. Back\n"
                + "Enter your choice: "
        );
        int EventChoice = s1.nextInt();

        while (vldIntInput(1, 9, EventChoice) == false) {
            System.out.print("\nInvalid choice!\n"
                    + "Enter a valid choice: ");
            EventChoice = s1.nextInt();
        }
        s1.nextLine();

        //switch to event screen
        switch (EventChoice) {
            //-----------------------------Create Event Booking-----------------------------------
            case 1: {
                //--------------------------Create Organizer------------------------------------------

                //-Organizer name
                System.out.print("\nEnter Organizer Name: ");
                String organizerName = s1.nextLine();

                //-Email
                System.out.print("Enter Organizer Email: ");
                String organizerEmail = s1.nextLine();
                while (Person.vldEmail(organizerEmail) == false) {
                    System.out.print("Invalid address!\n"
                            + "Enter Organizer Email: ");
                    organizerEmail = s1.nextLine();
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
                String organizerIC = s1.nextLine();
                while (Organizer.vldIC(organizerIC) == false) {
                    System.out.print("Invalid IC!\n"
                            + "Enter IC: ");
                    organizerIC = s1.nextLine();
                }

                //Invoke organizer Constructor 
                Organizer organizer = new Organizer(companyName, organizerIC, organizerName, organizerEmail, phoneNo);

                //------------------Create Event--------------------------
                System.out.println("\nEvent Type:\n"
                        + "1.Phone Event\n"
                        + "2.Car Event");
                System.out.print("Enter an option (1-2): ");
                int eventOption = s1.nextInt();
                while (vldIntInput(1, 2, eventOption) == false) {
                    System.out.print("\nInvalid Input!\n"
                            + "Enter again: ");
                    eventOption = s1.nextInt();
                }
                s1.nextLine();

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
                while (vldIntInput(1, venues.length, eventVenueNum) == false) {
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
                while (vldIntInput(1, decoration.length, eventDecorationNum) == false) {
                    System.out.print("\nInvalid Input!\n"
                            + "Enter again: ");
                    eventDecorationNum = s1.nextInt();
                }
                s1.nextLine();
                decorationType decorationType = decoration[eventDecorationNum - 1];

                //-num of promoter
                System.out.print("\nEnter number of promoters: ");
                int promoterNum = s1.nextInt();
                s1.nextLine();

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
                s1.nextLine();

                //Invoke the event constructor
                Event event = new Event(eventName, eventDate, eventTime, venueType, decorationType, promoterNum, productArrList);

                //Make Payment
                System.out.print("\nTotal: " + event.getFees()
                        + "\nPayment Options:\n"
                        + "1. Card\n"
                        + "2. Cash\n"
                        + "Select a Payment Option (1-2): ");
                int paymentNum = s1.nextInt();
                while (vldIntInput(1, 2, paymentNum) == false) {
                    System.out.print("\nInvalid Input!\n"
                            + "Enter again: ");
                    paymentNum = s1.nextInt();
                }
                s1.nextLine();

                //paymentAmount = event object's price
                //Create Card object if paymentNum = 1, 2 for cash
                if (paymentNum == 1) {

                    //cardNum
                    System.out.print("\nEnter Card Number: ");
                    String cardNum = s1.nextLine();

                    //cardHolder
                    System.out.print("Enter Card Holder Name: ");
                    String cardHolder = s1.nextLine();

                    //cardExp
                    System.out.print("Enter Card Expiry Date: ");
                    String cardExp = s1.nextLine();
                    while (Card.vldCardExp(cardExp) == false) {
                        System.out.print("Invalid Card Expiry Date!\n"
                                + "Enter Card Expiry Date: ");
                        cardExp = s1.nextLine();
                    }

                    //cardCVV
                    System.out.print("Enter Card CVV: ");
                    String cardCVV = s1.nextLine();
                    while (Card.vldCardCvv(cardCVV) == false) {
                        System.out.print("Invalid Card CVV!\n"
                                + "Enter Card CVV: ");
                        cardCVV = s1.nextLine();
                    }
                    //Create Payment Object
                    Card payment = new Card(cardNum, cardHolder, cardExp, cardCVV, event.getFees());

                    //confirm payment
                    System.out.print("\nPayment Received? (Y/N): ");
                    char paymentCheck = s1.nextLine().charAt(0);
                    while (paymentCheck != 'Y' && paymentCheck != 'N') {
                        System.out.println("\nInvalid choice!\n"
                                + "Enter a valid choice: ");
                        paymentCheck = s1.nextLine().charAt(0);

                    }

                    //Update payment status, if paid, payment object's attribute "paid" will be true
                    if (paymentCheck == 'Y') {
                        payment.makePayment();

                    } else if (paymentCheck == 'N') {
                        //payment not paid, need to deduct event price from totalrevenue cuz event price 
                        //will get added  to totalRevenue automatically when event object is created
                        payment.pendingPayment();
                        Event.deductTotalRevenue(event.getFees());

                    }

                    //Create the booking for Card payment
                    Booking booking = new Booking(organizer, event, payment);
                    //Add the Booking to booking array list
                    bookingArrList.add(booking);

                } else {

                    //amount tendered
                    System.out.print("\nEnter amount tendered: ");
                    double amountTendered = s1.nextDouble();

                    //validate amount tendered (only accept >= event.getPrice() or 0) 0 means not yet paid
                    while ((amountTendered < event.getFees() && amountTendered > 0) || amountTendered < 0) {
                        s1.nextLine();
                        System.out.print("\nInvalid input!\n"
                                + "Enter amount tendered: ");
                        amountTendered = s1.nextDouble();

                    }
                    s1.nextLine();
                    //create cash object
                    Cash payment = new Cash(amountTendered, event.getFees());

                    //if amount tendered >= event.getPrice(), make the paid = true, if 0 = paid = false
                    if (amountTendered == 0) {
                        payment.pendingPayment();
                        //payment not paid, need to deduct event price from totalrevenue cuz event price 
                        //will get added  to totalRevenue automatically when event object is created

                        Event.deductTotalRevenue(event.getFees());
                        System.out.println("Payment Not Received.");

                    } else {
                        payment.makePayment();
                        //Display changeAmount                                                  
                        System.out.println("Change Amount: " + payment.getChangeAmount());
                    }

                    //create the booking for cash payment
                    Booking booking = new Booking(organizer, event, payment);
                    //Add the Booking to booking array list
                    bookingArrList.add(booking);

                }

                break;

            }
            //--------------------------Update event booking-------------------------------
            case 2: {
                viewBookings(bookingArrList);

                System.out.println("\n\nSelect which event booking to update");
                System.out.print("Enter Booking ID (999 to exit): ");
                int bookingID = s1.nextInt();
                if (bookingID == 999) {
                    break;
                }

                boolean validBookingID = false;

                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingID == bookingArrList.get(j).getBookingNum()) {
                        validBookingID = true;
                        boolean status = true;
                        boolean isValidInput = false;
                        do {
                            System.out.print("\nPlease Choose an Option\n"
                                    + "1. Update Event Name\n"
                                    + "2. Update Event Date\n"
                                    + "3. Update Event Time\n"
                                    + "4. Search Event Products\n"
                                    + "5. Back\n"
                                    + "Enter your choice: "
                            );
                            int updateChoice = s1.nextInt();

                            while (vldIntInput(1, 5, updateChoice) == false) {
                                s1.nextLine();
                                System.out.print("\nInvalid choice!\n"
                                        + "Enter a valid choice: ");
                                updateChoice = s1.nextInt();
                            }
                            s1.nextLine();
                            switch (updateChoice) {
                                // 1: update event name
                                case 1: {
                                    System.out.print("Enter Event Name: ");
                                    String name = s1.nextLine();
                                    bookingArrList.get(j).getEvent().setEventName(name);
                                    System.out.println("Update Successfully!");

                                    break;
                                }
                                // 2: update event date
                                case 2: {
                                    //-eventDate
                                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                                    LocalDate currentDate = LocalDate.now();

                                    LocalDate eventDate = null;

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
                                    bookingArrList.get(j).getEvent().setEventDate(eventDate);

                                    break;
                                }
                                // 3: update event time
                                case 3: {
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

                                    bookingArrList.get(j).getEvent().setEventTime(eventTime);
                                    break;
                                }
                                // 4: update event products
                                case 4: {

                                    break;
                                }
                                // 5: back
                                case 5: {
                                    break;

                                }

                            }
                            if (updateChoice == 5) {
                                status = false;
                            }

                        } while (status);

                    }

                }
                if (validBookingID == false) {
                    System.out.println("Invalid booking ID or the booking has been paid!");
                }
                break;

            }
            //--------------------------Update event booking ENDS-------------------------------

            //----------------------------View Booking----------------------------------------
            case 3: {
                viewBookings(bookingArrList);

                break;

            }
            //----------------------Search Booking-----------------------------------------------
            case 4: {

            }
            //------------------------------------------pay unpaid booking---------------------------------------
            case 5: {

                System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");

                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Pending")) {
                        System.out.println(bookingArrList.get(j));
                    }

                }
                System.out.println("\n\nSelect which booking to pay");
                System.out.print("Enter Booking ID (999 to exit): ");
                int bookingID = s1.nextInt();
                if (bookingID == 999) {
                    break;
                }
                boolean validBookingID = false;

                //-------------------------------DO PAYMENT FOR UNPAID BOOKING HERE-----------------------------------------
                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingID == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus() == "Pending") {

                        //Make Payment
                        System.out.print(
                                "\nTotal: RM" + bookingArrList.get(j).getEvent().getFees()
                                + "\nPayment Options:\n"
                                + "1. Card\n"
                                + "2. Cash\n"
                                + "Select a Payment Option (1-2): ");
                        int paymentNum = s1.nextInt();
                        while (vldIntInput(1, 2, paymentNum) == false) {
                            System.out.print("\nInvalid Input!\n"
                                    + "Enter again: ");
                            paymentNum = s1.nextInt();
                        }
                        s1.nextLine();

                        if (paymentNum == 1) {

                            //cardNum
                            System.out.print("\nEnter Card Number: ");
                            String cardNum = s1.nextLine();

                            //cardHolder
                            System.out.print("Enter Card Holder Name: ");
                            String cardHolder = s1.nextLine();

                            //cardExp
                            System.out.print("Enter Card Expiry Date: ");
                            String cardExp = s1.nextLine();
                            while (Card.vldCardExp(cardExp) == false) {
                                System.out.print("Invalid Card Expiry Date!\n"
                                        + "Enter Card Expiry Date: ");
                                cardExp = s1.nextLine();
                            }

                            //cardCVV
                            System.out.print("Enter Card CVV: ");
                            String cardCVV = s1.nextLine();
                            while (Card.vldCardCvv(cardCVV) == false) {
                                System.out.print("Invalid Card CVV!\n"
                                        + "Enter Card CVV: ");
                                cardCVV = s1.nextLine();
                            }

                            //confirm payment
                            System.out.print("\nPayment Received? (Y/N): ");
                            char paymentCheck = s1.nextLine().charAt(0);
                            while (paymentCheck != 'Y' && paymentCheck != 'N') {
                                System.out.println("\nInvalid choice!\n"
                                        + "Enter a valid choice: ");
                                paymentCheck = s1.nextLine().charAt(0);

                            }
                            //Create Payment Object
                            Card payment = new Card(cardNum, cardHolder, cardExp, cardCVV, bookingArrList.get(j).getEvent().getFees());

                            //Update payment status, if paid, payment object's attribute "paid" will be true
                            if (paymentCheck == 'Y') {

                                payment.makePayment();
                                //since the booking is paid, need to add the event price to totalRevenue
                                Event.addTotalRevenue(bookingArrList.get(j).getEvent().getFees());

                            } else if (paymentCheck == 'N') {
                                payment.pendingPayment();
                            }
                            bookingArrList.get(j).setPaymentMethod(payment);

                        } else {

                            //amount tendered
                            System.out.print("\nEnter amount tendered: ");
                            double amountTendered = s1.nextDouble();

                            //validate amount tendered (only accept >= event.getPrice() or 0) 0 means not yet paid
                            while ((amountTendered < bookingArrList.get(j).getEvent().getFees() && amountTendered > 0) || amountTendered < 0) {
                                s1.nextLine();
                                System.out.print("\nInvalid input!\n"
                                        + "Enter amount tendered: ");
                                amountTendered = s1.nextDouble();

                            }
                            s1.nextLine();

                            //if amount tendered >= event.getPrice(), make the paid, if 0 = pending
                            if (amountTendered == 0) {
                                bookingArrList.get(j).getPaymentMethod().pendingPayment();
                                System.out.println("Payment Not Received.");

                            } else {
                                //create a new cash object and assign to booking's payment
                                Cash cash = new Cash(amountTendered, bookingArrList.get(j).getEvent().getFees());
                                cash.makePayment();
                                System.out.println("Change Amount: " + cash.getChangeAmount());
                                bookingArrList.get(j).setPaymentMethod(cash);
                                //since the booking is paid, need to add the event price to totalRevenue
                                Event.addTotalRevenue(bookingArrList.get(j).getEvent().getFees());

                            }

                        }
                        validBookingID = true;

                    }

                }
                if (validBookingID == false) {
                    System.out.println("Invalid booking ID or the booking has been paid!");
                }

                break;

            }

            //---------------------------------------Cancel Booking---------------------------------------------------
            //refund 50%, total revenue -50% of event.getprice()
            //if payment pending, do not refund
            case 6: {
                //show all bookings except bookings that have Cancelled paymentStatus
                System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");

                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {
                        System.out.println(bookingArrList.get(j));

                    }

                }
                System.out.println("\n\nSelect which booking to cancel");
                System.out.print("Enter Booking ID: ");
                int bookingID = s1.nextInt();
                boolean validBookingID = false;
                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingID == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {

                        //display the amount to refund
                        if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Paid") == true) {
                            System.out.println("Amount to refund: " + bookingArrList.get(j).getEvent().getFees() * 0.5);
                        }

                        //make payment status = cancelled
                        bookingArrList.get(j).getPaymentMethod().cancelPayment();

                        //deduct totalRevenue with 50% of event price and refund the other 50% 
                        Event.deductTotalRevenue(bookingArrList.get(j).getEvent().getFees() * 0.5);

                        validBookingID = true;

                    }

                }
                if (validBookingID == false) {
                    System.out.println("Invalid booking ID or the booking has been paid!");
                }

                break;

            }
            //------------------View all Event---------------------
            case 7: {

                break;
            }

            //---------------------Search Event---------------------
            case 8: {

                break;
            }
            //---------------------Back------------------------
            case 9: {

            }
        }

    }

    public static boolean checkAdminLogout(Scanner s1) {
        System.out.print("Log out? (Y/N)");

        char adminLogout = Character.toUpperCase(s1.nextLine().charAt(0));
        while (adminLogout != 'Y' && adminLogout != 'N') {
            System.out.println("Invalid choice!\n"
                    + "Enter a valid choice: ");
            adminLogout = Character.toUpperCase(s1.nextLine().charAt(0));
            System.out.println(adminLogout);

        }
        if (adminLogout == 'Y') {
            return false;
        } else {

            return true;
        }
    }

    public static int adminChoice(Scanner s1) {

        System.out.print("\nPlease Choose an Option\n"
                + "1. Admin Profile Management\n"
                + "2. Event Management\n"
                + "3. Analytics Report\n"
                + "4. Back\n"
                + "Enter your choice: "
        );
        int adminChoice = s1.nextInt();

        //validate admin input
        while (vldIntInput(1, 4, adminChoice) == false) {
            s1.nextLine();
            System.out.print("\nInvalid choice!\n"
                    + "Enter a valid choice: ");
            adminChoice = s1.nextInt();
        }
        s1.nextLine();
        return adminChoice;

    }

    public static boolean vldIntInput(int min, int max, int input) {
        if (input > max || input < min) {
            return false;
        } else {
            return true;
        }
    }

    public static void printAdminList(Admin[] adminArray) {
        System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", "Admin ID", "Name", "IC", "Phone Number", "Email");

        for (Admin adminprint : adminArray) {
            System.out.println(adminprint);
        }
    }

    public static void viewBookings(ArrayList<Booking> bookingArrList) {

        System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");
        for (int j = 0; j < bookingArrList.size(); j++) {
            System.out.println(bookingArrList.get(j));

        }
        System.out.println("");

    }
    
    
    public static void printAdminList(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {

        if (loggedInAdmin != 0) {
            System.out.println("\n---------------------------------");
            System.out.println("You are not admin manager.");
            System.out.println("You dont have this priviledge.");
            System.out.println("---------------------------------");
            adminProfileMenu(adminArray, loggedInAdmin);
        }
        
        System.out.println("                                           Admins' Profiles                                                    ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-20s%-15s%-30s%-15s\n", "Admin ID", "Name", "IC", "Email", "Phone Number");
        for (int i = 0; i < adminArray.size(); i++) {
            System.out.printf("%-10s%-20s%-15s%-30s%-15s\n", adminArray.get(i).getAdminID(), adminArray.get(i).getName(), adminArray.get(i).getIC(), adminArray.get(i).getEmail(), adminArray.get(i).getPhoneNo());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        adminProfileMenu(adminArray,loggedInAdmin);
    }

    private static void menu(ArrayList<Admin> adminArray) throws InterruptedException {
        boolean optionVld = true;
        int loginOrForgot;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n1. Login");
            System.out.println("2. Forgot Password");
            System.out.println("3. Back");

            System.out.print("Selection: ");
            try {
                loginOrForgot = sc.nextInt();

                switch (loginOrForgot) {
                    case 1:
                        adminLogin(adminArray);
                        break;
                    case 2:
                        forgotPassword(adminArray);
                        break;
                    case 3:
                        //TO be put  main menu 
                        System.exit(0);
                    default:
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");

                }
            } catch (InputMismatchException inputMismatchException) {
                optionVld = false;
                System.out.println("Please Enter Only Integer.");
                sc.nextLine();
            }
        } while (!optionVld);
    }

    public static void adminLogin(ArrayList<Admin> adminArray) throws InterruptedException {
        int loggedInAdmin = 0;
        String adminInputAdminID;
        String adminInputPassword;
        boolean loginSuccess = false;
        Scanner sc = new Scanner(System.in);
        int loginCount = 0;

        do {
            System.out.println();
            System.out.print("Enter Admin ID: ");
            adminInputAdminID = sc.next();
            System.out.print("Enter Admin Password: ");
            adminInputPassword = sc.next();
            loginCount++;
            for (int i = 0; i < adminArray.size(); i++) {
                if (adminArray.get(i).getAdminID().equals(adminInputAdminID) && adminArray.get(i).getPassword().equals(adminInputPassword)) {
                    loginSuccess = true;
                    loggedInAdmin = i;
                    break;
                }

            }
            if (loginSuccess) {
                System.out.println("Login Successfully");
                adminMenu(adminArray, loggedInAdmin);
            } else if (loginSuccess == false && loginCount >= 3) {
                System.out.println("Wrong Credentials.Auto exit");
                menu(adminArray);
                System.exit(0);
            } else {
                System.out.println("Wrong Credentials, Please Try Again.");
            }

        } while (!loginSuccess);
    }

    public static void adminMenu(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int selection;
        boolean optionVld = true;

        do {
            System.out.printf("\n%55s", "+------------------+");
            System.out.printf("%n%55s", "|    Admin Menu    |");
            System.out.printf("%n%55s%n", "+------------------+");
            System.out.println("Currently Logged In As Admin: " + adminArray.get(loggedInAdmin).getName());
            System.out.println("Admin ID: " + adminArray.get(loggedInAdmin).getAdminID());
            System.out.println();

            System.out.println("[1] Admin Profile Management");
            System.out.println("[2] Event Management");
            System.out.println("[3] Analytics");
            System.out.println("[4] Sign Out");
            System.out.println("[5]Exit");

            System.out.print("Selection: ");
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
                switch (selection) {
                    case 1:
                        adminProfileMenu(adminArray, loggedInAdmin);
                        break;
                    case 2:
                        System.out.println("Event Management");
                        break;
                    case 3:
                        System.out.println("Analytics");
                        break;

                    case 4:
                        System.out.println("You Are Signed Out.");
                        menu(adminArray);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");
                }
            } catch (InputMismatchException inputMismatchException) {
                optionVld = false;
                System.out.println("Please Enter Only Integer.");
                scanner.nextLine();
            }
        } while (!optionVld);

    }

    public static void adminProfileMenu(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int selection;
        boolean optionVld = true;

        do {

            System.out.println("\n[1] View your profile");
            System.out.println("[2] Update your profile");
            System.out.println("[3] Register new admin's profile (Manager priviledge)");
            System.out.println("[4] View all admins' profiles (Manager priviledge)");
            System.out.println("[5] Back");

            System.out.print("Selection: ");
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
                switch (selection) {
                    case 1:
                        viewProfile(adminArray, loggedInAdmin);
                        break;
                    case 2:
                        updateAdminMenu(adminArray, loggedInAdmin);
                        break;
                    case 3:
                        adminRegister(adminArray, loggedInAdmin);
                        break;
                    case 4:
                        printAdminList(adminArray, loggedInAdmin);
                        break;
                    case 5:
                        adminMenu(adminArray, loggedInAdmin);
                    default:
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");
                }
            } catch (InputMismatchException inputMismatchException) {
                optionVld = false;
                System.out.println("Please Enter Only Integer.\n");
                scanner.nextLine();
            }
        } while (!optionVld);

    }

    public static void viewProfile(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        char selection;
        char selectionUpper;
        boolean optionVld = true;
        System.out.println("\n\t\t\t\t\t\tAdmin Profile\t\t\t\t");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-25s%-15s%-25s%-15s\n", "Admin ID", "Name", "IC", "Email", "Phone No");
        System.out.printf("%-10s%-25s%-15s%-25s%-15s\n", adminArray.get(loggedInAdmin).getAdminID(), adminArray.get(loggedInAdmin).getName(), adminArray.get(loggedInAdmin).getIC(), adminArray.get(loggedInAdmin).getEmail(), adminArray.get(loggedInAdmin).getPhoneNo());
        System.out.println("----------------------------------------------------------------------------------------------------------");

        adminProfileMenu(adminArray, loggedInAdmin);
    }

    public static void updateAdminMenu(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int selection;
        boolean optionVld = true;

        do {

            System.out.println("\n[1] Update Phone No");
            System.out.println("[2] Update Email");
            System.out.println("[3] Back");

            System.out.print("Selection: ");
            try {
                selection = scanner.nextInt();
                scanner.nextLine();
                switch (selection) {
                    case 1:
                        updatePhoneNo(adminArray, loggedInAdmin);
                        break;
                    case 2:
                        updateEmail(adminArray, loggedInAdmin);
                        break;
                    case 3:
                        adminProfileMenu(adminArray, loggedInAdmin);
                        break;
                    default:
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");
                }
            } catch (InputMismatchException inputMismatchException) {
                optionVld = false;
                System.out.println("Please Enter Only Integer.\n");
                scanner.nextLine();
            }
        } while (!optionVld);
    }

    public static void updateEmail(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {
        System.out.println("Your original email :" + adminArray.get(loggedInAdmin).getEmail());
        System.out.print("Enter new email:");
        Scanner sc = new Scanner(System.in);
        String newEmail = sc.nextLine();

        while (Person.vldEmail(newEmail) == false) {
            System.out.print("Invalid Email!");
            System.out.print("Please enter a valid Email:");
            newEmail = sc.nextLine();
        }
        adminArray.get(loggedInAdmin).setEmail(newEmail);
        System.out.println("Update Email Successfully.");
        updateAdminMenu(adminArray, loggedInAdmin);

    }

    public static void updatePhoneNo(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {
        System.out.println("\nYour original phone number :" + adminArray.get(loggedInAdmin).getPhoneNo());
        System.out.print("Enter new phone number:");
        Scanner sc = new Scanner(System.in);
        String newPhoneNo = sc.nextLine();

        while (Person.vldPhoneNumber(newPhoneNo) == false) {
            System.out.print("Invalid! Phone Number must be starting with \"01\" followed by 8 digits");
            System.out.print("Please enter a valid phone number");
            newPhoneNo = sc.nextLine();
        }
        adminArray.get(loggedInAdmin).setPhoneNo(newPhoneNo);
        System.out.println("Update Phone Number Successfully.");
        updateAdminMenu(adminArray, loggedInAdmin);

    }

    public static void adminRegister(ArrayList<Admin> adminArray, int loggedInAdmin) throws InterruptedException {
        boolean icValid = false, emailValid = false, passwordValid = false, phoneNoValid = false, confirmPwVld = false;
        String adminName, adminIC, adminEmail, adminPassword, adminPhoneNo, adminPwConfirm;
        Scanner scanner = new Scanner(System.in);

        if (loggedInAdmin != 0) {
            System.out.println("\n---------------------------------");
            System.out.println("You are not admin manager.");
            System.out.println("You dont have this priviledge.");
            System.out.println("---------------------------------");
            adminProfileMenu(adminArray, loggedInAdmin);
        }
        System.out.println("\n----------------------");
        System.out.println("New Admin Registration");
        System.out.println("----------------------\n");
        System.out.print("Enter new admin's name: ");
        adminName = scanner.nextLine();

        do {
            System.out.print("Enter new admin's IC (eg:030922101245) : ");
            adminIC = scanner.nextLine();
            if (Person.vldIC(adminIC)) {
                icValid = true;
            } else {
                System.out.println("Please Enter A Valid IC.");
                System.out.println();
            }
        } while (!icValid);

        do {
            System.out.print("Enter new admin's Email: ");
            adminEmail = scanner.next();
            scanner.nextLine();
            if (Person.vldEmail(adminEmail)) {
                emailValid = true;
            } else {
                System.out.println("Please Enter A Valid Email.");
                System.out.println();
            }
        } while (!emailValid);

        do {
            System.out.print("Enter new admin's phone number eg:0123456789: ");
            adminPhoneNo = scanner.nextLine();

            if (Person.vldPhoneNumber(adminPhoneNo)) {
                phoneNoValid = true;
            } else {
                System.out.println("Phone Number must be starting with \"01\" followed by 8 digits ");
                System.out.println();
            }
        } while (!phoneNoValid);

        System.out.println("\n--------------------------");
        System.out.println("Assigned Admin ID :A" + Admin.getAdminCount());
        System.out.println("--------------------------\n");

        do {
            System.out.print("Enter new admin's password: ");
            adminPassword = scanner.nextLine();

            if (Admin.vldPassword(adminPassword)) {
                passwordValid = true;
            } else {
                System.out.println("Password Must Include Alphabet, Number and At Least 6 Characters.");
                System.out.println();
            }
        } while (!passwordValid);

        int confirmCount = 0;
        do {
            System.out.print("Confirm Password: ");
            adminPwConfirm = scanner.next();
            scanner.nextLine();
            confirmCount++;
            if (adminPwConfirm.equals(adminPassword)) {
                confirmPwVld = true;
            } else if (confirmCount >= 3) {
                System.out.println("The Password Does Not Match with Previous Input,failed to sign up new admin\n");
                adminProfileMenu(adminArray, loggedInAdmin);
                System.out.println();
            } else {
                System.out.println("The Password Does Not Match with Previous Input\n");
            }
        } while (!confirmPwVld);

        Admin newAdmin = new Admin(adminName, adminIC, adminEmail, adminPhoneNo, adminPassword);
        adminArray.add(newAdmin);
        System.out.println("\n----------------------------------");
        System.out.println("Register a new admin successfully!");
        System.out.println("----------------------------------");
        adminProfileMenu(adminArray, loggedInAdmin);

    }

    public static void forgotPassword(ArrayList<Admin> adminArray) throws InterruptedException {
        boolean adminIDValid, icValid, passwordValid, confirmPwVld, adminFound;
        String adminID, adminIC, adminPassword, adminPwConfirm;
        Scanner scanner = new Scanner(System.in);

        do {
            adminFound = false;
            int tryIDCount = 0;
            do {
                adminIDValid = false;
                System.out.print("Enter admin ID: ");
                adminID = scanner.nextLine();
                tryIDCount++;
                if (Admin.vldAdminID(adminID)) {
                    adminIDValid = true;
                } else if (tryIDCount >= 3) {
                    System.out.println("You keyed in invalid admin ID 3 times, auto back\n");
                    menu(adminArray);
                } else {
                    System.out.println("Admin ID must start with capital A and followed by 1 integer eg:A1\n");
                }
            } while (!adminIDValid);
            int tryICCount = 0;
            do {

                icValid = false;
                System.out.print("Enter IC (eg:030922101245) : ");
                adminIC = scanner.nextLine();
                tryICCount++;
                if (Person.vldIC(adminIC)) {
                    icValid = true;
                } else if (tryICCount >= 3) {
                    System.out.println("You keyed in invalid IC 3 times, auto back\n");
                    menu(adminArray);
                } else {
                    System.out.println("Please Enter A Valid IC.");
                }
            } while (!icValid);

            for (int i = 0; i < adminArray.size(); i++) {
                if (adminArray.get(i).getAdminID().equals(adminID) && adminArray.get(i).getIC().equals(adminIC)) {
                    int foundAdminIndex = i;
                    adminFound = true;

                    System.out.println("\n---------------------------------------");
                    System.out.println("You can change your password now!");
                    System.out.println("---------------------------------------\n");
                    do {
                        passwordValid = false;
                        System.out.print("Enter New Password: ");
                        adminPassword = scanner.next();
                        scanner.nextLine();

                        if (Admin.vldPassword(adminPassword)) {
                            passwordValid = true;
                        } else {
                            System.out.println("Password Must Include Alphabet, Number and At Least 6 Characters.");
                            System.out.println();
                        }
                    } while (!passwordValid);

                    int confirmCount = 0;
                    do {
                        confirmPwVld = false;
                        System.out.print("Confirm New Password: ");
                        adminPwConfirm = scanner.next();
                        scanner.nextLine();
                        confirmCount++;
                        if (adminPwConfirm.equals(adminPassword)) {
                            adminArray.get(foundAdminIndex).setPassword(adminPassword);
                            confirmPwVld = true;
                            System.out.println("\n---------------------------------------");
                            System.out.println("Your password is changed successfully!");
                            System.out.println("---------------------------------------\n");
                            menu(adminArray);

                        } else if (confirmCount >= 3) {
                            System.out.println("The Password Does Not Match with Previous Input three times,fail to change your password. Auto back\n");
                            menu(adminArray);
                            System.out.println();
                        } else {
                            System.out.println("The Password Does Not Match with Previous Input\n");
                        }
                    } while (!confirmPwVld);

                } else {
                    System.out.println("Admin Not Found\n");
                    adminFound = false;
                }
            }
        } while (!adminFound);

    }

}
