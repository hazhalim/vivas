import java.util.Random;

public class Phantom
{

    // Instance variables
    Random rand = new Random();

    private double accuracy;
    private double critRate;

    // Constructors
    public Phantom() // Default constructor
    {

        this.accuracy = 1.00;
        this.critRate = 1.00;

    }

    public Phantom(double accuracy, double critRate)
    {

        this.accuracy = accuracy;
        this.critRate = critRate;

    }

    // Getter and setter methods
    // Getter methods
    double getAccuracy()
    {

        return this.accuracy;

    }

    double getCritRate()
    {

        return this.critRate;

    }

    // Setter methods
    void setAccuracy(double accuracy)
    {

        if ((accuracy >= 0.00) && (accuracy <= 1.00))
        {

            this.accuracy = accuracy;

        } else {

            throw new IllegalArgumentException("Accuracy must be set between 0.00 and 1.00");

        }

    }

    void setCritRate(double critRate)
    {

        if ((critRate >= 0.00) && (critRate <= 1.00))
        {

            this.critRate = critRate;

        } else {

            throw new IllegalArgumentException("Crit rate must be set between 0.00 and 1.00");

        }

    }

    // Other methods
    int damage(BlackMage blackMage)
    {

        double effectiveAccuracy = getAccuracy() * blackMage.getEvasion();
        double effectiveCritRate = getCritRate() - blackMage.getCritResistance();

        double min = 0.00;
        double max = 1.00 + 0.01; // max is exclusive, so add 0.01

        double actualAccuracy = rand.nextDouble(max - min) + min;
        double actualCritRate = rand.nextDouble(max - min) + min;

        if ((actualAccuracy > effectiveAccuracy) && (actualCritRate <= effectiveCritRate))
        {

            return 4;

        } else if ((actualAccuracy > effectiveAccuracy) && (actualCritRate > effectiveCritRate)) {

            return 2;

        } else {

            return 0;

        }

    }

    public String toString(int damage, int hp)
    {

        if (damage == 4)
        {

            return "[CRIT] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/100)";

        } else if (damage == 2) {

            return "[NORM] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/100)";

        } else if (damage == 0) {

            return "[MISS] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/100)";

        } else {

            return "[ERROR] Damage is neither 4, nor 2, nor 0";

        }

    }

}

//    int currentDamage = damage(blackMage);
//
//        blackMage.setHP(blackMage.getHp() - currentDamage);
//
//                if (blackMage.getHp() == 100)
//                {
//
//                System.out.println("The epic battle begins!");
//
//                int currentDamage = damage(blackMage);
//
//                blackMage.setHP(blackMage.getHp() - currentDamage);
//
//                toString(blackMage);
//
//                } else if ((blackMage.getHp() < 100) && (blackMage.getHp() > 0)) {
//
//        if ()
//
//        }
//
//
//        while (blackMage.getHp() > 0)
//        {
//
//        int currentDamage = damage(blackMage);
//
//        blackMage.setHP(blackMage.getHp() - currentDamage);
//
//        if (currentDamage == 4)
//        {
//
//        System.out.println("[CRIT] Phantom has dealt " + currentDamage + " damage to the Black Mage (" + blackMage.getHp() + "/100)");
//
//        } else if (currentDamage == 2) {
//
//        System.out.println("[NORM] Phantom has dealt " + currentDamage + " damage to the Black Mage (" + blackMage.getHp() + "/100)");
//
//        }
//
//        }
//
//        System.out.println("The Black Mage is defeated...");
//
//        }