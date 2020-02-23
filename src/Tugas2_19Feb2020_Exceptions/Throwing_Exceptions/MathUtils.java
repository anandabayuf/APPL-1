/*
 * Created By Ananda Bayu Fauzan.
 */
package Tugas2_19Feb2020_Exceptions.Throwing_Exceptions;

/**
 *
 * @author Ananda Bayu
 */
// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException{
        int fac = 1;
        if(n < 0)
            throw new IllegalArgumentException("The number should not be "
                    + "negative number");
        else if (n > 16)
            throw new IllegalArgumentException("the results of factorial cannot "
                    + "be accommodated, because the types of data types are not "
                    + "met");
        else
            for (int i=n; i>0; i--)
                fac *= i;
        
        return fac;
    }
}