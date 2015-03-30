package com.assignment1.androidjammingsessions.myCustomImports.graphics;

import android.provider.MediaStore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by ${Roy} on ${2050}.
 */
public class ColorMaster
{

    private static File ColorFile;
    private static boolean fromFile;
    public ColorMaster()
    {
        try
        {
            ColorFile = new File("color.txt");
        }
        catch (Exception e)
        {
            fromFile=false;
        }
    }

    public ColorMaster(String colorFileAbsolutePath)
    {
        try
        {
            ColorFile = new File(colorFileAbsolutePath);
        }
        catch (Exception e)
        {
            fromFile=false;
        }
    }
    public static int integerValueOfColor(String colorName) throws IOException
    {
        if (fromFile)
        {
            return integerValueOfColorFromFile(colorName);
        }
        else
        {
            return integerValueOfColorFromCode(colorName);
        }

    }

    private static int integerValueOfColorFromCode(String colorName)
    {
        switch (colorName)
        {
            case "white":
            {
                return 0xFFFFFFFF;
            }
            case "black":
            {
                return 0xFF000000;
            }
            // cyan series

                case "cyan500":
                {
                    return 0xFF00BCD4;
                }
                case "cyan600":
                {
                    return 0xFF00ACC1;
                }
                case "cyan700":
                {
                    return 0xFF0097A7;
                }
                case "cyan800":
                {
                    return 0xFF00838F;
                }
                case "cyan900":
                {
                    return 0xFF006064;
                }
            //

            // lightBlue series

                case "lightBlue500":
                {
                    return 0xFF03A9F4;
                }
                case "lightBlue600":
                {
                    return 0xFF039BE5;
                }
                case "lightBlue700":
                {
                    return 0xFF0288D1;
                }
                case "lightBlue800":
                {
                    return 0xFF0277BD;
                }
                case "lightBlue900":
                {
                    return 0xFF01579B;
                }
            //

            // Amber series

                case "amber600":
                {
                    return 0xFFFFB300;
                }
                case "amber700":
                {
                    return 0xFFFFA000;
                }
                case "amber800":
                {
                    return 0xFFFF8F00;
                }
                case "amber900":
                {
                    return 0xFFFF6F00;
                }
            //
            case "blueGrey900":
            {
                return 0xFF263238;
            }
            case "Indigo500":
            {
                return 0xFF3F51B5;
            }
            case "Orange800":
            {
                return 0xFFEF6C00;
            }
            default:
            {
                return -1;
            }

        }

    }

    private static int integerValueOfColorFromFile(String colorName) throws IOException
    {
        FileReader fileReader = new FileReader(ColorFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line=bufferedReader.readLine()) != null)
        {
            if(line.substring(0,line.indexOf(" ")).equals("colorName"))
                return Integer.parseInt(line.substring(0,line.indexOf(" ")));
        }
        fileReader.close();
        return -1;
    }

}
