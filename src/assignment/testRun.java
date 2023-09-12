/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.Scanner;

public class testRun {

    public static void main(String[] args) {

//        Make Admin Array and create the main Admin
        Admin[] adminArray = new Admin[3];
        adminArray[0] = new Admin("1", "yamjason04@gmail.com", "0168962213", "1");

        Scanner s1 = new Scanner(System.in);

        while (true) {
            //Main screen, select option
            System.out.print("Please Choose an Option\n"
                    + "1. Admin\n"
                    + "2. Attendee\n"
                    + "Enter your choice: ");
            int choice = s1.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.println("Invalid choice!\n"
                        + "Enter a valid choice: ");
                choice = s1.nextInt();

            }
            s1.nextLine();
            switch (choice) {

                case 1: {

                    //Admin login screen
                    System.out.println("Admin Login:");
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

                                System.out.print("Please Choose an Option\n"
                                        + "1. Event Management\n"
                                        + "2. Exhibitor Profile Management\n"
                                        + "3. Analytics Report\n"
                                        + "4. Back\n"
                                        + "Enter your choice: "
                                );
                                int adminChoice = s1.nextInt();

                                while (adminChoice != 1 && adminChoice != 2 && adminChoice != 3 && adminChoice != 4) {
                                    System.out.println("Invalid choice!\n"
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
                                                //Create Exhibitor

                                                //-Exhibitor name
                                                System.out.print("Enter Exhibitor Name: ");
                                                String ExName = s1.nextLine();

                                                //-Email
                                                System.out.print("Enter Exhibitor Email: ");
                                                String ExEmail = s1.nextLine();
                                                while (Person.vldEmail(ExEmail) == false) {
                                                    System.out.print("Invalid address!\n"
                                                            + "Enter Exhibitor Email: ");
                                                    ExEmail = s1.nextLine();
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
                                                String exhibitorIC = s1.nextLine();
                                                while (Exhibitor.vldIC(ic)) {
                                                    System.out.print("Invalid IC!\n"
                                                            + "Enter IC: ");
                                                    ic = s1.nextLine();
                                                }
                                                //-ArrayList<Product> products
                                                //Create Event
                                                //Create the Booking
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

}
