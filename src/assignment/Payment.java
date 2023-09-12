/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;

public class Payment {
    private LocalDate paymentDate;
    private double paymentAmount;
    private boolean paid;
    
    public Payment(){}
    public Payment(double paymentAmount){
        paymentDate = LocalDate.now();
        this.paymentAmount = paymentAmount; 
        
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void makePayment(){
        paid = true;
    }
    public void cancelPayment(){
        paid = false;
    }
    
}
