package com.assignment1.androidjammingsessions.calculator;

import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import com.assignment1.androidjammingsessions.fragments.ActionBarFragment;
import com.assignment1.androidjammingsessions.myCustomImports.Datastrucures.LinkedStack;

/**
 * Created by ${Roy} on ${2050}.
 */
public class EquationHandler extends ActionBarFragment
{

    public LinkedStack operand=new LinkedStack();
    public LinkedStack operator=new LinkedStack();
    public String mathParser(String infixString,String[] op,boolean isRadian)
    {
        infixString="("+infixString+")";
        boolean contd=true;
        while(infixString.length()>0)
        {
            //System.err.println(infixString.charAt(0));
            //System.out.println(infixString);

            //Operand

            if((infixString.charAt(0)>='0' && infixString.charAt(0)<='9')||(infixString.charAt(0)=='.'))
            {
                int i=0;
                while(true)
                {

                    if(op[0].indexOf(infixString.charAt(i++))!=-1)
                        break;
                    /*if(infixString.charAt(i++)>='a' && infixString.charAt(i)<='z')
                        break;*/
                }
                operand.push(infixString.substring(0, i - 1));
                System.out.println("op"+operand.peek());
                //System.out.println(operand.peek());

                //Toast.makeText(getActivity(),operand.peek(),Toast.LENGTH_LONG).show();
                infixString=infixString.substring(i-1);
            }

            //Operator

            else
            {
                if((operator.isEmpty() || (operator.peek()).contains("(") || infixString.charAt(0)=='(')&&contd==true)
                {

                    int i=0;
                    while(true)
                    {

                        if(op[0].indexOf(infixString.charAt(i++))!=-1)
                            break;
                        //i++;
                    }
                    if(infixString.charAt(i-1)!=')')
                    {
                        operator.push(infixString.substring(0,i));
                        //operator.push(infixString.charAt(i-1)+"");
                        System.out.println(operator.peek());
                        infixString=infixString.substring(i);
                    }
                    else
                    {
                        infixString=infixString.substring(i-1);
                        contd=false;
                    }

                }
                else if(infixString.charAt(0)==')')
                {
                    contd=true;
                    //System.out.print("Hello");
                    while(!((operator.peek()).contains("(")))
                    {
                        solverMain(op);
                        //solver(Double.parseDouble(operand.pop()),Double.parseDouble(operand.pop()),operator.pop());
                        //operand.push(operator.pop());
                    }
                    if(!((operator.peek()).equals("(")))
                    {
                        solver(Double.parseDouble(operand.pop()), operator.pop(), isRadian);
                    }
                    else
                        operator.pop();
                    infixString=infixString.substring(1);
                }
                else if(precedence(infixString.charAt(0)+"",operator.peek(),op[0]))
                {
                    operator.push(infixString.charAt(0)+"");
                    System.out.println(operator.peek());
                    //Toast.makeText(getActivity(),operand.peek(),Toast.LENGTH_LONG).show();
                    infixString=infixString.substring(1);
                }
                else
                {
                    while(!(operator.peek()).contains("(") && !(precedence(infixString.charAt(0)+"",operator.peek(),op[0])))
                    {
                        solverMain(op);
                        //solver(Double.parseDouble(operand.pop()),Double.parseDouble(operand.pop()),operator.pop());
                        //operand.push(operator.pop());
                        if(operator.isEmpty())
                            break;
                    }

                    operator.push(infixString.charAt(0)+"");
                    System.out.println(operator.peek());
                    infixString=infixString.substring(1);
                }
            }

        }
        /*while(true)
         * {
         * System.out.println(operand.pop());
         * if(2==1)
         * break;
         * }*/
        Double ans=1d;
        while(!operand.isEmpty())
        {
            ans*=Double.parseDouble(operand.pop());
        }
        return (ans+"");
    }
    public void solverMain(String[] op)
    {

        if ((op[1].indexOf(operator.peek())) != -1)
        {
            solver(Double.parseDouble(operand.pop()), operator.pop(),false);
        }
        else if ((op[2].indexOf(operator.peek())) != -1)
        {

            if (operand.getSize() == 1 && operator.peek().equals("-"))
            {
                solver(Double.parseDouble(operand.pop()), 0.0, operator.pop());
            }
            else
            {
                solver(Double.parseDouble(operand.pop()), Double.parseDouble(operand.pop()), operator.pop());
            }

        }
        else if ((op[3].indexOf(operator.peek())) != -1)
        {
            solver(operator.pop());
        }


    }
    public boolean precedence(String o1,String o2, String operators)
    {
        return (operators.indexOf(o1) < operators.indexOf(o2));
    }
    public void solver(Double b,Double a,String op)
    {
        switch(op)
        {
            case "+":
            {
                operand.push((a+b)+"");
                System.out.println(operand.peek());
                break;
            }
            case "-":
            {
                operand.push((a-b)+"");
                System.out.println(operand.peek());
                break;
            }
            case "*":
            {
                operand.push((a*b)+"");
                System.out.println(operand.peek());
                break;
            }
            case "/":
            {
                if(b!=0.0d)
                {
                    operand.push((a / b) + "");
                    System.out.println(operand.peek());
                }
                else
                {
                    operand.push("∞");
                }
                break;
            }
            case "^":
            {
                operand.push(Math.pow(a,b)+"");
                System.out.println(operand.peek());
                break;
            }
        }
    }
    public void solver(Double a,String op,boolean isRadian)
    {
        switch(op)
        {
            case "!":
            {
                if(a.intValue()%a==0)
                    operand.push(BasicOperations.intFac(a.intValue())+"");
                System.out.println(operand.peek());
                break;
            }
            case "sin(":
            {
                operand.push(BasicOperations.sin(isRadian ? a : Math.toRadians(a))+"");
                break;
            }
            case "cos(":
            {
                System.err.println("HELLO");
                operand.push(BasicOperations.cos(isRadian?a:Math.toRadians(a))+"");
                break;
            }
            case "tan(":
            {

                System.err.println("HELLO");
                operand.push(BasicOperations.tan(isRadian?a:Math.toRadians(a))+"");
                break;
            }
            case "log(":
            {
                System.err.println("HELLO");
                operand.push(BasicOperations.log(a)+"");
                break;
            }
            case "\u221a(":
            {
                System.err.println("HELLO");
                operand.push(BasicOperations.sqrt(a)+"");
                break;
            }
            case "arcsin(":
            {
                //if(isRadian==false)
                    operand.push(isRadian?BasicOperations.arcsin(a)+"":Math.toDegrees(BasicOperations.arcsin(a))+"");
                //else
                    //operand.push(BasicOperations.arcsin(a)+"");
                break;
            }
            case "arccos(":
            {
                operand.push(isRadian?BasicOperations.arccos(a)+"":Math.toDegrees(BasicOperations.arccos(a))+"");
                break;
            }
            case "arctan(":
            {
                operand.push(isRadian?BasicOperations.arctan(a)+"":Math.toDegrees(BasicOperations.arctan(a))+"");
                break;
            }
            case "ln(":
            {
                System.err.println("HELLO");
                operand.push(BasicOperations.ln(a)+"");
                break;
            }
            case "sinh(":
            {

                System.err.println("HELLO");
                operand.push(BasicOperations.sinh(isRadian?a:Math.toRadians(a))+"");
                break;
            }
            case "cosh(":
            {
                if(isRadian==false)
                    a*=180/Math.PI;
                System.err.println("HELLO");
                operand.push(BasicOperations.cosh(isRadian?a:Math.toRadians(a))+"");
                break;
            }
            case "tanh(":
            {
                if(isRadian==false)
                    a*=180/Math.PI;
                System.err.println("HELLO");
                operand.push(BasicOperations.tanh(isRadian?a:Math.toRadians(a))+"");
                break;
            }
            case "rnd(":
            {
                System.err.println("HELLO");
                operand.push(BasicOperations.roundOff(a)+"");
                break;
            }


        }
    }

    public void solver(String op)
    {
        switch(op)
        {
            case ")":
            {
                operator.pop();
                break;
            }
        }
    }
}
