/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PhoneEvent extends Event {

    private int techTalkSession;
    private int demoStation;
    private static double phonePromoterRate = 120;

    public PhoneEvent() {
    }

    public PhoneEvent(int techTalkSession, int demoStation, String eventName, LocalDate eventDate, LocalTime eventTime,
            VenueType eventVenue, DecorationType decoration, int promoterNum, ArrayList<Product> eventProducts) {
        super(eventName, eventDate, eventTime, eventVenue, decoration, promoterNum, eventProducts);
        this.techTalkSession = techTalkSession;
        this.demoStation = demoStation;
    }

    @Override
    public double calcFees() {
        return super.calcFees() + (super.getPromoterNum() * phonePromoterRate) + (techTalkSession * 50 ) + (demoStation *75);

    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNumber Of Tech Talk Sessions: " + techTalkSession
                + "\nNumber Of Demo Stations: " + demoStation
                + "\nProducts of Event: "
                + super.viewAllProducts(super.getEventProducts());
    }

}
