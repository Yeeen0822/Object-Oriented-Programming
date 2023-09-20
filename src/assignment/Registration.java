/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author wongy
 */
public class Registration {
    private int regNum;
    private static int nextRegNum = 1;
    private Event event;
    private Participant participant;
    private Payment payment;
    
    public Registration(){
        
    }
    
    public Registration(Event event,Participant participant){
        this.participant = participant;
        this.event = event;
        regNum = nextRegNum++;
    }
    
    
}
