/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jason
 */
public class Card extends Payment {

    private String cardNum;
    private String cardHolder;
    private String cardExp;
    private String cardCVV;

    public Card() {
    }

    public Card(String cardNum, String cardHolder, String cardExp, String cardCVV, double paymentAmount) {
        super(paymentAmount);
        this.cardNum = cardNum;
        this.cardHolder = cardHolder;
        this.cardExp = cardExp;
        this.cardCVV = cardCVV;
    }

    //validate cardEXP
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
