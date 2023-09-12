/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;


/**
 *
 * @author Jason
 */
public class Card extends Payment{
    private String cardNum;
    private String cardHolder;
    private String cardExp;
    private String cardCVV;
    
    public Card(){}

    public Card(String cardNum, String cardHolder, String cardExp, String cardCVV, double paymentAmount) {
        super(paymentAmount);
        this.cardNum = cardNum;
        this.cardHolder = cardHolder;
        this.cardExp = cardExp;
        this.cardCVV = cardCVV;
    }
    
    
    
    
}
