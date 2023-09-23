/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;

public class Booking {
    private int bookingNum;
    private Organizer organizer;
    private Event event;
    private Payment paymentMethod;
    private static int nextBookingNum = 100;
    
    public Booking(){}
    public Booking(Organizer organizer, Event event, Payment paymentMethod){
        bookingNum = nextBookingNum++;
        this.organizer = organizer;
        this.event = event;
        this.paymentMethod = paymentMethod;

    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public int getBookingNum() {
        return bookingNum;
    }

    public Organizer getOrganizer() {
        return organizer;
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
        return String.format("%-15s %-15s %-15s %-15s %-15s", bookingNum, getOrganizer().getName(),getOrganizer().getName(), getEvent().getEventName(), getPaymentMethod().getPaymentStatus());
    }
}
