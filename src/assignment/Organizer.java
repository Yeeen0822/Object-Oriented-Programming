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
    private static int organizerCount;


    public Organizer() {
    }

    public Organizer(String companyName, String IC, String name, String email, String phoneNo) {
        super(name,IC, email, phoneNo);
        organizerID = "C" + nextOrganizer++;
        this.companyName = companyName;

    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    
    public String getExhibitorID() {
        return organizerID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public static int getExhibitorCount() {
        return organizerCount;
    }



    public static boolean vldIC(String IC) {
        // Regular expression for a Malaysian IC
        String icRegex = "^[0-9]{12}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(icRegex);

        // Match the phone number against the pattern
        Matcher matcher = pattern.matcher(IC);

        // Check if the IC matches the pattern
        return matcher.matches(); // True for valid, false for invalid
    }

}
