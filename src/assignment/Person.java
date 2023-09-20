
package assignment;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public abstract class Person {

    private String name;
    private String IC;
    private String email;
    private String phoneNo;

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
        String ICRegex = "^[0-9]{12}$";
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
    
    @Override
    public String toString(){
        return String.format("%-20s%-15s%-20s%-15s",name,IC,email,phoneNo);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        if (IC != null ? !IC.equals(person.IC) : person.IC != null) return false;
        if (email != null ? !email.equals(person.email) : person.email != null) return false;
        return phoneNo != null ? phoneNo.equals(person.phoneNo) : person.phoneNo == null;  
    }
}
