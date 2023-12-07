package viva1;

import java.util.Scanner;

public class Viva1
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
         
        */
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String password = keyboard.nextLine();
        
        System.out.println("");
        
        // Array to store all characters of the string
        char[] passwordArray = password.toCharArray();
        
        // Strength condition variables
        boolean lowercase = false;
        boolean uppercase = false;
        boolean specialCharacter = false;
        boolean passwordLength = false;
        boolean digits = false;
        
        // Final password strength
        String strength;
        
        if (passwordArray.length >= 8)
        {
            
            passwordLength = true;
            
        }
        
        for (int i = 0; i < passwordArray.length; i++)
        {
           
           // Convert char to ASCII value
           int asciiValue = (int) passwordArray[i];
           
           if (asciiValue >= 65 && asciiValue <= 90)
           {
               
               uppercase = true;
               
           } else if (asciiValue >= 97 && asciiValue <= 122) {
               
               lowercase = true;
               
           } else if (asciiValue >= 48 && asciiValue <= 57) {
               
                digits = true;
                
           } else {
               
               switch (asciiValue)
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