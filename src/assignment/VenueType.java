/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package assignment;

/**
 *
 * @author Jason
 */
public enum VenueType {
    Pavilion(500),
    Midvalley(350),
    Genting(600);
    final int price;

    VenueType(int price) {
        this.price = price;
    }
}
