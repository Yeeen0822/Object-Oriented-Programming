/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event {

    private static int nextEvent = 100;
    private String eventID;
    private String eventName;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private venueType eventVenue;
    private decorationType decoration;
    private double price;
    private static double totalRevenue;
    private static int eventCount;
    private ArrayList<Product> eventProducts;
    private ArrayList<Participant> participantsArr;
    private int eventAttendance;

    public Event() {
    }

    ;
    public Event(String eventName, LocalDate eventDate, LocalTime eventTime,
            venueType eventVenue, decorationType decoration, ArrayList<Product> eventProducts,
            ArrayList<Participant> participantsArr) {
        eventID = "E" + nextEvent++;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.decoration = decoration;
        this.eventProducts = eventProducts;
        this.participantsArr = participantsArr;
        eventAttendance = 0;
        price = (double) decoration.price;
        totalRevenue += price;
        eventCount++;

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

    public venueType getEventVenue() {
        return eventVenue;
    }

    public decorationType getDecoration() {
        return decoration;
    }

    public double getPrice() {
        return price;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static void deductTotalRevenue(double amount) {
        totalRevenue = totalRevenue - amount;
    }

    public static void addTotalRevenue(double amount) {
        totalRevenue = totalRevenue + amount;
    }

    public static int getEventCount() {
        return eventCount;
    }

    public ArrayList<Product> getEventProducts() {
        return eventProducts;
    }

    public ArrayList<Participant> getParticipantsArr() {
        return participantsArr;
    }

    public int getEventAttendance() {
        return eventAttendance;
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

    public void setEventVenue(venueType eventVenue) {
        this.eventVenue = eventVenue;
    }

    public void setEventProducts(ArrayList<Product> eventProducts) {
        this.eventProducts = eventProducts;
    }

}
