/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exhibitor extends Person {

    private String companyName;
    private String IC;
    private static int exhibitorCount;
    private ArrayList<Product> products;

    public Exhibitor() {
    }

    public Exhibitor(String companyName, String IC, ArrayList<Product> products, String name, String email, String phoneNo) {
        super(name, email, phoneNo);
        this.companyName = companyName;
        this.IC = IC;
        this.products = products;
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
