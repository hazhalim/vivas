import java.util.Scanner;

public class Viva2Q1Ammar
{
    static Scanner keyboard = new Scanner(System.in);
    
    public static String inputPassword()
    {
        
        String password;
        
        System.out.print("Enter a password: ");
        
        password = keyboard.nextLine();
        
        System.out.println("");
        
        return password;
        
    }
    
    public static boolean meetsCharacterLength(String password)
    {
        
        if (password.length() >= 8)
            return true;
        else
            System.out.println("The password \"" + password + "\" needs to be at least 8 characters.");
            return false;
            
    }
    
    public static boolean meetsUppercaseLetter(String password)
    {
        
        for (int i = 0; i < password.length(); i++)
        {
            
            int currentASCII = (int) password.charAt(i);
            
            if ((currentASCII >= 65) && (currentASCII <= 90))
                return true;
            
        }
        
        System.out.println("The password \"" + password + "\" needs to have at least one capital letter.");
        
        return false;
        
    }
    
    public static boolean meetsLowercaseLetter(String password)
    {
        
        for (int i = 0; i < password.length(); i++)
        {
            
            int currentASCII = (int) password.charAt(i);
            
            if ((currentASCII >= 97) && (currentASCII <= 122))
                return true;
            
        }
        
        System.out.println("The password \"" + password + "\" needs to have at least one small letter.");
        
        return false;
        
    }
    
    public static boolean meetsDigitLength(String password)
    {
        
        int numberOfDigits = 0;
        
        for (int i = 0; i < password.length(); i++)
        {
            
            int currentASCII = (int) password.charAt(i);
            
            if ((currentASCII >= 48) && (currentASCII <= 57))
                numberOfDigits++;
            
        }
        
        if (numberOfDigits >= 3)
        {
            
            return true;
            
        } else {
            
            System.out.println("The password \"" + password + "\" needs to have at least three digits.");
            
            return false;
            
        }
        
    }
    
    public static boolean meetsSpecialLength(String password)
    {
        
        int numberOfSpecialCharacters = 0;
        
        for (int i = 0; i < password.length(); i++)
        {
            
            int currentASCII = (int) password.charAt(i);
            
            switch (currentASCII)
            {
                
                case 33 -> numberOfSpecialCharacters++;
                case 64 -> numberOfSpecialCharacters++;
                case 35 -> numberOfSpecialCharacters++;
                case 36 -> numberOfSpecialCharacters++;
                case 37 -> numberOfSpecialCharacters++;
                case 94 -> numberOfSpecialCharacters++;
                case 38 -> numberOfSpecialCharacters++;
                case 42 -> numberOfSpecialCharacters++;
                case 40 -> numberOfSpecialCharacters++;
                case 41 -> numberOfSpecialCharacters++;
                case 45 -> numberOfSpecialCharacters++;
                case 43 -> numberOfSpecialCharacters++;
                
            }
            
        }
        
        if (numberOfSpecialCharacters == 1)
        {
            
            return true;
            
        } else {
            
            System.out.println("The password \"" + password + "\" needs to have exactly ONE special character.");
            
            return false;
            
        }
        
    }
    
    public static boolean isPasswordValid(String password)
    {   
        
        boolean passwordValidFlag = true;
        
        if (!meetsCharacterLength(password))
            passwordValidFlag = false;
        
        if (!meetsUppercaseLetter(password))
            passwordValidFlag = false;
        
        if (!meetsLowercaseLetter(password))
            passwordValidFlag = false;
        
        if (!meetsDigitLength(password))
            passwordValidFlag = false;
        
        if (!meetsSpecialLength(password))
            passwordValidFlag = false;
        
        if (passwordValidFlag)
        {
            
            System.out.println("The password \"" + password + "\" is valid.");
        
            return true;
            
        } else {
            
            System.out.println("The password \"" + password + "\" is NOT a valid password.");
            
            return false;
            
        }
        
    }
    
    public static void main(String[] args)
    {
        
        do {
            
            String password = inputPassword();
            
            if (isPasswordValid(password));
                break;
            
        } while (true);
        
    }
    
}