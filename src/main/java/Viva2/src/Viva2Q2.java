/*2.Lili works as a data analyst at a customer service company.
Currently, she is actively engaged in a project aimed at analyzing
the median response time for customer inquiries and complaints.
The primary goal of this project is to assess and improve the 
overall efficiency of their customer service operations. Lili has
received two unsorted arrays of double values representing time data, 
and she is looking to calculate the median of this data. 
Can you provide a Java method that receives 2 double arrays as 
input and returns a double value as output to help her solve this problem?

Please provide the answer rounded to three decimal places.*/

import java.util.Scanner;
import java.util.Arrays;

public class Viva2Q2 {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        // Get sizes of both arrays
        int[] dataSizes = arrayDataSize();

        double[] arr1 = new double[dataSizes[0]];
        double[] arr2 = new double[dataSizes[1]];

        // Input data into arrays
        inputArray(arr1, arr2);

        // Merging the arrays and finding the median
        Merged(arr1, arr2);
    }

    //A method to input the size of the arrays
    public static int[] arrayDataSize() {

        int[] dataSize = new int[2];

        for (int i = 0; i < 2; i++) {
            System.out.printf("Size of Array %d? : ", (i + 1));
            dataSize[i] = scn.nextInt();
        }

        return dataSize;
    }

    //A method to input the data
    public static void inputArray(double[] arr1, double[] arr2) {

        //Array input
        System.out.println("Input Array 1");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Array 1 [" + (i + 1) + "]: ");
            arr1[i] = scn.nextDouble();
        }

        System.out.println("Input Array 2");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Array 2 [" + (i + 1) + "]: ");
            arr2[i] = scn.nextDouble();
        }
    }

    //A method use to merge both arrays and sort them into ascending order
    public static void Merged(double[] arr1, double[] arr2) {

        //declaring the merged array size
        int mergedSize = arr1.length + arr2.length;

        //merged array declaration
        double[] merged = new double[mergedSize];

        //merging array
        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            merged[i + arr1.length] = arr2[i];
        }

        // sorting arrays
        Arrays.sort(merged);

        //returned value from Median method
        double n = Median(merged, mergedSize);
        System.out.printf("%nMedian for these 2 sets of data is %.3f %n", n);
    }

    //A method use to find the median of the arrays
    public static double Median(double[] merged, int mergedSize) {
        // if mergedSize is odd
        if (mergedSize % 2 == 1) {
            return merged[mergedSize / 2];

        } else { //if mergedSize is even 
            int middle = mergedSize / 2;
            return ((merged[middle] + merged[middle - 1]) / 2);
        }
    }
}
