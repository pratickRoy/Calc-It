package com.assignment1.androidjammingsessions.calculator;

/**
 * Created by ${Roy} on ${2050}.
 */
public class BasicOperations
{
    public static long intFac(long n)
    {
        long fac=1;
        while(n!=1)
            fac *= (n--);
        return fac;
    }
    public static double sin(double n)
    {
        return Math.sin(n);
    }
    public static double cos(double n)
    {
        return Math.cos(n);
    }
    public static double tan(double n)
    {
        return Math.tan(n);
    }
    public static double log(double n)
    {
        return Math.log10(n);
    }
    public static double ln(double n)
    {
        return Math.log(n);
    }
    public static double sqrt(double n)
    {
        return Math.sqrt(n);
    }
    public static double arcsin(double n)
    {
        return Math.asin(n);
    }
    public static double arccos(double n)
    {
        return Math.acos(n);
    }
    public static double arctan(double n)
    {
        return Math.atan(n);
    }
    public static double roundOff(double n)
    {
        return Math.rint(n);
    }
    public static double sinh(double n)
    {
        return Math.sinh(n);
    }
    public static double cosh(double n)
    {
        return Math.cosh(n);
    }
    public static double tanh(double n)
    {
        return Math.tanh(n);
    }


}