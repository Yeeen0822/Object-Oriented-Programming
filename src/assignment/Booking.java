/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;

public class Booking {
    private int bookingNum;
    private Organizer exhibitor;
    private Event event;
    private static ArrayList<Event> eventList = new ArrayList<>();
    private Payment paymentMethod;
    private static int nextBookingNum = 100;
    
    public Booking(){}
    public Booking(Organizer exhibitor, Event event, Payment paymentMethod){
        bookingNum = nextBookingNum++;
        this.exhibitor = exhibitor;
        this.event = event;
        this.paymentMethod = paymentMethod;
        eventList.add(event);
    }

    public void setExhibitor(Organizer exhibitor) {
        this.exhibitor = exhibitor;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static ArrayList<Event> getEventList() {
        return eventList;
    }

    public int getBookingNum() {
        return bookingNum;
    }

    public Organizer getExhibitor() {
        return exhibitor;
    }

    public Event getEvent() {
        return event;
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
    @Override
    public String toString(){
        return String.format("%-15s", bookingNum);
    }
}
