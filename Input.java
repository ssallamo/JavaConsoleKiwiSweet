package kiwisweetcheckout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
 
/**
 * Takes values from the terminal
 * @author HJS
 * @version 2016. 3. 15.
 */
public class Input {
    
    /**
     * To select Choice in each of Items
     * @param msg    : direction message
     * @param bounds : number of menu index 
     * @return choice number
     */
    public static int getChoice(String msg, int bounds)
    {
        int no=0;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);                
                System.out.println(msg);
                no = scan.nextInt();
                if(no>bounds){//limited index
                    System.out.println("The chosen one is not in the menu. Pleas choose again!!\n");
                }
                else break;
            }
            catch(Exception e){ //if entered data was not integer type, will execute
                System.out.println("Input Err : " + e);
            }
        }    
        return no;    
    }
    
    /**
     * To enter double value
     * @param msg : direction message
     * @return enter double type of data
     */
    public static double getDouble(String msg)
    {        
        double dbl =0;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);                
                System.out.println(msg);
                dbl = scan.nextDouble();
                break;
            }
            catch(Exception e){ //if entered data was not double type of data, will execute
                System.out.println("Input Err : " + e);
            }
        }        
        return dbl;            
    }
    
    /**
     * To enter 1 char value
     * @param msg : direction message
     * @return char type of data, Y or N
     */
    public static char getChar(String msg)
    {        
        char ch=0;
        while(true){    
            try{
                Scanner scan = new Scanner(System.in);                
                System.out.println(msg);
                ch = Character.toUpperCase(scan.nextLine().charAt(0));                
            }
            catch(Exception e){ //if entered data was not Char type, will execute
                System.out.println("Input Err : " + e);
            }
            if((ch!='Y')&&(ch!='N'));
            else break;
        }
        return ch;    
    }
    
    /**
     * To enter integer type of value
     * @param msg : direction message
     * @return integer type of data
     */
    public static int getInteger(String msg)
    {
        int number=0;
        while(true){
            try{
                Scanner scan = new Scanner(System.in);                
                System.out.println(msg);
                number = scan.nextInt();
                break;
            }
            catch(Exception e){ //if entered data was not Integer type, will execute
                System.out.println("Input Err : " + e);
            }            
        }        
        return number;    
    }
    
 
    /**
     * To enter String type of value
     * @param msg : direction message
     * @return String type of data
     */
    public static String getString(String msg)
    {
        String string="";
        while(true){
            try{
                Scanner scan = new Scanner(System.in);                
                System.out.println(msg);
                string = scan.nextLine();
                break;
            }
            catch(Exception e){ //if entered data was not String type, will execute
                System.out.println("Input Err : " + e);
            }            
        }        
        return string;    
    }    
} 
