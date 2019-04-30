package countcharacterswordslinesinfile;

/**
 * *******************************************************************************
 * (Count characters, words, and lines in a file) Write a program that will
 * count * the number of characters, words, and lines in a file. Words are
 * separated by * whitespace characters. The file name should be passed as a
 * command-line * argument, as shown in Figure 12.13. *
 * *******************************************************************************
 */
import java.io.*;
import java.util.*;

public class Exercise_12_13 {

    /**
     * Main method
     *
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
//		if (args.length != 1) {
//			System.out.println("Usage: java filename");
//			System.exit(1);
//		}	

        // Check if file exists
        File file = new File("src/countcharacterswordslinesinfile/Loan.java");
        if (!file.exists()) {
            System.out.println("File " + file.getName() + " at path " + file.getAbsolutePath() + " does not exist");
            System.exit(2);
        }

        int characters = 0;	// Number of character
        int words = 0;			// Number of words
        int lines = 0;			// Number of lines

        // Create input file
        try (Scanner input = new Scanner(file);) {
            while (input.hasNextLine()) {
                lines++;    // plus up the as soon as there is a next line 
                String line = input.nextLine().trim();  // ( trim() )Remove whitespaces, to count only the characthers, not whitespaces too. 
                characters += line.length();
                
            }
        }

        // Create input file
        try (Scanner input = new Scanner(file);) {
            while (input.hasNext()) {
                String line = input.next();

                words++;
            }
        }

        // Display results
        System.out.println("File " + file.getName() + " has");
        System.out.println(characters + " characters");
        System.out.println(words + " words");
        System.out.println(lines + " lines");
    }
}
