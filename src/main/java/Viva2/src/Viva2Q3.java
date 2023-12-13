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

    public static void outputArray(String[] array)
    {
        System.out.print("{");
        
        for (int i = 0; i < array.length; i++)
        {
            if (i != (array.length - 1))
                System.out.print("\"" + array[i] + "\", ");
            else
                System.out.print("\"" + array[i] + "\"");
        }
        
        System.out.print("}");
    }
    
    public static void outputArray(boolean[] array)
    {
        System.out.print("{");
        
        for (int i = 0; i < array.length; i++)
        {
            if (i != (array.length - 1))
                System.out.print(array[i] + ", ");
            else
                System.out.print(array[i]);
        }
        
        System.out.print("}");
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
                System.out.println("Error on " + i + "-th iteration! isNumeric(" + array[i] + ") returns neither true nor false!");
                break;
            }
        }

        return booleanArray;
    }

    public static void main(String[] args)
    {
        String[] strArray = new String[6];

        System.out.println("\nInput the elements of the String array: ");

        inputStrArray(strArray);

        System.out.println("\nElements of String array: ");

        outputArray(strArray);

        System.out.println("\nElements of converted Boolean array: ");

        outputArray(convertStrToBooleanArray(strArray));
    }
}