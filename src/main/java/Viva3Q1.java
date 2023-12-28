import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Viva3Q1
{

    static Scanner keyboard = new Scanner(System.in);
    static Random rand = new Random();
    static DecimalFormat decimalFormat = new DecimalFormat("#.##");

    static double min = 0.00;
    static double max = 1.00 + 0.01; // max is exclusive, so add 0.01

    static int minInt = 50;
    static int maxInt = 100 + 1; // maxInt is exclusive, so add 1

    static int minCritical = 4;
    static int maxCritical = 8 + 1; // maxCritical is exclusive, so add 1
    static int minNormal = 2;
    static int maxNormal = 3 + 1; // maxNormal is exclusive, so add 1
    static int minMiss = 0;
    static int maxMiss = 1 + 1; // maxMiss is exclusive, so add 1

    static double phantomAccuracy = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));
    static double phantomCritRate = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));

    static int phantomCriticalDamage = rand.nextInt(maxCritical - minCritical) + minCritical;
    static int phantomNormalDamage = rand.nextInt(maxNormal - minNormal) + minNormal;
    static int phantomMissDamage = rand.nextInt(maxMiss - minMiss) + minMiss;
    static int blackMageHP = rand.nextInt(maxInt - minInt) + minInt;
    static double blackMageEvasion = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));
    static double blackMageCritResistance = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));

    public static void main(String[] args)
    {

        System.out.println("MapleStory: Phantom vs. Black Mage\n");

        System.out.printf("Phantom's accuracy: %.2f\n", phantomAccuracy);
        System.out.printf("Phantom's critical damage rate: %.2f\n", phantomCritRate);
        System.out.println("Phantom's critical damage value: " + phantomCriticalDamage);
        System.out.println("Phantom's normal damage value: " + phantomNormalDamage);
        System.out.println("Phantom's miss damage value: " + phantomMissDamage);
        System.out.println("Black Mage's HP: " + blackMageHP);
        System.out.printf("Black Mage's evasion rate: %.2f\n", blackMageEvasion);
        System.out.printf("Black Mage's critical resistance rate: %.2f\n\n", blackMageCritResistance);

        Phantom phantom = new Phantom(phantomAccuracy, phantomCritRate);
        BlackMage blackMage = new BlackMage(blackMageHP, blackMageEvasion, blackMageCritResistance);

        System.out.println("The epic battle begins!");

        while (blackMage.getHp() > 0)
        {

            int currentDamage = phantom.damage(blackMage);

            if (blackMage.getHp() - currentDamage <= 0) // If we know that the next hit will drop the HP to below zero, end the battle immediately
            {

                blackMage.setHP(0);

            } else {

                blackMage.setHP(blackMage.getHp() - currentDamage);

            }

            System.out.println(phantom.toString(currentDamage, blackMage.getHp()));

        }

        System.out.println("The Black Mage is defeated...");

    }

}