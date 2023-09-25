/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Event {

    private static int nextEvent = 100;
    private String eventID;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private VenueType eventVenue;
    private DecorationType decoration;
    private int promoterNum;
    private ArrayList<Product> eventProducts;
    private ArrayList<Participant> participantArr;
    private static double totalRevenue = 0;

    public Event() {

    }

    ;
    
    public Event(String eventName, LocalDate eventDate, LocalTime eventTime,
            VenueType eventVenue, DecorationType decoration, int promoterNum, ArrayList<Product> eventProducts) {

        eventID = "E" + nextEvent++;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.decoration = decoration;
        this.promoterNum = promoterNum;
        this.eventProducts = eventProducts;
        participantArr = new ArrayList<>();

    }

    ;

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public VenueType getEventVenue() {
        return eventVenue;
    }

    public DecorationType getDecoration() {
        return decoration;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void deductTotalRevenue(double amount) {
        totalRevenue = totalRevenue - amount;
    }

    public String getEventID() {
        return eventID;
    }

    public static void addTotalRevenue(double amount) {
        totalRevenue = totalRevenue + amount;
    }

    public ArrayList<Product> getEventProducts() {
        return eventProducts;
    }

    public ArrayList<Participant> getParticipantArr() {
        return participantArr;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public void setEventVenue(VenueType eventVenue) {
        this.eventVenue = eventVenue;
    }

    public void setEventProducts(ArrayList<Product> eventProducts) {
        this.eventProducts = eventProducts;
    }

    public double calcFees() {
        return (decoration.price + eventVenue.price + (eventProducts.size() * 100));
    }

    public int getPromoterNum() {
        return promoterNum;
    }

    public void addParticipant(Participant participant) {
        participantArr.add(participant);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return "==============================================="
                + "\n\nEvent ID: " + eventID
                + "\nEvent Name: " + eventName
                + "\nEvent Date: " + eventDate.format(dateFormatter)
                + "\nEvent Time: " + eventTime
                + "\nEvent Event Venue: " + eventVenue
                + "\nEvent Event Decoration: " + decoration
                + "\nNumber of promoters: " + promoterNum
                + "\nNumber of participants: " + participantArr.size();

    }

    public static String viewAllProducts(ArrayList<Product> eventProducts) {
        String outputAllProducts = "";
        String output;
        for (int i = 0; i < eventProducts.size(); i++) {
            output = "\n\n-------------------------"
                    + "\nProduct No: " + (i + 1)
                    + "\n-------------------------"
                    + eventProducts.get(i).toString();

            outputAllProducts = outputAllProducts.concat(output);

        }
        return outputAllProducts;
    }

    public static void viewPaidEvents(ArrayList<Booking> bookingArrList) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        boolean noPaidEvent = true;
        System.out.printf("\n%-10s %-15s %-15s %-15s %-15s\n", "Event ID", "Event Name", "Event Date", "Event Time", "Event Venue");
        for (int j = 0; j < bookingArrList.size(); j++) {
            if (bookingArrList.get(j).getPaymentMethod().getPaymentStatus().equals("Paid") == true) {
                noPaidEvent = false;
                System.out.printf("%-10s %-15s %-15s %-15s %-15s\n", bookingArrList.get(j).getEvent().eventID, bookingArrList.get(j).getEvent().eventName, bookingArrList.get(j).getEvent().eventDate.format(dateFormatter), bookingArrList.get(j).getEvent().eventTime, bookingArrList.get(j).getEvent().eventVenue);

            }

        }
        if (noPaidEvent) {
            System.out.println("\nThere is no event available for registration!");
        }
    }

}
