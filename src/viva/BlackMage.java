/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva;

/**
 *
 * @author tmhta_
 */
public class BlackMage {
    private int hp;
    private double evasion;
    private double critResistance;

    public BlackMage() {
        this.hp = 100;
        this.evasion = 0.05;
        this.critResistance = 0.10;
    }

    public int getHp() {
        return hp;
    }

    public double getEvasion() {
        return evasion;
    }

    public double getCritResistance() {
        return critResistance;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
