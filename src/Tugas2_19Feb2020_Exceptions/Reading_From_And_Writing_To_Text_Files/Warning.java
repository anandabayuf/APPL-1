/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.Reading_From_And_Writing_To_Text_Files;

/**
 *
 * @author Ananda Bayu
 */
// ****************************************************************************
// Warning.java
//
// Reads student data from a text file and writes data to another text file.
// ****************************************************************************
import java.util.Scanner;
import java.io.*;

public class Warning{
    // --------------------------------------------------------------------
    // Reads student data (name, semester hours, quality points) from a
    // text file, computes the GPA, then writes data to another file
    // if the student is placed on academic warning.
    // --------------------------------------------------------------------
    public static void main (String[] args){
        int creditHrs; // number of semester hours earned
        double qualityPts; // number of quality points earned
        double gpa; // grade point (quality point) average
        
        String line, name, inputName = "students.dat";
        String outputName = "warning.dat";
        
        try{
            // Set up scanner to input file
            File myFile = new File(inputName);
            Scanner scan = new Scanner(myFile);
            // Set up the output file stream
            FileWriter fileWriter = new FileWriter(outputName);
            PrintWriter outFile = new PrintWriter(fileWriter);
            // Print a header to the output file
            outFile.println ();
            outFile.println ("Students on Academic Warning");
            outFile.println ();
            // Process the input file, one token at a time
            while (scan.hasNextLine()){
                // Get the credit hours and quality points and
                // determine if the student is on warning. If so,
                // write the student data to the output file.
                line = scan.nextLine();
                String[] temp = line.split(" ");
                
                name = temp[0];
                creditHrs = Integer.parseInt(temp[1]);
                qualityPts = Double.parseDouble(temp[2]);
                
                gpa = qualityPts/creditHrs;
                
                if((gpa < 1.5 && creditHrs < 30) || (gpa < 1.75 && creditHrs < 60)
                        || (gpa < 2.0)){
                    outFile.println(name + " " + creditHrs + " " + gpa);
                }
            }
            // Close output file
            outFile.close();
        }
        catch (FileNotFoundException exception){
            System.out.println ("The file " + inputName + " was not found.");
        }
        catch (IOException exception){
            System.out.println (exception);
        }
        catch (NumberFormatException e){
            System.out.println ("Format error in input file: " + e);
        }
    }
}