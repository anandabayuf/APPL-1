/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.Copying_A_File;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ananda Bayu
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean tryAgain = true;
        String fileName;
        
        System.out.print("Input the file name or the address of the file : ");
        fileName = scan.next();
        
        while(tryAgain){
            try {
                Scanner scanFile = new Scanner(new File(fileName));
                int line = 1;
                while(scanFile.hasNextLine()){
                    String temp = scanFile.nextLine();
                    System.out.println("Line " + line + " : " + temp);
                    line++;
                }
                tryAgain = false;
                scanFile.close();
            } catch (FileNotFoundException e) {
                System.out.println ("The file " + fileName + " was not found.");
            }
            
            if(tryAgain){
                System.out.print("Try Again (Y/N) ? ");
                String temp = scan.next();

                while(!temp.toUpperCase().equals(("Y")) && !temp.toUpperCase().equals("N")){
                    System.out.println("You chose the wrong choice");
                    System.out.print("Try Again (Y/N) ? ");
                    temp = scan.next();
                }
                if(temp.toUpperCase().equals("N"))
                    tryAgain = false;
                else{
                    System.out.print("Input the file name or the address of the file : ");
                    fileName = scan.next();
                }
            }
        }
    }
}
