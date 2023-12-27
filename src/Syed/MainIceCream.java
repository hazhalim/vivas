/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Syed;

/**
 *
 * @author tmhta_
 */
public class MainIceCream {

    public static void main(String[] args) {
        IceCreamContainer container = new IceCreamContainer();

        container.addIceCream("Chocolate", 150.0);
        container.addIceCream("Mint", 100.0);
        container.addIceCream("Vanilla", 120.0);

        double scoopRadius = 2.0;
        int scoop = 3;
        double scoopVolume = container.calculateVolume(scoopRadius, scoop);
        System.out.printf("Volume of %d scoop(s) of ice-cream with radius %.1f is %.2f", scoop, scoopRadius, scoopVolume);
        System.out.println("");
        container.scoopIceCream("Chocolate", 40.0);
        container.scoopIceCream("Mint", 40.0);

        System.out.println("Remaining volume after scooping 40.0 cm3 of Chocolate is " + container.remainingVolume("Chocolate") + "\n");

        double chocoVolume = 150.0;
        double mintVolume = 100.0;

        boolean isChocoMintBlissReady = container.prepareIceCream("Chocolate", chocoVolume) && container.prepareIceCream("Mint", mintVolume);

        System.out.println("Preparing Choco-Mint Bliss Recipe...");

        if (isChocoMintBlissReady) {
            System.out.println("Choco-Mint Bliss is ready!");
        } else {
            System.out.println("Not enough Chocolate or Mint ice cream to prepare Choco-Mint Bliss.");
        }
    }
}
