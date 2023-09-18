
package assignment;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person {

    private String name;
    private String email;
    private String phoneNo;
    private String IC;

    public Person() {
    }

    
   public Person(String name,String IC,String email, String phoneNo) {
        this.name = name;
        this.IC = IC;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }
    
    public String getIC(){
        return IC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public static boolean vldIC(String IC){
        
        String ICRegex = "^(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])-(0[1-9]|[1-9][0-9])-[0-9]{3}[0-9A-F]$";
        Pattern pattern = Pattern.compile(ICRegex);
        Matcher matcher = pattern.matcher(IC);
        return matcher.matches();
    }
            
    public static boolean vldEmail(String email) {
        // Regular expression for a valid email address
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Match the email against the pattern
        Matcher matcher = pattern.matcher(email);

        // Check if the email matches the pattern
        return matcher.matches(); // True for valid, false for invalid

    }

    public static boolean vldPhoneNumber(String phoneNumber) {
        // Regular expression for a Malaysian phone number starting with "01" followed by 8 digits
        String phoneRegex = "^(01[0-9])[0-9]{7,8}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(phoneRegex);

        // Match the phone number against the pattern
        Matcher matcher = pattern.matcher(phoneNumber);

        // Check if the phone number matches the pattern
        return matcher.matches(); // True for valid, false for invalid
    }

}
