/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends Person {
    private String password;
    private String adminID;
    private static int adminCount = 1;
    
    public Admin(){
    };
    public Admin(String name,String IC,String email, String phoneNo, String password){
        super(name,IC, email, phoneNo);
        this.password = password;
        adminID = "A" + adminCount++;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminID() {
        return adminID;
    }
    

    public String getPassword() {
        return password;
    }

    public static int getAdminCount() {
        return adminCount;
    }

    public static boolean vldAdminID(String adminID){
        // Define the regular expression pattern for the admin ID
        String regexPattern = "^A\\d$"; // A followed by a single digit
        
        // Create a Pattern object
        Pattern pattern = Pattern.compile(regexPattern);
        
        // Create a Matcher object
        Matcher matcher = pattern.matcher(adminID);
        
        // Check if the input matches the pattern
        return matcher.matches();
    }

    public static boolean vldPassword(String password) {
        boolean hasAlpha = false;
        boolean hasNum = false;
        boolean enoughLength = false;

        if (password.length() >= 6) {
            enoughLength = true;
        }

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasNum = true;
                break;
            }
        }

        for (int j = 0; j < password.length(); j++) {
            if (Character.isLetter(password.charAt(j))) {
                hasAlpha = true;
                break;
            }
        }

        if (hasAlpha == true && hasNum == true && enoughLength == true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        return String.format("%-10s", adminID) + super.toString();
                
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        
        Admin admin = (Admin) o;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;
        return adminID != null ? adminID.equals(admin.adminID) : admin.adminID == null;
    }
    
}

