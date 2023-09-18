/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Admin extends Person {
    private String password;
    private String adminID;
    private static int adminCount = 1;
    
    public Admin(){
    };
    public Admin(String name,String IC,String email, String phoneNo, String password){
        super(name,IC, email, phoneNo);
        this.password = password;
        adminID = generateAdminID();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    

    public String getAdminID() {
        return adminID;
    }
    
    private String generateAdminID(){
        return "A" + adminCount++;
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
    
    
}
