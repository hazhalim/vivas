import java.util.Scanner;

public class Viva2Q3
{
    static Scanner keyboard = new Scanner(System.in);

    public static void inputStrArray(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = keyboard.nextLine();
        }
    }

    public static void outputStrArray(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("i = " + i + ", \"" + array[i] + "\"");
        }
    }

    public static void outputBooleanArray(boolean[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("i = " + i + ", " + array[i]);
        }
    }

    public static boolean isNumeric(String numberStr)
    {
        try
        {
            Double.parseDouble(numberStr);

            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }

    public static boolean[] convertStrToBooleanArray(String[] array)
    {
        boolean[] booleanArray = new boolean[array.length];

        for (int i = 0; i < booleanArray.length; i++)
        {
            if (isNumeric(array[i]))
            {
                booleanArray[i] = true;
            } else if (!isNumeric(array[i])) {
                booleanArray[i] = false;
            } else {
                System.out.println("Error on " + i + "-th iteration! isNumeric(" + array[i] + ") returns neither true or false!");
                break;
            }
        }

        return booleanArray;
    }

    public static void main(String[] args)
    {
        System.out.print("Enter size of a String array, n: ");

        int n = keyboard.nextInt();

        keyboard.nextLine(); // Accepts the \n (Enter key) after entering value of n so that value at i = 0 is not constantly empty

        String[] strArray = new String[n];

        System.out.println("\nInput the elements of the String array:");

        inputStrArray(strArray);

        System.out.println("\nElements of String array: ");

        outputStrArray(strArray);

        System.out.println("\nElements of converted Boolean array: ");

        outputBooleanArray(convertStrToBooleanArray(strArray));
    }
}