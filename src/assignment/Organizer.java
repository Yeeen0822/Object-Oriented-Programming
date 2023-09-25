/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Organizer extends Person {
    
    private static int nextOrganizer = 100;
    private String organizerID;
    private String companyName;
    private String IC;
    private static int organizerCount = 0;


    public Organizer() {
    }

    public Organizer(String companyName, String IC, String name, String email, String phoneNo) {
        super(name,IC, email, phoneNo);
        organizerID = "C" + nextOrganizer++;
        this.companyName = companyName;
        Organizer.organizerCount++;

    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
    public String getOrganizerID() {
        return organizerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public static int getOrganizerCount() {
        return organizerCount;
    }


    
    @Override
    public String toString(){
        return String.format("%-15s %-15s %-15s %-15s", super.getName(), super.getPhoneNo(),super.getEmail(), companyName);
    }

}
