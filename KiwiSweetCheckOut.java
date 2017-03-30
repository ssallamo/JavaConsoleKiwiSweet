/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

import java.util.ArrayList;
 
/**
 * Kiwi Sweet Desert Shop Taking order program
 * @author  HJS
 * @version 2016. 3. 15.
 */
public class KiwiSweetCheckOut extends Thread {
    
    static DesertToday desertToday;      //total today sale data
    static ArrayList<Desert> deserts; //one order Array list
    
    public static void main(String[] arg) throws InterruptedException 
    {  
        while(true){
            desertToday = new DesertToday();
            deserts = new ArrayList<Desert>(); // re create when every thread creates
            KiwiSweetCheckOut thread = new KiwiSweetCheckOut();
            thread.start(); //run thread
            thread.join();  //waiting until finish the thread
            Thread.sleep(2000);
        }
    }
    
    /**
     * a thread executes : one transaction(order)
     */
    public void run() 
    {
        boolean stopped = false; // thread stopping flag        
        try{
            while(!stopped)
            {
                DisplayMenu();
                int choice = Input.getChoice("-> Please Enter your choice from 0-9", 9); 
                switch(choice)
                {
                    case 1 : orderIceCream(); 
                             break;
                    case 2 : orderCandies();
                             break;
                    case 3 : orderCookies();
                             break;    
                    case 9 : cashRegister();//payment
                             stopped=true;  //thread stops 
                             break;    
                    case 0 : System.exit(999); //System terminates
                             break;
                }
            }            
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            GiveAsleep t = new GiveAsleep();
            Thread t2 = new Thread(t);
            t2.start();            
        }
    }    
    
    /**
     * Displays 3 type of Desert
     */
    static void DisplayMenu()
    {
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.format ("%-16s%s%17s", ">", DesertAble.NAME_OF_SHOP, "<\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("> " + desertToday.getCurrentTime());
        System.out.println("> Customer Count  : " + desertToday.todayTotalCustomer);
        System.out.println("──────────────────────────────────────────────────────");
                            // to assign total item from super class
        System.out.println("- Number of Items : " + desertToday.getTotalItems());  
        System.out.println("------------------------------------------------------");
        System.out.println("- " + DesertAble.MENU_ITEMS[0] + "     [1]"  );//iceCream
        System.out.println("- " + DesertAble.MENU_ITEMS[1] + "       [2]");//candies
        System.out.println("- " + DesertAble.MENU_ITEMS[2] + "       [3]");//cookies
        System.out.println("- Cash Register [9](preparation for next transaction)");
        System.out.println("- Exit          [0]");
        System.out.println("──────────────────────────────────────────────────────");
 
    }
    
    /**
     * Order Ice Cream
     */
    static void orderIceCream()
    {
        Desert aDesert = new IceCream();
        if(aDesert.takesOrder()){//the proper order returns true
            System.out.println(aDesert);
            deserts.add(aDesert); //add to arraylist
            desertToday.setOneOrder(aDesert.getEachCalculatedPrice());
 
            System.out.println("\n---------------------------------------------");
            char dinYn  = Input.getChar("-> Would you like Dinning-in ? [Y/N]");    
            if(dinYn=='Y'){
                //Dine-in Drinks assign
                Desert aDesert2 = new Drinks();
                if(aDesert2.takesOrder()){
                    System.out.println(aDesert2);
                    deserts.add(aDesert2); //add to arrayList
                    desertToday.setOneOrder(aDesert2.getEachCalculatedPrice());
                    desertToday.setTakeAwayOrDinIn(TYPEOFBUY.DINE_IN);
                }
            }
        }
    }
    
  
    /**
     * Order Candies
     */    
    static void orderCandies()
    {
        Desert aDesert = new Candy();
        if(aDesert.takesOrder()){
            System.out.println(aDesert);
            deserts.add(aDesert); //add to arraylist
            desertToday.setOneOrder(aDesert.getEachCalculatedPrice());
        }
    }
    
    /**
     * Order Cookies
     */
    static void orderCookies()
    {
        Desert aDesert = new Cookie();
        if(aDesert.takesOrder()){
            System.out.println(aDesert);
            deserts.add(aDesert); //add to arraylist
            desertToday.setOneOrder(aDesert.getEachCalculatedPrice());
        }
    }
        
    /**
     * Transaction Registers into system
     * daily counting, print receipt
     */
    static void cashRegister()
    {
        //if arrayList has no order, no print reciept
        if(desertToday.getTotalItems()==0){
            System.out.println("No orders at the moment!");
            return;
        }
 
        //Total Sale counting a daily
        desertToday.todayTotalCustomer++;
        //desertToday.todayTotalSale+=desertToday.getTotalCost();
        
        System.out.println("\n\n");
        System.out.println("┌───────────────────────────────────────┐");
        System.out.format ("│ %-38s│\n", DesertAble.NAME_OF_SHOP);
        System.out.println("├───────────────────────────────────────┤");
        System.out.format ("│ %-38s│\n", DesertAble.ADDRESS_OF_SHOP);    
        System.out.format ("│ %-38s│\n", desertToday.getCurrentTime());
        System.out.format ("│ Total Customer Count Today : %-9d│\n"
                           ,  desertToday.todayTotalCustomer);
        System.out.println("├───────────────────────────────────────┤");
        System.out.format ("│ Total Items : %-24d│\n", desertToday.getTotalItems());
        System.out.println("├───────────────────────────────────────┤"); 
                
        int i=1;
        for(Desert aDesert : deserts){
            printReceipt(aDesert, i); 
            i++;
        }          
        System.out.println("├───────────────────────────────────────┤");
        System.out.format ("│ Sub Total  %26.2f │\n", desertToday.getSubTotalCost());
        System.out.format ("│ Tax        %26.2f │\n", desertToday.getTax());
        System.out.format ("│ Total Cost %26.2f │\n", desertToday.getTotalCost());
        System.out.println("└───────────────────────────────────────┘");  
        
        System.out.println("\n\n");
    }
    
    static void printReceipt(Desert aDesert, int index)
    {
        System.out.format("│[%02d]%-30s%-5.2f│\n", index, aDesert.getName()
                                                 , aDesert.getEachCalculatedPrice());
        System.out.format("│%-4s%-35s│\n"        , " ", aDesert.getOrderDetail1());
        if(!aDesert.getOrderDetail2().equals(""))
            System.out.format("│%-4s%-35s│\n"    , " ", aDesert.getOrderDetail2());
    }
}
 

