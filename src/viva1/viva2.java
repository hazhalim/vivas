package viva1;

import java.util.Scanner;

public class viva2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter any Integer : ");
        int num = scn.nextInt();
        System.out.println("Reversed Integer : ");
        while (true) {
            if (num != 0)
            {
                int balance = num % 10;
                System.out.print(balance);
                num /= 10;
            }
            else 
                break;
        }
        System.out.println("  ");
    }
}
