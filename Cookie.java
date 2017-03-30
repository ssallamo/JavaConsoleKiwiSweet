/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

/**
 * The Cookie menu.
 * Cookie is sold by dozen 
 * @author HJS
 * @version 2016. 3. 17.
 */
public class Cookie extends Desert
{
    private String name;
    private int    dozen;
    
    private double calculatedPrice;
    
    public Cookie()
    {
        this("", 0, 0.0);
    }    
 
    public Cookie(String name, int dozen, double calculatedPrice)
    {
        super("","","",0.0);
         this.name            = name;
        this.dozen           = dozen;
        this.calculatedPrice = calculatedPrice;        
    }
    
    /**
     * This is implements method for cookies
     * @return boolean : order- true,no order false
     */
    public boolean takesOrder()
    {
        boolean returnValue = false;
        displayDetailMenu();
        int choice = Input.getChoice("-> Just Choice what you want!", DesertAble.COOKIES.length);   
        if(choice==0) return false; //no choice and just return
        setName(DesertAble.COOKIES[choice-1]);
        setDozen(Input.getInteger("-> How much Cookies would you like?(dz.)"));    
        if(displayOrder()=='Y'){ //values assign into super class
            String tempMessage = getDozen()+" @ "+ DesertAble.COOKIE_DOZEN + "/dz.";
            super.setName(getName());
            super.setOrderDetail1(tempMessage);
            super.setEachCalculatedPrice(getCalculatedPrice());
            returnValue = true;
        }
        else{
            returnValue = false;
        }
        return returnValue;
    }
 
    /**
     * implementation of DesertAble interface 
     * Display Cookies Menu
     */
    public void displayDetailMenu()
    {
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("- [Cookies Menu] $" + DesertAble.COOKIE_DOZEN + " Per Dozen");
        System.out.println("------------------------------------------------------");
        for(int i=0; i<DesertAble.COOKIES.length; i++){
            System.out.format("- [%d] %-20s\n", (i+1), DesertAble.COOKIES[i]);
        }
        System.out.format("- [%d] %-20s\n", 0, "Cancel(return back)");
        System.out.println("──────────────────────────────────────────────────────");
    }
 
    /**
     * This method is abstract method from super class;Desert
     * the total one order about Cookies shows on terminal.
     * Y:enter order N: cancel
     */
    @Override
    public char displayOrder()
    {
        double tmpPrice = getDozen()*DesertAble.COOKIE_DOZEN;
        System.out.println("┌────────── Check Order ───────────┐");
        System.out.format ("│ Cookie: %-25s│\n",getName());
        System.out.format ("│ dz.   : %-25d│\n",getDozen());
        System.out.format ("│ Price : $%-24.2f│\n",tmpPrice );
        System.out.println("└──────────────────────────────────┘");        
        setCalculatedPrice(tmpPrice);//calculated price
        return Input.getChar("-> Would you like to enter your order? [Y/N]");
    }
 
    //from here getter and setter
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getDozen() {
        return dozen;
    }
 
    public void setDozen(int dozen) {
        this.dozen = dozen;
    }
 
    public double getCalculatedPrice() {
        return calculatedPrice;
    }
 
    public void setCalculatedPrice(double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }
}
 
