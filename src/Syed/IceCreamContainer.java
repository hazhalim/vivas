/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Syed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tmhta_
 */
public class IceCreamContainer {

    private final String fileName = "IceCream.csv";
    // all data about the ice cream
    private String tempFileName = "tempIceCream.csv";
    // temporary file use to update the changes e.g. remaining 
    //volume of the ice cream

    // method to add new ice-cream flavor
    public void addIceCream(String flavor, double volume) {
        IceCream iceCream = new IceCream(flavor, volume);
        iceCreamCSV(iceCream);
        // add the ice-cream into CSV file
    }

    public void iceCreamCSV(IceCream iceCream) {
        // write the ice cream info into CSV file
        try {

            FileWriter file = new FileWriter(fileName);
            file.write(iceCream.flavor + "," + iceCream.volume);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // method use to calculate volume of each scoop and total volume
    public double calculateVolume(double scoopRadius, int scoop) {
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(scoopRadius, 3);
        double totalVolume = scoop * volume;
        return totalVolume;
    }

    //method to update the remaining ice cream volume
    public void scoopIceCream(String flavor, double volumeScooped) {

        try {
            FileReader fr = new FileReader(fileName);
            FileWriter fw = new FileWriter(tempFileName);
            BufferedReader br = new BufferedReader(fr);
            BufferedWriter bw = new BufferedWriter(fw);

            String line;

            while ((line = br.readLine()) != null) {
                String[] iceCreamDetails = line.split(",");
                if (iceCreamDetails[0].equals(flavor)) {
                    double remainingVolume = Double.parseDouble(iceCreamDetails[1]) - volumeScooped;
                    if (remainingVolume < 0) {
                        remainingVolume = 0; // Ensure volume doesn't go negative
                    }
                    line = iceCreamDetails[0] + "," + remainingVolume;
                }
                bw.write(line + "\n");

                // Rename the temporary file to the original file
                File originalFile = new File(fileName);
                File tempFile = new File(tempFileName);
                tempFile.renameTo(originalFile);
            }
            bw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double remainingVolume(String flavor) {
        double volumeLeft = 0.0;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                String[] iceCreamDetails = line.split(",");
                if (iceCreamDetails[0].equals(flavor)) {
                    volumeLeft = Double.parseDouble(iceCreamDetails[1]);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return volumeLeft;
    }

    public boolean prepareIceCream(String flavor, double minVolume) {
        double volumeLeft = remainingVolume(flavor);
        boolean isEnough = true;
        if (volumeLeft < minVolume) {
            isEnough = false;
        }
        return isEnough;
    }
}
