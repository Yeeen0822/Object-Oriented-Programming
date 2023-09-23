/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package assignment;

public enum SeatType {
    VIP(500),
    Normal(350);
    final double  price;

    SeatType(double price ){
        this.price = price;
    }

}
