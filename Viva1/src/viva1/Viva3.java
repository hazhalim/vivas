package viva1;
import java.util.Scanner;  //import libary to accept input
public class Viva3 
{
    public static void main(String[] args) 
    {
        int numberUser, number; //initialize
        Scanner input = new Scanner(System.in); //declare object
        System.out.println("Write an integer to check whether it is STRONG NUMBER or NOT");
        System.out.print("Enter number: ");
        numberUser = input.nextInt(); //user enter input
        number = numberUser;
        
        int quotient;
        int fact = 1;
        int result = 0; //initialize
        
        while(number != 0) //calculate factorial for each number
        {
            quotient = number%10; //get 1 number from back
            fact = (fact+1)-fact; //make fact bocome always 1 
            for(int i = 1; i<=quotient; i++) //factorial calculation
            {
                fact = fact * i; 
            }      
            System.out.println("Factorial of " + quotient + " = " + fact);
            result = result + fact; //sum up the factorial
            number = number / 10; //get next number from back
        }
        System.out.println("Sum of all factorial for each number: " + result);
        
        //check condition
        if(numberUser == result)
        {
            System.out.println(numberUser + " IS STRONG NUMBER");
        }
        else
        {
            System.out.println(numberUser + " IS NOT STRONG NUMBER");
        }
    }
}
