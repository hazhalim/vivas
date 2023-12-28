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

            return Viva3Q1.phantomCriticalDamage;

        } else if ((actualAccuracy > effectiveAccuracy) && (actualCritRate > effectiveCritRate)) {

            return Viva3Q1.phantomNormalDamage;

        } else {

            return Viva3Q1.phantomMissDamage;

        }

    }

    public String toString(int damage, int hp)
    {

        if (damage == Viva3Q1.phantomCriticalDamage)
        {

            return "[CRIT] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/" + Viva3Q1.blackMageHP + ")";

        } else if (damage == Viva3Q1.phantomNormalDamage) {

            return "[NORM] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/" + Viva3Q1.blackMageHP + ")";

        } else if (damage == Viva3Q1.phantomMissDamage) {

            return "[MISS] Phantom has dealt " + damage + " damage to the Black Mage (" + hp + "/" + Viva3Q1.blackMageHP + ")";

        } else {

            return "[ERROR] Damage is neither the critical, normal, nor miss value";

        }

    }

}