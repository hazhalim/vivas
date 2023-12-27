/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva;

/**
 *
 * @author tmhta_
 */
public class Main {

    public static void main(String[] args) {
        Phantom phantom = new Phantom();
        BlackMage blackMage = new BlackMage();

        System.out.println(phantom.toString());

        while (phantom.isAlive() && blackMage.isAlive()) {
            int damageDealt = phantom.damage(blackMage);
            int remainingHP = blackMage.getHp() - damageDealt;
            remainingHP = Math.max(remainingHP, 0);

            System.out.println("Phantom has dealt " + damageDealt + " damage to the Black Mage (" + remainingHP + "/100)");

            blackMage.setHp(remainingHP);
        }

        if (!phantom.isAlive()) {
            System.out.println("Phantom has been defeated!");
        } else {
            System.out.println("Black Mage has been defeated!");
        }
    }
}
