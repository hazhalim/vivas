import java.util.Random;

public class Viva1Q4Random
{

    public static void main(String[] args)
    {

        // Question 4
        
        /**

        A password is said to be strong if it satisfies the following criteria:
        It contains at least one lowercase English character.
        It contains at least one uppercase English character.
        It contains at least one special character. The special characters are: !@#$%^&*()-+
        Its length is at least 8.
        It contains at least one digit.
        Check the strength of the input string. Let a strong password be one that satisfies all the
        above conditions. A moderate password is one that satisfies the first three conditions
        and has a length of at least 6. Otherwise, the password is weak.
        
         
        This version of the file doesn't require user input and instead generates a random string which is judged for
        its safety as a password. The password length can range from 1 to 15 characters long, and involves ASCII
        characters with values from 32 to 126.
        
        */
        
        Random rand = new Random();
        
        int minN = 1;
        int maxN = 15 + 1; // max is exclusive, so add 1
        
        int n = rand.nextInt(maxN - minN) + minN;
        
        int min = 32;
        int max = 126 + 1; // max is exclusive, so add 1
        
        System.out.println("");
        
        // Array to store all characters of the string
        
        int[] passwordArrInt = new int[n];
        char[] passwordArray = new char[n];
        
        for (int i = 0; i < n; i++)
        {
            
            int num = rand.nextInt(max - min) + min;
            
            passwordArrInt[i] = num;
            passwordArray[i] = (char) num;
            
        }
        
        System.out.print("Enter a string: ");
        
        for (char c : passwordArray)
        {
            
            System.out.print(c);
            
        }
        
        System.out.println("");
        
        // Strength condition variables
        boolean lowercase = false;
        boolean uppercase = false;
        boolean specialCharacter = false;
        boolean passwordLength = false;
        boolean digits = false;
        
        // Final password strength
        String strength;
        
        if (passwordArrInt.length >= 8)
        {
            
            passwordLength = true;
            
        }
        
        for (int num : passwordArrInt)
        {
           
           if (num >= 65 && num <= 90)
           {
               
               uppercase = true;
               
           } else if (num >= 97 && num <= 122) {
               
               lowercase = true;
               
           } else if (num >= 48 && num <= 57) {
               
                digits = true;
                
           } else {
               
               switch (num)
               {
                   
                   // Refer to ASCII table for values of: !@#$%^&*()-+
                       
                   case 33 -> specialCharacter = true;
                   case 64 -> specialCharacter = true;
                   case 35 -> specialCharacter = true;
                   case 36 -> specialCharacter = true;
                   case 37 -> specialCharacter = true;
                   case 94 -> specialCharacter = true;
                   case 38 -> specialCharacter = true;
                   case 42 -> specialCharacter = true;
                   case 40 -> specialCharacter = true;
                   case 41 -> specialCharacter = true;
                   case 45 -> specialCharacter = true;
                   case 43 -> specialCharacter = true;
                   
               }
                   
           }
                
        }
        
        if (lowercase == true && uppercase == true && specialCharacter == true && passwordLength == true && digits == true)
        {
            
            strength = "Strong";
            
        } else if (lowercase == true && uppercase == true && specialCharacter == true && passwordArray.length >= 6) {
            
            strength = "Moderate";
            
        } else {
            
            strength = "Weak";
            
        }
        
        System.out.printf("Strength of password: %s \n", strength);
        
    }
    
}