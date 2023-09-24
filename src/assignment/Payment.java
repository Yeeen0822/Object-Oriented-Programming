/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Payment {

    private LocalDate paymentDate;
    private double paymentAmount;
    private String paymentStatus;

    public Payment() {
    }

    public Payment(double paymentAmount) {
        paymentDate = LocalDate.now();
        this.paymentAmount = paymentAmount;

    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void makePayment() {
        paymentStatus = "Paid";
    }

    public void pendingPayment() {
        paymentStatus = "Pending";
    }

    public void cancelPayment() {
        paymentStatus = "Cancelled";
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("+------------------------------+\n");
        System.out.println("\tRECEIPT\n");
        System.out.println("+------------------------------+\n");
        return "DATE: " + getPaymentDate().format(dateFormatter) + "\n"
                + "TOTAL AMOUNT    : RM " + String.format("%.2f", getPaymentAmount()) + "\n";

    }

}
