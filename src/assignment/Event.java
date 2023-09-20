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
    private int promoterNum;
    private ArrayList<Product> eventProducts;
    private ArrayList<Participant> participantArr;
    private int eventAttendance;
    private static double totalRevenue = 0;
    private static int eventCount = 0;

    public Event() {
        
    };
    
    public Event(String eventName, LocalDate eventDate, LocalTime eventTime,
            venueType eventVenue, decorationType decoration, int promoterNum, ArrayList<Product> eventProducts) {
        
        eventID = "E" + nextEvent++;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventVenue = eventVenue;
        this.decoration = decoration;
        this.promoterNum = promoterNum;
        this.eventProducts = eventProducts;
        participantArr = new ArrayList<>();
        eventAttendance = 0;
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

    public ArrayList<Participant> getParticipantArr() {
        return participantArr;
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
    
    public double calcFees(){
       return decoration.price + eventVenue.price;
    }

    public int getPromoterNum() {
        return promoterNum;
    }
    
    


}
