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
import java.util.Scanner;

public class testRun {

    public static void main(String[] args) {

//      Make Admin Array and create the main Admin
        Admin[] adminArray = new Admin[3];
        adminArray[0] = new Admin("1","030822103842", "yamjason04@gmail.com", "0168962213", "1");
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

                                System.out.print("\nPlease Choose an Option\n"
                                        + "1. Booking Management\n"
                                        + "2. Event Management\n"
                                        + "3. Exhibitor Profile Management\n"
                                        + "4. Analytics Report\n"
                                        + "5. Back\n"
                                        + "Enter your choice: "
                                );
                                int adminChoice = s1.nextInt();

                                while (vldIntInput(1, 5, adminChoice) == false) {
                                    s1.nextLine();
                                    System.out.print("\nInvalid choice!\n"
                                            + "Enter a valid choice: ");
                                    adminChoice = s1.nextInt();
                                }
                                s1.nextLine();
                                switch (adminChoice) {
                                    //booking management
                                    case 1: {
                                        System.out.print("\nPlease Choose an Option\n"
                                                + "1. Create Booking\n"
                                                + "2. View Booking\n"
                                                + "3. Pay unpaid Booking\n"
                                                + "4. Cancel Bookings\n"
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
                                                System.out.print("\nEnter Exhibitor Name: ");
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
                                                while (Organizer.vldIC(exIC) == false) {
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
                                                s1.nextLine();

                                                //Invoke Exhibitor Constructor 
                                                Organizer exhibitor = new Organizer(companyName, exIC, productArrList, exName, exEmail, phoneNo);

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

                                                //-eventProducts ArrayList<Product> use = to do reference to the productArrList created when creating exhibitor
                                                ArrayList<Product> eventProduct = productArrList;

                                                //-participantArr: ArrayList<Participant>
                                                ArrayList<Participant> participantArrList = new ArrayList<>();

                                                //Invoke the event constructor
                                                Event event = new Event(eventName, eventDate, eventTime, venueType, decorationType, eventProduct, participantArrList);

                                                //Make Payment
                                                System.out.print("\nTotal: " + event.getPrice()
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
                                                    Card payment = new Card(cardNum, cardHolder, cardExp, cardCVV, event.getPrice());

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
                                                        Event.deductTotalRevenue(event.getPrice());

                                                    }

                                                    //Create the booking for Card payment
                                                    Booking booking = new Booking(exhibitor, event, payment);
                                                    //Add the Booking to booking array list
                                                    bookingArrList.add(booking);

                                                } else {

                                                    //amount tendered
                                                    System.out.print("\nEnter amount tendered: ");
                                                    double amountTendered = s1.nextDouble();

                                                    //validate amount tendered (only accept >= event.getPrice() or 0) 0 means not yet paid
                                                    while ((amountTendered < event.getPrice() && amountTendered > 0) || amountTendered < 0) {
                                                        s1.nextLine();
                                                        System.out.print("\nInvalid input!\n"
                                                                + "Enter amount tendered: ");
                                                        amountTendered = s1.nextDouble();

                                                    }
                                                    s1.nextLine();
                                                    //create cash object
                                                    Cash payment = new Cash(amountTendered, event.getPrice());

                                                    //if amount tendered >= event.getPrice(), make the paid = true, if 0 = paid = false
                                                    if (amountTendered == 0) {
                                                        payment.pendingPayment();
                                                        //payment not paid, need to deduct event price from totalrevenue cuz event price 
                                                        //will get added  to totalRevenue automatically when event object is created

                                                        Event.deductTotalRevenue(event.getPrice());
                                                        System.out.println("Payment Not Received.");

                                                    } else {
                                                        payment.makePayment();
                                                        //Display changeAmount                                                  
                                                        System.out.println("Change Amount: " + payment.getChangeAmount());
                                                    }

                                                    //create the booking for cash payment
                                                    Booking booking = new Booking(exhibitor, event, payment);
                                                    //Add the Booking to booking array list
                                                    bookingArrList.add(booking);

                                                }

                                                break;

                                            }
                                            //----------------------------View Booking----------------------------------------
                                            case 2: {

                                                System.out.printf("%-15s %-15s %-15s %-15s %-15s", "\nBooking Number", "Exhibitor Name", "Company Name", "Event Name", "Payment Status");
                                                for (int j = 0; j < bookingArrList.size(); j++) {

                                                    System.out.print("\n" + bookingArrList.get(j));
                                                    System.out.printf("%-15s %-15s %-15s %-15s", bookingArrList.get(j).getExhibitor().getName(), bookingArrList.get(j).getExhibitor().getCompanyName(), bookingArrList.get(j).getEvent().getEventName(), bookingArrList.get(j).getPaymentMethod().getPaymentStatus());
                                                }
                                                System.out.println("");

                                                break;

                                            }
                                            //------------------------------------------pay unpaid booking---------------------------------------
                                            case 3: {

                                                System.out.printf("%-15s %-15s %-15s %-15s %-15s", "\nBooking Number", "Exhibitor Name", "Company Name", "Event Name", "Payment Status");

                                                for (int j = 0; j < bookingArrList.size(); j++) {
                                                    if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Pending")) {
                                                        System.out.print("\n" + bookingArrList.get(j));
                                                        System.out.printf("%-15s %-15s %-15s %-15s", bookingArrList.get(j).getExhibitor().getName(), bookingArrList.get(j).getExhibitor().getCompanyName(), bookingArrList.get(j).getEvent().getEventName(), bookingArrList.get(j).getPaymentMethod().getPaymentStatus());
                                                    }

                                                }
                                                System.out.println("\n\nSelect which booking to pay");
                                                System.out.print("Enter Booking ID (999 to exit): ");
                                                int bookingID = s1.nextInt();
                                                if (bookingID == 999) {
                                                    break;
                                                }
                                                boolean validBookingID = false;

                                                for (int j = 0; j < bookingArrList.size(); j++) {
                                                    if (bookingID == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus() == "Pending") {

                                                        //Make Payment
                                                        System.out.print(
                                                                "\nTotal: RM" + bookingArrList.get(j).getEvent().getPrice()
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
                                                            Card payment = new Card(cardNum, cardHolder, cardExp, cardCVV, bookingArrList.get(j).getEvent().getPrice());

                                                            //Update payment status, if paid, payment object's attribute "paid" will be true
                                                            if (paymentCheck == 'Y') {

                                                                payment.makePayment();
                                                                //since the booking is paid, need to add the event price to totalRevenue
                                                                Event.addTotalRevenue(bookingArrList.get(j).getEvent().getPrice());

                                                            } else if (paymentCheck == 'N') {
                                                                payment.pendingPayment();
                                                            }
                                                            bookingArrList.get(j).setPaymentMethod(payment);

                                                        } else {

                                                            //amount tendered
                                                            System.out.print("\nEnter amount tendered: ");
                                                            double amountTendered = s1.nextDouble();

                                                            //validate amount tendered (only accept >= event.getPrice() or 0) 0 means not yet paid
                                                            while ((amountTendered < bookingArrList.get(j).getEvent().getPrice() && amountTendered > 0) || amountTendered < 0) {
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
                                                                Cash cash = new Cash(amountTendered, bookingArrList.get(j).getEvent().getPrice());
                                                                cash.makePayment();
                                                                System.out.println("Change Amount: " + cash.getChangeAmount());
                                                                bookingArrList.get(j).setPaymentMethod(cash);
                                                                //since the booking is paid, need to add the event price to totalRevenue
                                                                Event.addTotalRevenue(bookingArrList.get(j).getEvent().getPrice());

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

                                            //cancel Booking
                                            //refund 50%, total revenue -50% of event.getprice()
                                            //if payment pending, do not refund
                                            case 4: {
                                                //show all bookings except bookings that have Cancelled paymentStatus
                                                System.out.printf("%-15s %-15s %-15s %-15s %-15s", "\nBooking Number", "Exhibitor Name", "Company Name", "Event Name", "Payment Status");

                                                for (int j = 0; j < bookingArrList.size(); j++) {
                                                    if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {
                                                        System.out.print("\n" + bookingArrList.get(j));
                                                        System.out.printf("%-15s %-15s %-15s %-15s", bookingArrList.get(j).getExhibitor().getName(), bookingArrList.get(j).getExhibitor().getCompanyName(), bookingArrList.get(j).getEvent().getEventName(), bookingArrList.get(j).getPaymentMethod().getPaymentStatus());
                                                    }

                                                }
                                                System.out.println("\n\nSelect which booking to cancel");
                                                System.out.print("Enter Booking ID: ");
                                                int bookingID = s1.nextInt();
                                                boolean validBookingID = false;
                                                for (int j = 0; j < bookingArrList.size(); j++) {
                                                    if (bookingID == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {
                                                        //make payment status = cancelled
                                                        bookingArrList.get(j).getPaymentMethod().cancelPayment();

                                                        //deduct totalRevenue with 50% of event price and refund the other 50% 
                                                        Event.deductTotalRevenue(bookingArrList.get(j).getEvent().getPrice() * 0.5);

                                                        //display the amount to refund
                                                        System.out.println("Amount to refund: " + bookingArrList.get(j).getEvent().getPrice() * 0.5);

                                                        validBookingID = true;

                                                    }

                                                }
                                                if (validBookingID == false) {
                                                    System.out.println("Invalid booking ID or the booking has been paid!");
                                                }

                                                break;

                                            }
                                            //Back
                                            case 5: {

                                            }
                                        }
                                        break;
                                    }
                                    //Event Management

                                    case 2: {
                                        break;

                                    }
                                    // Exhibitor Profile management
                                    case 3: {
                                        break;

                                    }
                                    //Analytics Report
                                    case 4: {
                                        break;
                                    }
                                    //Back, prompt to log out
                                    case 5: {

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
    
    public static void printAdminList(Admin[] adminArray) {
        System.out.printf("%-10s %-20s %-15s %-20s %-15s\n", "Admin ID", "Name", "IC", "Phone Number", "Email");
        
        for(Admin adminprint:adminArray){
            System.out.println(adminprint);
        }
        
        
        
    }

}
