public class BlackMage
{

    // Instance variables
    private int hp;
    private double evasion;
    private double critResistance;

    // Constructors
    public BlackMage() // Default constructor
    {

        this.hp = 100;
        this.evasion = 0.05;
        this.critResistance = 0.10;

    }

    public BlackMage(int hp, double evasion, double critResistance)
    {

        this.hp = hp;
        this.evasion = evasion;
        this.critResistance = critResistance;

    }

    // Getter and setter methods
    // Getter methods
    int getHp()
    {

        return this.hp;

    }

    double getEvasion()
    {

        return this.evasion;

    }

    double getCritResistance()
    {

        return this.critResistance;

    }

    // Setter methods
    void setHP(int hp)
    {

        if ((hp >= 0) && (hp <= 100))
        {

            this.hp = hp;

        } else {

            throw new IllegalArgumentException("HP must be set between 0 and 100");

        }

    }

    void setEvasion(double evasion)
    {

        if ((evasion >= 0.00) && (evasion <= 1.00))
        {

            this.evasion = evasion;

        } else {

            throw new IllegalArgumentException("Evasion must be set between 0.00 and 1.00");

        }

    }

    void setCritResistance(double critResistance)
    {

        if ((critResistance >= 0.00) && (critResistance <= 1.00))
        {

            this.critResistance = critResistance;

        } else {

            throw new IllegalArgumentException("Crit resistance must be set between 0.00 and 1.00");

        }

    }

    // Other methods

}