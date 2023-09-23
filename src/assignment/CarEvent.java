/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class CarEvent extends Event {

    private String carEventTheme;
    private int numTestDriveLocation;
    private static double carPromoterRate = 250;

    public CarEvent() {

    }

    public CarEvent(String carEventTheme, int numTestDriveLocation, String eventName, LocalDate eventDate, LocalTime eventTime,
            VenueType eventVenue, DecorationType decoration, int promoterNum, ArrayList<Product> eventProducts) {
        super(eventName, eventDate, eventTime, eventVenue, decoration, promoterNum, eventProducts);
        this.carEventTheme = carEventTheme;
        this.numTestDriveLocation = numTestDriveLocation;
    }

    @Override
    public double calcFees() {
        //formula to calcFees = DecorationPrice + EventVenuePrice + (Num of products*100) + (Promoter Number * promoterRate) + (numTestDriveLocation * 50)
        return super.calcFees() + (super.getPromoterNum() * carPromoterRate) + (numTestDriveLocation * 50);

    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCar Event Theme: " + carEventTheme
                + "\nNumber Of Test Drive Locations: " + numTestDriveLocation
                + "\nProducts of Event: "
                + super.viewAllProducts(super.getEventProducts());
    }
}
