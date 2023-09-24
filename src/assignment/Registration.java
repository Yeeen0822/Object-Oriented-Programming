/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author wongy
 */
public class Registration implements Comparable<Registration> {

    private int regNum;
    private static int nextRegNum = 1;
    private Event event;
    private Participant participant;
    private Payment payment;
    private SeatType seatType;

    public Registration() {

    }

    public Registration(Event event, Participant participant, Payment payment, SeatType seatType) {
        this.participant = participant;
        this.event = event;
        this.seatType = seatType;
        this.payment = payment;
        regNum = nextRegNum++;
    }

    @Override
    public int compareTo(Registration other) {
        // Compare registrations based on participant names
        return this.participant.getName().compareTo(other.participant.getName());
    }

    @Override
    public String toString() {
        //"%-20s%-15s%-20s%-15s"
        return String.format("%-70s %-15s %-10s", participant.toString(), event.getEventName(), seatType);
    }

}
