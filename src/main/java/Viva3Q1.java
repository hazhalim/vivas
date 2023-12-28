import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Viva3Q1
{

    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);
        Random rand = new Random();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        double min = 0.00;
        double max = 1.00 + 0.01; // max is exclusive, so add 0.01

        double phantomAccuracy = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));
        double phantomCritRate = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));

        int blackMageHP = 100;
        double blackMageEvasion = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));
        double blackMageCritResistance = Double.parseDouble(decimalFormat.format(rand.nextDouble(max - min) + min));

        System.out.println("MapleStory: Phantom vs. Black Mage\n");

        System.out.printf("Phantom's accuracy: %.2f\n", phantomAccuracy);
        System.out.printf("Phantom's critical damage rate: %.2f\n", phantomCritRate);
        System.out.println("Black Mage's HP: 100");
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