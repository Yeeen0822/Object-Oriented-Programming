
package assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static boolean vldCardExp(String cardExp) {
        // Regular expression for a cardExp
        String cardExpRegex = "^(0[1-9]|1[0-2])/([3-9]\\d)$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(cardExpRegex);

        // Match the cardExp against the pattern
        Matcher matcher = pattern.matcher(cardExp);

        // Check if the cardExp matches the pattern
        return matcher.matches(); // True for valid, false for invalid
    }
    
    //validate cardCVV

    public static boolean vldCardCvv(String cardCVV) {
        // Regular expression for a card CVV
        String cardCVVRegex = "^\\d{3,4}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(cardCVVRegex);

        // Match the cardCVV against the pattern
        Matcher matcher = pattern.matcher(cardCVV);

        // Check if the card cvv matches the pattern
        return matcher.matches(); // True for valid, false for invalid
    }
    @Override
    public String toString() {
        System.out.println("+------------------------------+\n");
        System.out.println("\tRECEIPT\n");
        System.out.println("+------------------------------+\n");
        return  "DATE: " + getPaymentDate() + "\n" +
                "BOOKING ID: " + "\n" +
                "CARD NUMBER:" + cardNum+ "\n"+
                "--------------------------------\n" +
                "TOTAL AMOUNT    : RM " + String.format("%.2f", getPaymentAmount()) + "\n" +
                "--------------------------------\n" +
                "\tBOOKING SUCCESSFUL\n" +
                "--------------------------------";
    }
    
        
 

}
