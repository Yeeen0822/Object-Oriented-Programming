/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Admin extends Person {
    private String password;
    
    public Admin(){};
    public Admin(String name, String email, String phoneNo, String password){
        super(name, email, phoneNo);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
}
