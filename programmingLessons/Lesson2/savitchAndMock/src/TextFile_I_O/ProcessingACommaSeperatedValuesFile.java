/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextFile_I_O;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author AleksanderStationaer
 */
public class ProcessingACommaSeperatedValuesFile {
    public static void main(String[] args) {
        String fileName = "Transactions.txt";
        try {
            Scanner inputStream = new Scanner(new File(fileName));
            // Skip the header line by reading and ignoring it 
            String line = inputStream.nextLine();
            // total sales
            double total = 0;
            // read the rest of the file line by line
            while (inputStream.hasNextLine()) {
                // Contains SKU, Quantity, Price, Description
                line = inputStream.nextLine();
                // Turn the string int o an array of strings
                String[] ary = line.split(",");
                // Extract each item into an appropriate
                // variable
                String SKU = ary[0];
                int quantity = Integer.parseInt(ary[1]);
                double price = Double.parseDouble(ary[2]);
                String description = ary[3];
                // output item
                System.out.printf("Sold %d of %s (SKU: %s) at " + "$%1.2f each.\n",
                        quantity, description, SKU, price);
                // compute total
                total+= quantity * price;
            }
            System.out.printf("Total sales: $%1.2f\n", total );
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file " + fileName);
        } catch (IOException e) {
            System.out.println("Problem with input from file " + fileName);
        }
    }
}
