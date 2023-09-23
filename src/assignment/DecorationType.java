/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package assignment;

/**
 *
 * @author Jason
 */
public enum DecorationType {
    LUXURY(9888),
    ORDINARY(5888);

    final int price;

    DecorationType(int price) {
        this.price = price;
    }

}
