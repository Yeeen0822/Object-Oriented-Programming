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

    public static void main(String[] args) throws InterruptedException {

//      Make Admin Array and create the main Admin
        ArrayList<Admin> adminArray = new ArrayList<>();
        Admin admin1 = new Admin("Yee En", "030822103842", "yamjason04@gmail.com", "0168962213", "1");
        adminArray.add(admin1);

        //Create an array list for booking
        ArrayList<Booking> bookingArrList = new ArrayList<>();
        ArrayList<Registration> registrationArrList = new ArrayList<>();
        Scanner s1 = new Scanner(System.in);
        boolean exit = false;
        boolean optionVld;

        while (!exit) {
            optionVld = true;
            do {

                //Main screen, select option
                switch (mainMenu()) {
                    case 1: {
                        //admin screen
                        menu(adminArray, bookingArrList, registrationArrList);
                        break;
                    }
                    //participant screen

                    case 2: {
                        participantMenu(bookingArrList, registrationArrList);

                        break;
                    }
                    case 3: {
                        exit = true;
                        break;
                    }
                    default: {
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");
                    }
                }

            } while (!optionVld);

        }

    }

    public static int mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Choose an Option\n"
                + "1. Admin\n"
                + "2. Participant\n"
                + "3. Exit\n"
                + "Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public static void bookingManagement(ArrayList<Booking> bookingArrList) {

        Scanner s1 = new Scanner(System.in);

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
                createEventBooking(bookingArrList);
                break;

            }
            //--------------------------Update event booking-------------------------------
            case 2: {
                updateEventBooking(bookingArrList);
                break;

            }

            //----------------------------View Booking----------------------------------------
            case 3: {
                viewBookings(bookingArrList);
                break;

            }
            //----------------------Search Booking-----------------------------------------------
            case 4: {
                searchBooking(bookingArrList);
                break;
            }
            //------------------------------------------pay unpaid booking---------------------------------------
            case 5: {

                payUnpaidBooking(bookingArrList);

                break;

            }

            //---------------------------------------Cancel Booking---------------------------------------------------
            //refund 50%, total revenue -50% of event.getprice()
            //if payment pending, do not refund
            case 6: {
                cancelBooking(bookingArrList);
                break;

            }
            //------------------View all Event---------------------
            case 7: {
                viewEvent(bookingArrList);

                break;
            }

            //---------------------Search Event---------------------
            case 8: {
                searchEvent(bookingArrList);

                break;
            }
            //---------------------Back------------------------
            default: {
                //do nothing to go back

            }
        }

    }

    //need to update loop
    public static void updateEventBooking(ArrayList<Booking> bookingArrList) {
        Scanner s1 = new Scanner(System.in);

        System.out.println("\nSelect which event booking to update");
        System.out.print("Enter Booking ID (999 to exit): ");
        int bookingNum = s1.nextInt();

        boolean validBookingID = false;

        if (bookingNum != 999) {
            for (int j = 0; j < bookingArrList.size(); j++) {

                if (bookingNum == bookingArrList.get(j).getBookingNum()) {
                    validBookingID = true;
                    int updateChoice;
                    boolean stayOnUpdateEventBooking = true;

                    //always stay on updateEventBooking for the entered bookingNum
                    while (stayOnUpdateEventBooking) {
                        System.out.println("\n-------------------------"
                                + "\nBooking Number: " + bookingNum
                                + "\n-------------------------");
                        System.out.print("Please Choose an Option\n"
                                + "1. Update Event Name\n"
                                + "2. Update Event Date\n"
                                + "3. Update Event Time\n"
                                + "4. Update Event Products\n"
                                + "5. Back\n"
                                + "Enter your choice: "
                        );
                        updateChoice = s1.nextInt();

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

                                updateEventName(bookingArrList, j);

                                break;
                            }
                            // 2: update event date
                            case 2: {

                                updateEventDate(bookingArrList, j);

                                break;
                            }
                            // 3: update event time
                            case 3: {
                                updateEventTime(bookingArrList, j);
                                break;
                            }
                            // 4: update event products
                            case 4: {
                                updateEventProduct(bookingArrList, j);
                                break;
                            }
                            // 5: back
                            default: {
                                stayOnUpdateEventBooking = false;

                            }

                        }

                    }

                }

            }
            if (validBookingID == false) {
                System.out.println("Invalid booking ID!");
            }

        }

        //go back to previous page
        bookingManagement(bookingArrList);
    }

    public static void createEventBooking(ArrayList<Booking> bookingArrList) {
        Scanner s1 = new Scanner(System.in);
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
        System.out.print("Enter Company Name: ");
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
            eventOption = s1.nextInt(); // 1 = phone Event, 2 = car event
        }
        s1.nextLine();

        System.out.println("\nEnter Details About the Event");

        //-eventName
        System.out.print("Enter Event Name: ");
        String eventName = s1.nextLine();

        //-eventDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate currentDate = LocalDate.now();

        LocalDate eventDate = null;

        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter Event Date (DD-MM-YYYY): ");
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
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
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
        VenueType[] venues = VenueType.values();
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
        VenueType venueType = venues[eventVenueNum - 1];

        //-decoration
        DecorationType[] decoration = DecorationType.values();
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
        DecorationType decorationType = decoration[eventDecorationNum - 1];

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
            System.out.print("Enter Product Price: RM");
            double prodPrice = s1.nextDouble();

            Product product = new Product(prodName, prodDesc, prodPrice);
            productArrList.add(product);
        }
        s1.nextLine();

        Event event;
        //phoneEvent = 1 , carEvent = 2
        //phoneEvent prompts and create phoneEvent
        if (eventOption == 1) {
            //techTalkSession
            System.out.print("Enter the number of tech talk sessions: ");
            int techTalkSession = s1.nextInt();
            s1.nextLine();

            //demoStation
            System.out.print("Enter the number of demo stations: ");
            int demoStation = s1.nextInt();
            s1.nextLine();

            //create PhoneEvent object
            event = new PhoneEvent(techTalkSession, demoStation, eventName, eventDate, eventTime, venueType, decorationType, promoterNum, productArrList);
        } //carEvent prompts and create carEvent
        else {
            //carEventTheme
            System.out.print("Enter the car event theme: ");
            String carEventTheme = s1.nextLine();

            //numTestDriveLocation
            System.out.print("Enter the number of test drive locations: ");
            int numTestDriveLocation = s1.nextInt();
            s1.nextLine();
            //create CarEvent object
            event = new CarEvent(carEventTheme, numTestDriveLocation, eventName, eventDate, eventTime, venueType, decorationType, promoterNum, productArrList);
        }

        //--------------------------Invoke the event constructor--------------------------------
        // PAYMENTHERE
        Payment payment = payment(event.calcFees());
        Booking booking = new Booking(organizer, event, payment);
        System.out.println("Booking Number: " + booking.getBookingNum());
        //Add the Booking to booking array list
        bookingArrList.add(booking);
        //go back to previous page
        bookingManagement(bookingArrList);

    }

    public static void searchBooking(ArrayList<Booking> bookingArrList) {
        int bookingNo;
        boolean inputBookingNo = false, notFound;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter booking number (Enter 999 to exit):");
            bookingNo = sc.nextInt();

            if (bookingNo == 999) {
                break;
            }

            if (bookingNo >= 100) {
                notFound = true;
                for (int i = 0; i < bookingArrList.size(); i++) {
                    if (bookingArrList.get(i).getBookingNum() == bookingNo) {
                        inputBookingNo = true;
                        System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");
                        System.out.println(bookingArrList.get(i));
                        notFound = false;
                        break;
                    }
                }
                if (notFound) {
                    System.out.println("Booking Not Found!");
                }

            } else {
                System.out.println("Invalid booking number. Booking number starts from 100.\n");
            }

        } while (!inputBookingNo);
        bookingManagement(bookingArrList);
    }

    public static void viewUnpaidBooking(ArrayList<Booking> bookingArrList) {
        System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");

        for (int j = 0; j < bookingArrList.size(); j++) {
            if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Pending")) {
                System.out.println(bookingArrList.get(j));
            }

        }
    }

    public static void viewEvent(ArrayList<Booking> bookingArrList) {

        if (bookingArrList.size() == 0) {
            System.out.println("There is no event!");
        } else {
            System.out.println("================EVENT LIST=====================");
            for (int j = 0; j < bookingArrList.size(); j++) {

                System.out.println("\nEvent No: " + (j + 1));
                System.out.println(bookingArrList.get(j).getEvent());

            }
            System.out.println("\n===============================================");
        }
        bookingManagement(bookingArrList);

    }

    public static void searchEvent(ArrayList<Booking> bookingArrList) {
        String eventName;
        boolean inputEventName = false;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter Event Name (Enter 999 to exit):");
            eventName = sc.nextLine();

            if (eventName.equals("999")) {
                break;
            } else {

                for (int i = 0; i < bookingArrList.size(); i++) {
                    if (eventName.equals(bookingArrList.get(i).getEvent().getEventName())) {
                        inputEventName = true;
                        System.out.println(bookingArrList.get(i).getEvent());
                        System.out.println("\n===============================================");

                        break;
                    }
                }
                if (!inputEventName) {
                    System.out.println("Event Not Found!");
                }

            }

        } while (!inputEventName);
        bookingManagement(bookingArrList);
    }

    public static Payment payment(double amountToPay) {
        Scanner s1 = new Scanner(System.in);

        //Make Payment
        System.out.print("\nTotal: RM" + String.format("%.2f", amountToPay)
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
                        + "Enter Card Expiry Date eg(12/30): ");
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
            Card payment = new Card(cardNum, cardHolder, cardExp, cardCVV, amountToPay);

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

                //revenue ++
                Event.addTotalRevenue(amountToPay);
                System.out.println(payment);

            } else if (paymentCheck == 'N') {

                payment.pendingPayment();

            }
            return payment;

        } else {

            //amount tendered
            System.out.print("\nEnter amount tendered: RM");
            double amountTendered = s1.nextDouble();

            //validate amount tendered (only accept >= event.getPrice() or 0) 0 means not yet paid
            while ((amountTendered < amountToPay && amountTendered > 0) || amountTendered < 0) {
                s1.nextLine();
                System.out.print("\nInvalid input!\n"
                        + "Enter amount tendered: RM");
                amountTendered = s1.nextDouble();

            }
            s1.nextLine();
            //create cash object
            Cash payment = new Cash(amountTendered, amountToPay);

            //if amount tendered >= event.getPrice(), make the paid = true, if 0 = paid = false
            if (amountTendered == 0) {
                payment.pendingPayment();

                System.out.println("Payment Not Received.");

            } else {
                payment.makePayment();
                //Display changeAmount                                                  
                System.out.println("Change Amount: RM" + String.format("%.2f", payment.getChangeAmount()));
                Event.addTotalRevenue(amountToPay);

                System.out.println(payment);
            }
            return payment;

        }
    }

    public static void payUnpaidBooking(ArrayList<Booking> bookingArrList) {
        Scanner s1 = new Scanner(System.in);

        viewUnpaidBooking(bookingArrList);
        System.out.println("\n\nSelect which booking to pay");
        System.out.print("Enter Booking ID (999 to exit): ");
        int bookingNum = s1.nextInt();
        if (bookingNum == 999) {
            //do nothing and go back to bookingManagement
        } else {

            boolean validBookingID = false;
            //-------------------------------DO PAYMENT FOR UNPAID BOOKING HERE-----------------------------------------
            for (int j = 0; j < bookingArrList.size(); j++) {
                if (bookingNum == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus() == "Pending") {

                    Payment payment = payment(bookingArrList.get(j).getEvent().calcFees());

                    validBookingID = true;

                }

            }
            if (validBookingID == false) {
                System.out.println("Invalid booking ID or the booking has been paid!");
            }

        }

        //go back to previous page
        bookingManagement(bookingArrList);

    }

    public static void cancelBooking(ArrayList<Booking> bookingArrList) {
        Scanner s1 = new Scanner(System.in);

        viewCancelledBookings(bookingArrList);

        System.out.println("\n\nSelect which booking to cancel");
        System.out.print("Enter Booking ID: ");
        int bookingID = s1.nextInt();
        boolean validBookingID = false;
        for (int j = 0; j < bookingArrList.size(); j++) {
            if (bookingID == bookingArrList.get(j).getBookingNum() && bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {

                //display the amount to refund
                if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Paid") == true) {
                    System.out.println("Amount to refund: RM" + String.format("%.2f", bookingArrList.get(j).getEvent().calcFees() * 0.5));
                }

                //make payment status = cancelled
                bookingArrList.get(j).getPaymentMethod().cancelPayment();

                //deduct totalRevenue with 50% of event price and refund the other 50% 
                Event.deductTotalRevenue(bookingArrList.get(j).getEvent().calcFees() * 0.5);

                validBookingID = true;

            }

        }
        if (validBookingID == false) {
            System.out.println("Invalid booking ID!");
        }
        bookingManagement(bookingArrList);

    }

    public static void updateEventName(ArrayList<Booking> bookingArrList, int index) {

        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter Event Name: ");
        String name = s1.nextLine();
        bookingArrList.get(index).getEvent().setEventName(name);
        System.out.println("Updated Successfully!");

    }

    public static void updateEventDate(ArrayList<Booking> bookingArrList, int index) {
        Scanner s1 = new Scanner(System.in);
        boolean isValidInput = false; //to check the format of certain input 
        //-eventDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate currentDate = LocalDate.now();

        LocalDate eventDate = null;

        while (!isValidInput) {
            System.out.print("Enter Event Date (DD-MM-YYYY): ");
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
                System.out.println("Invalid date format. Please use DD-MM-YYYY.");
            }

        }
        bookingArrList.get(index).getEvent().setEventDate(eventDate);
        System.out.println("Updated Successfully!");

    }

    public static void updateEventTime(ArrayList<Booking> bookingArrList, int index) {
        Scanner s1 = new Scanner(System.in);
        boolean isValidInput = false; //to check the format of certain input 
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

        bookingArrList.get(index).getEvent().setEventTime(eventTime);
        System.out.println("Updated Successfully!");

    }

    public static void updateEventProduct(ArrayList<Booking> bookingArrList, int index) {
        Scanner s1 = new Scanner(System.in);
        int productNum;

        //make a while loop to keep asking which to update until '4' is entered
        boolean stayUpdating = true;
        while (stayUpdating) {
            //view all products using a static method from event
            System.out.println(Event.viewAllProducts(bookingArrList.get(index).getEvent().getEventProducts()));

            System.out.print("Enter product number (999 to exit): ");
            productNum = s1.nextInt();
            //999 to go back to previous screen

            while (productNum < 1 || productNum > bookingArrList.get(index).getEvent().getEventProducts().size()) {

                //exception, to go back to previous screen
                if (productNum == 999) {
                    stayUpdating = false;
                    break;
                }
                s1.nextLine();
                System.out.println("Invalid product number!");
                System.out.print("Enter product number: ");
                productNum = s1.nextInt();
            }
            s1.nextLine();

            //execute only when its not 999 because 999 means to exit
            if (productNum != 999) {
                System.out.println("\nSelect Which to update:"
                        + "\n1. Product Name"
                        + "\n2. Product Desc"
                        + "\n3. Product Price"
                        + "\n4. Back");
                System.out.print("Enter your choice (1-4): ");
                int updateChoice = s1.nextInt();
                while (vldIntInput(1, 4, updateChoice) == false) {
                    s1.nextLine();
                    System.out.println("Invalid input!");
                    System.out.print("Enter your choice (1-4): ");
                    updateChoice = s1.nextInt();
                }
                s1.nextLine();

                switch (updateChoice) {
                    case 1: {
                        updateProductName(bookingArrList, index, productNum);
                        break;
                    }
                    case 2: {
                        updateProductDesc(bookingArrList, index, productNum);
                        break;
                    }
                    case 3: {
                        updateProductPrice(bookingArrList, index, productNum);
                        break;
                    }
                    default: {

                    }
                }

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
        bookingManagement(bookingArrList);

    }

    public static void viewCancelledBookings(ArrayList<Booking> bookingArrList) {
        //show all bookings except bookings that have Cancelled paymentStatus
        System.out.printf("\n%-15s %-15s %-15s %-15s %-15s\n", "Booking Number", "Organizer Name", "Company Name", "Event Name", "Payment Status");

        for (int j = 0; j < bookingArrList.size(); j++) {
            if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Cancelled") == false) {
                System.out.println(bookingArrList.get(j));

            }

        }
    }

    public static void updateProductName(ArrayList<Booking> bookingArrList, int index, int productNum) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter product Name: ");
        String productName = s1.nextLine();
        bookingArrList.get(index).getEvent().getEventProducts().get(productNum - 1).setProductName(productName);
        System.out.println("Updated Successfully!");

    }

    public static void updateProductDesc(ArrayList<Booking> bookingArrList, int index, int productNum) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter product Description: ");
        String productDesc = s1.nextLine();
        bookingArrList.get(index).getEvent().getEventProducts().get(productNum - 1).setProductDesc(productDesc);
        System.out.println("Updated Successfully!");

    }

    public static void updateProductPrice(ArrayList<Booking> bookingArrList, int index, int productNum) {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter product Price: RM");
        double productPrice = s1.nextDouble();
        bookingArrList.get(index).getEvent().getEventProducts().get(productNum - 1).setProductPrice(productPrice);
        System.out.println("Updated Successfully!");

    }

    public static void participantMenu(ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) {
        Scanner s1 = new Scanner(System.in);
        boolean optionVld = true;

        int participantChoice;
        boolean stayInThisMenu = true;

        do {
            System.out.println("\n-----Welcome to to participant Menu-----");
            System.out.println("1.Register For An Event");
            System.out.println("2.Back");
            System.out.print("Enter your choice: ");
            try {
                participantChoice = s1.nextInt();

                switch (participantChoice) {
                    case 1:
                        //Register for an event
                        registerEvent(bookingArrList, registrationArrList);

                        break;
                    case 2:
                        //do nothing to go back to previous menu

                        System.out.println("");
                        break;
                    default:
                        optionVld = false;
                        System.out.println("Please Enter the Valid Option.");

                }
            } catch (InputMismatchException inputMismatchException) {
                optionVld = false;
                System.out.println("Please Enter Only Integer.");
                s1.nextLine();
            }
        } while (!optionVld);

    }

    public static void registerEvent(ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) {
        Scanner s1 = new Scanner(System.in);

        //check if there is any paid event
        boolean paidEventAvailable = false;
        for (int i = 0; i < bookingArrList.size(); i++) {
            //if there is at least an event, break the loop
            if (paidEventAvailable) {
                break;
            } else {
                if (bookingArrList.get(i).getPaymentMethod().getPaymentStatus().equals("Paid")) {
                    paidEventAvailable = true;

                }

            }

        }
        if (paidEventAvailable) {

            //display available events to register
            //name
            System.out.print("Enter Name: ");
            String name = s1.nextLine();

            //ic
            System.out.print("Enter IC: ");
            String ic = s1.nextLine();
            while (Organizer.vldIC(ic) == false) {
                System.out.print("Invalid IC!\n"
                        + "Enter IC: ");
                ic = s1.nextLine();
            }

            //-phoneNo
            System.out.print("Enter Phone Number: ");
            String phoneNo = s1.nextLine();
            while (Person.vldPhoneNumber(phoneNo) == false) {
                System.out.print("Invalid Phone Number!\n"
                        + "Enter Phone Number: ");
                phoneNo = s1.nextLine();
            }

            //-Email
            System.out.print("Enter Email: ");
            String email = s1.nextLine();
            while (Person.vldEmail(email) == false) {
                System.out.print("Invalid address!\n"
                        + "Enter Email: ");
                email = s1.nextLine();
            }
            //create participant
            Participant participant = new Participant(name, ic, email, phoneNo);

            Event.viewPaidEvents(bookingArrList);

            boolean validEventid = false;
            int eventIndex = 0;

            do {
                //prompt for event id
                System.out.print("Enter Event ID: ");
                String eventID = s1.nextLine();

                for (int j = 0; j < bookingArrList.size(); j++) {
                    if (bookingArrList.get(j).getEvent().getEventID().equals(eventID) == true) {
                        validEventid = true;
                        eventIndex = j;
                    }
                }
                if (!validEventid) {
                    System.out.println("Invalid Event ID!");
                }
            } while (!validEventid);
            Event event = bookingArrList.get(eventIndex).getEvent();

            //choose seats
            SeatType[] seats = SeatType.values();
            System.out.println("\nSeat Type:");
            for (int j = 0; j < seats.length; j++) {
                System.out.println((j + 1) + ". " + seats[j]);
            }

            System.out.print("Enter Seat Type (1-" + seats.length + "): ");
            int seatNum = s1.nextInt();
            while (vldIntInput(1, seats.length, seatNum) == false) {
                System.out.print("\nInvalid Input!\n"
                        + "Enter again: ");
                seatNum = s1.nextInt();
            }
            s1.nextLine();
            SeatType seatType = seats[seatNum - 1];

            //pay
            //create payment object
            Payment payment = payment(seatType.price); //revenue++;

            if (payment.getPaymentStatus().equals("Paid")) {
                //make registration
                Registration registration = new Registration(event, participant, payment, seatType);
                //add to participantArrList of the event
                bookingArrList.get(eventIndex).getEvent().addParticipant(participant);
                //add to registrationArrList
                registrationArrList.add(registration);
                System.out.println("Registered successfully!");

            } else {
                System.out.println("Failed to register!");
            }

        } else {
            System.out.println("No event is available for registration!");
        }

        participantMenu(bookingArrList, registrationArrList);
    }

    public static void printAdminList(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {

        if (loggedInAdmin != 0) {
            System.out.println("\n---------------------------------");
            System.out.println("You are not admin manager.");
            System.out.println("You dont have this priviledge.");
            System.out.println("---------------------------------");
            adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
        }

        System.out.println("                                           Admins' Profiles                                                    ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-20s%-15s%-30s%-15s\n", "Admin ID", "Name", "IC", "Email", "Phone Number");
        for (int i = 0; i < adminArray.size(); i++) {
            System.out.printf("%-10s%-20s%-15s%-30s%-15s\n", adminArray.get(i).getAdminID(), adminArray.get(i).getName(), adminArray.get(i).getIC(), adminArray.get(i).getEmail(), adminArray.get(i).getPhoneNo());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
    }

    private static void menu(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) throws InterruptedException {
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
                        adminLogin(adminArray, bookingArrList, registrationArrList);
                        break;
                    case 2:
                        forgotPassword(adminArray, bookingArrList, registrationArrList);
                        break;
                    case 3:
                        System.out.println("");
                        break;
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

    public static void adminLogin(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) throws InterruptedException {
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
                adminMenu(adminArray, bookingArrList, registrationArrList, loggedInAdmin);
            } else if (loginSuccess == false && loginCount >= 3) {
                System.out.println("Wrong Credentials.Auto exit");
                menu(adminArray, bookingArrList, registrationArrList);
                System.exit(0);
            } else {
                System.out.println("Wrong Credentials, Please Try Again.");
            }

        } while (!loginSuccess);
    }

    public static void adminMenu(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList, int loggedInAdmin) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int selection;
        boolean optionVld = true;
        boolean staySignedIn = true;

        while (staySignedIn) {

            do {
                System.out.printf("\n%55s", "+------------------+");
                System.out.printf("%n%55s", "|    Admin Menu    |");
                System.out.printf("%n%55s%n", "+------------------+");
                System.out.println("Currently Logged In As Admin: " + adminArray.get(loggedInAdmin).getName());
                System.out.println("Admin ID: " + adminArray.get(loggedInAdmin).getAdminID());
                System.out.println();

                System.out.println("[1] Admin Profile Management");
                System.out.println("[2] Event Management");
                System.out.println("[3] Analytics and Reports");
                System.out.println("[4] Sign Out");
                System.out.println("[5]Exit");

                System.out.print("Selection: ");
                try {
                    selection = scanner.nextInt();
                    scanner.nextLine();
                    switch (selection) {
                        case 1:
                            adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
                            break;
                        case 2:
                            bookingManagement(bookingArrList);
                            break;
                        case 3:

                            analyticsReport(bookingArrList, registrationArrList);

                            break;

                        case 4:
                            System.out.println("You Are Signed Out.");

                            menu(adminArray, bookingArrList, registrationArrList);
                            staySignedIn = false;
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

    }

    public static void analyticsReport(ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int selection;
        boolean optionVld = true;
        boolean stayThisScreen = true;

        while (stayThisScreen) {
            do {
                System.out.println("\n+-----------------------------+");
                System.out.println("|    Analytics and Reports    |");
                System.out.println("+---------------------------+");
                System.out.println("[1] Booking Statistics");
                System.out.println("[2] Event Registration Report");
                System.out.println("[3] Revenue");
                System.out.println("[4] Location-based Analytic");
                System.out.println("[5] Cancellation Analytic");
                System.out.println("[6] Payment Analytic");
                System.out.println("[7] Back");

                System.out.print("Selection: ");
                try {
                    selection = scanner.nextInt();
                    scanner.nextLine();
                    switch (selection) {
                        case 1:
                            //booking statistic
                            bookingStatistic(bookingArrList);

                            break;
                        case 2:
                            //Event Registration Report
                            eventRegReport(bookingArrList, registrationArrList);

                            break;
                        case 3:
                            //Revenue
                            revenue();

                            break;

                        case 4:
                            //Location-Based Analytic
                            locationAnalytic(bookingArrList);

                            break;
                        case 5:
                            //cancellation Analytic
                            cancelAnalytic(bookingArrList);

                            break;
                        case 6:
                            paymentAnalytic(bookingArrList);
                            break;
                        case 7:

                            stayThisScreen = false;

                            break;
                        default:
                            optionVld = false;
                            System.out.println("Please Enter A Valid Option.");
                    }
                } catch (InputMismatchException inputMismatchException) {
                    optionVld = false;
                    System.out.println("Please Enter Only Integer.");
                    scanner.nextLine();
                }
            } while (!optionVld);

        }

    }

    public static void bookingStatistic(ArrayList<Booking> bookingArrList) {
        System.out.println("\n=========================================");
        System.out.println("             BOOKING STATISTIC           ");
        System.out.println("=========================================");
        int phoneCount = 0, carCount = 0;

        for (int i = 0; i < bookingArrList.size(); i++) {
            if (bookingArrList.get(i).getEvent() instanceof CarEvent) {
                carCount++;
            } else {
                phoneCount++;
            }

        }

        if (bookingArrList.size() > 0) {
            System.out.println("Number of Phone Events: " + phoneCount);
            System.out.println("Number of Car Events: " + carCount);
            System.out.println("\nPercentage of Phone Events: " + (phoneCount / bookingArrList.size()) * 100 + "%");
            System.out.println("Percentage of Car Events: " + (carCount / bookingArrList.size()) * 100 + "%");

        } else {
            System.out.println("\nThere is no event!\n");
        }

    }

    public static void eventRegReport(ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) {
        System.out.println("\n=========================================");
        System.out.println("            TOTAL REGISTRATIONS        ");
        System.out.println("=========================================");
        System.out.println("Total Registrations: " + registrationArrList.size());
        System.out.printf("%-10s %-15s %-25s\n", "Event ID", "Event Name", "Number of Registrations");
        for (int i = 0; i < bookingArrList.size(); i++) {
            System.out.printf("%-10s %-15s %-25s\n", bookingArrList.get(i).getEvent().getEventID(),
                    bookingArrList.get(i).getEvent().getEventName(), bookingArrList.get(i).getEvent().getParticipantArr().size());

        }
        if (registrationArrList.size() == 0) {
            System.out.println("\nThere is no Registration!");
        }
        System.out.println("");

    }

    public static void revenue() {
        System.out.println("\n=========================================");
        System.out.println("              TOTAL REVENUE        ");
        System.out.println("=========================================");
        System.out.println("\nREVENUE: RM" + String.format("%.2f", Event.getTotalRevenue()) + "\n");
    }

    public static void locationAnalytic(ArrayList<Booking> bookingArrList) {

        int genting = 0, pavilion = 0, midvalley = 0;
        System.out.println("\n=========================================");
        System.out.println("         Location-based Analytic        ");
        System.out.println("=========================================");

        for (int i = 0; i < bookingArrList.size(); i++) {
            if (bookingArrList.get(i).getEvent().getEventVenue() == VenueType.Genting) {
                genting++;
            } else if (bookingArrList.get(i).getEvent().getEventVenue() == VenueType.Pavilion) {
                pavilion++;
            } else {
                midvalley++;
            }
        }
        System.out.println("Number of events at Genting: " + genting);
        System.out.println("Number of events at Pavilion: " + pavilion);
        System.out.println("Number of events at Midvalley: " + midvalley + "\n");
    }

    public static void cancelAnalytic(ArrayList<Booking> bookingArrList) {
        int cancelCount = 0;
        System.out.println("\n=========================================");
        System.out.println("          Cancellation Analytic        ");
        System.out.println("=========================================");

        for (int i = 0; i < bookingArrList.size(); i++) {
            if (bookingArrList.get(i).getPaymentMethod().getPaymentStatus().equals("Cancelled")) {
                cancelCount++;

            }
        }
        System.out.println("\nNumber of Cancelled Bookings: " + cancelCount + "\n");

    }

    public static void paymentAnalytic(ArrayList<Booking> bookingArrList) {
        int cardCount = 0, cashCount = 0;
        System.out.println("\n=========================================");
        System.out.println("             Payment Analytic        ");
        System.out.println("=========================================");

        for (int i = 0; i < bookingArrList.size(); i++) {
            if (bookingArrList.get(i).getPaymentMethod() instanceof Card) {
                cardCount++;

            } else {
                cashCount++;
            }
        }
        System.out.println("\nNumber of Bookings Paid with Card: " + cardCount);
        System.out.println("Number of Bookings Paid with Cash: " + cashCount + "\n");

    }

    public static void adminProfileMenu(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {

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
                        viewProfile(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 2:
                        updateAdminMenu(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 3:
                        adminRegister(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 4:
                        printAdminList(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 5:
                        //do nothing to go back

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

    public static void viewProfile(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        char selection;
        char selectionUpper;
        boolean optionVld = true;
        System.out.println("\n\t\t\t\t\t\tAdmin Profile\t\t\t\t");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-25s%-15s%-25s%-15s\n", "Admin ID", "Name", "IC", "Email", "Phone No");
        System.out.printf("%-10s%-25s%-15s%-25s%-15s\n", adminArray.get(loggedInAdmin).getAdminID(), adminArray.get(loggedInAdmin).getName(), adminArray.get(loggedInAdmin).getIC(), adminArray.get(loggedInAdmin).getEmail(), adminArray.get(loggedInAdmin).getPhoneNo());
        System.out.println("----------------------------------------------------------------------------------------------------------");

        adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
    }

    public static void updateAdminMenu(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {

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
                        updatePhoneNo(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 2:
                        updateEmail(adminArray, bookingArrList, loggedInAdmin);
                        break;
                    case 3:
                        adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
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

    public static void updateEmail(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {
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
        updateAdminMenu(adminArray, bookingArrList, loggedInAdmin);

    }

    public static void updatePhoneNo(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {
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
        updateAdminMenu(adminArray, bookingArrList, loggedInAdmin);

    }

    public static void adminRegister(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, int loggedInAdmin) throws InterruptedException {
        boolean icValid = false, emailValid = false, passwordValid = false, phoneNoValid = false, confirmPwVld = false;
        String adminName, adminIC, adminEmail, adminPassword, adminPhoneNo, adminPwConfirm;
        Scanner scanner = new Scanner(System.in);

        if (loggedInAdmin != 0) {
            System.out.println("\n---------------------------------");
            System.out.println("You are not admin manager.");
            System.out.println("You dont have this priviledge.");
            System.out.println("---------------------------------");
            adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
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
                adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);
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
        adminProfileMenu(adminArray, bookingArrList, loggedInAdmin);

    }

    public static void forgotPassword(ArrayList<Admin> adminArray, ArrayList<Booking> bookingArrList, ArrayList<Registration> registrationArrList) throws InterruptedException {
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
                    menu(adminArray, bookingArrList, registrationArrList);
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
                    menu(adminArray, bookingArrList, registrationArrList);
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
                            menu(adminArray, bookingArrList, registrationArrList);

                        } else if (confirmCount >= 3) {
                            System.out.println("The Password Does Not Match with Previous Input three times,fail to change your password. Auto back\n");
                            menu(adminArray, bookingArrList, registrationArrList);
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
