import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {
        System.out.println("""
                           i) A password contains at least 8 characters
                           ii) A password contains at least 1 capital and small letter
                           iii) A password contains at least 3 digits
                           iv) A password must consist only 1 special character
                           """);

        String password;

        //Ask to enter a password until get true password
        do {
            password = acceptPassword();
        } while (!checkPassword(password));

            System.out.println("TRUE PASSWORD");
    }
    
    //Method to accept a password from user
    public static String acceptPassword() {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a password: ");
        return inp.nextLine();
    }

    //Method to check if the entered password meet all conditions
    public static boolean checkPassword(String password) {
        boolean isPasswordValid = true;
        
        //Check condition individually
        if (!checkCharacters(password)) {
            //If not mark tha password as in valid
            isPasswordValid = false;
        }

        if (!checkUppercase(password)) {
            isPasswordValid = false;
        }

        if (!checkLowercase(password)) {
            isPasswordValid = false;
        }

        if (!checkDigit(password)) {
            isPasswordValid = false;
        }

        if (!checkSpecial(password)) {
            isPasswordValid = false;
        }
        
        //Error message if the password not meet the requirements
        if (!isPasswordValid) {
            System.out.println("FALSE");
            System.out.println("Please enter a password that meets the "
                    + "specified condition above");
            System.out.println(" ");
        }
        
        //Return the overall validity status 
        return isPasswordValid;
    }

    //Method to check password must be more than 8 characters
    public static boolean checkCharacters(String password) {
        if (password.length() >= 8) {
            return true;
        } else {
            System.out.println("AT LEAST 8 CHARACTERS");
            return false;
        }
    }

    //Method to check the password has at least 1 uppercase
    public static boolean checkUppercase(String password) {
        int passwordCharLength = password.length();
        int countUppercase = 0;
        
        //Read a character one by one
        for (int i = 0; i < passwordCharLength; i++) {
            char currentChar = password.charAt(i); //Get current char
            int asciiValue = (int) currentChar; //Get ASCII value current char
            if (asciiValue >= 65 && asciiValue <= 90) {
                countUppercase++;
            }
        }
        if (countUppercase > 0) {
            return true;
        } else {
            System.out.println("AT LEAST 1 UPPERCASE");
            return false;
        }
    }

    //Method to check the password has at least 1 lowercase
    public static boolean checkLowercase(String password) {
        int passwordCharLength = password.length();
        int countLowercase = 0;
        for (int i = 0; i < passwordCharLength; i++) {
            char currentChar = password.charAt(i);
            int asciiValue = (int) currentChar;
            if (asciiValue >= 97 && asciiValue <= 122) {
                countLowercase++;
            }
        }
        if (countLowercase > 0) {
            return true;
        } else {
            System.out.println("AT LEAST 1 LOWERCASE");
            return false;
        }
    }

    //Method to check the password has at least 1 digit
    public static boolean checkDigit(String password) {
        int passwordCharLength = password.length();
        int countDigit = 0;
        for (int i = 0; i < passwordCharLength; i++) {
            char currentChar = password.charAt(i);
            int asciiValue = (int) currentChar;
            if (asciiValue >= 48 && asciiValue <= 57) {
                countDigit++;
            }
        }
        if (countDigit >= 3) {
            return true;
        } else {
            System.out.println("AT LEAST 3 DIGITS");
            return false;
        }
    }

    //Method to check the password has at least 1 special character
    public static boolean checkSpecial(String password) 
    {
        int passwordCharLength = password.length();
        int countSpecial = 0;
        for(int i=0; i<passwordCharLength; i++)
        {
            char currentChar = password.charAt(i);
            int asciiValue = (int)currentChar;
            switch(asciiValue) //!#$%^&*()-+
            {
                case 33:
                        countSpecial++;
                        break;
                case 64:
                        countSpecial++;
                        break;
                case 35:
                        countSpecial++;
                        break;
                case 36:
                        countSpecial++;
                        break;
                case 37:
                        countSpecial++;
                        break;
                case 94:
                        countSpecial++;
                        break;
                case 38:
                        countSpecial++;
                        break;
                case 42:
                        countSpecial++;
                        break;
                case 40:
                        countSpecial++;
                        break;                        
                case 41:
                        countSpecial++;
                        break;
                case 45:
                        countSpecial++;
                        break;
                case 43:
                        countSpecial++;
                        break;
            }
        }
        if (countSpecial > 0) {
            return true;
        } else {
            System.out.println("AT LEAST 1 SPECIAL CHARACTER");
            return false;
        }
    }
}
