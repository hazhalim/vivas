/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viva;

/**
 *
 * @author tmhta_
 */
public class Phantom {
    private double accuracy;
    private double critRate;

    public Phantom() {
        this.accuracy = 1.00;
        this.critRate = 1.00;
    }

    public Phantom(double accuracy, double critRate) {
        if (accuracy >= 0.00 && accuracy <= 1.00) {
            this.accuracy = accuracy;
        } else {
            this.accuracy = 1.00;
        }
        if (critRate >= 0.00 && critRate <= 1.00) {
            this.critRate = critRate;
        } else {
            this.critRate = 1.00;
        }
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        if (accuracy >= 0.00 && accuracy <= 1.00) {
            this.accuracy = accuracy;
        }
    }

    public double getCritRate() {
        return critRate;
    }

    public void setCritRate(double critRate) {
        if (critRate >= 0.00 && critRate <= 1.00) {
            this.critRate = critRate;
        }
    }

    public int damage(BlackMage blackMage) {
        double totalEffectiveAccuracy = accuracy * (1 - blackMage.getEvasion());
        double totalEffectiveCritRate = critRate - blackMage.getCritResistance();
        double random = Math.random();

        if (random < totalEffectiveAccuracy) {
            if (random < totalEffectiveCritRate) {
                return 4; // Critical hit
            } else {
                return 2; // Normal hit
            }
        } else {
            return 0; // Missed hit
        }
    }

    public String toString() {
        return "Combat Log:\nAccuracy: " + accuracy + "\nCrit Rate: " + critRate;
    }

    public boolean isAlive() {
        return accuracy > 0;
    }
}
