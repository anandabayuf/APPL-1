/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.Throwing_Exceptions;

/**
 *
 * @author Ananda Bayu
 */
// ****************************************************************
// Factorials.java
//
// Reads integers from the user and prints the factorial of each.
//
// ****************************************************************
import java.util.Scanner;
public class Factorials{
    public static void main(String[] args){
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing.equals("y") || keepGoing.equals("Y")){
            System.out.print("Enter an integer: ");
            try {
                int val = scan.nextInt();
                System.out.println("Factorial(" + val + ") = "
                        + MathUtils.factorial(val));
            } catch (Exception e) {
                System.out.println("The number should not be negative number or"
                        + " the number should not be exceed 16");
            }
            System.out.print("Another factorial? (y/n) ");
            keepGoing = scan.next();
        }
    }
}
