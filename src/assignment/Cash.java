/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

public class Cash extends Payment {
    private double amountTendered;
    private double changeAmount;
    
    public Cash(){}

    public Cash(double amountTendered, double paymentAmount) {
        super(paymentAmount);
        this.amountTendered = amountTendered;
        changeAmount = amountTendered - paymentAmount;
    }
    
    public double getChangeAmount(){
        return changeAmount;
    }
    
}
