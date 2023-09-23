
package assignment;

public enum DecorationType {
    Luxury(9888), 
    Ordinary(5888);
    
    final int price;
    
    DecorationType(int price){
        this.price = price;
    }
}
