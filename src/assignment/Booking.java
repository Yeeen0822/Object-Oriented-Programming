/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;

public class Booking {
    private int bookingNum = 100;
    private Exhibitor exhibitor;
    private Event event;
    private static ArrayList<Event> eventList = new ArrayList<>();
    private Payment paymentMethod;
    private static int nextBookingNum ;
    
    public Booking(){}
    public Booking(Exhibitor exhibitor, Event event, Payment paymentMethod){
        bookingNum = ++nextBookingNum;
        this.exhibitor = exhibitor;
        this.event = event;
        this.paymentMethod = paymentMethod;
        eventList.add(event);
    }

    public void setExhibitor(Exhibitor exhibitor) {
        this.exhibitor = exhibitor;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static ArrayList<Event> getEventList() {
        return eventList;
    }
    
}
