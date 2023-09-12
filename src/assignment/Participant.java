/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Participant extends Person{
    private Event eventParticipate;
    private Product interestedProduct;
    
    public Participant(){};
    public Participant(Event eventParticipate, Product interestedProduct){
        this.eventParticipate = eventParticipate;
        this.interestedProduct = interestedProduct;
    };

    public Event getEventParticipate() {
        return eventParticipate;
    }

    public void setEventParticipate(Event eventParticipate) {
        this.eventParticipate = eventParticipate;
    }

    public Product getInterestedProduct() {
        return interestedProduct;
    }

    public void setInterestedProduct(Product interestedProduct) {
        this.interestedProduct = interestedProduct;
    }
    
    
}
