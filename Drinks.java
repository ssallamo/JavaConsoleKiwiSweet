/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

public class Drinks extends Desert{
 
    private String name;
    private double price;
    
    private double calculatedPrice;
    
    public Drinks()
    {
        this("", 0.0, 0.0);
    }    
 
    public Drinks(String name, double price, double calculatedPrice)
    {
        super("","","",0.0);
         this.name            = name;
        this.price           = price;
        this.calculatedPrice = calculatedPrice;        
    }    
 
    /**
     * This is implements method for dine-in drinks
     * @return boolean : order- true,no order false
     */
    public boolean takesOrder() {
        boolean returnValue = false;
        displayDetailMenu();
        int choice = Input.getChoice("-> Just Choice what you want!", DesertAble.DRINKS.length);   
        if(choice==0) return false; //no choice and just return
        setName(DesertAble.DRINKS[choice-1]);
        setPrice(DesertAble.DRINKS_PRICE[choice-1]);
        //drink price + service price
        setCalculatedPrice(DesertAble.DRINKS_PRICE[choice-1]+DesertAble.SERVICE_CHARGE);
        if(displayOrder()=='Y'){ //values assign into super class
            String tempMessage = "Dine-in Service Charge($"+DesertAble.SERVICE_CHARGE+")";
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
     * Display Dine-in Drink Menu
     */
    public void displayDetailMenu() {
        
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("- [Dine-In Drinks Menu] ");
        System.out.println("------------------------------------------------------");
        for(int i=0; i<DesertAble.DRINKS.length; i++){
            System.out.format("- [%d] %-18s $%-1.2f\n", (i+1), DesertAble.DRINKS[i], DesertAble.DRINKS_PRICE[i]);
        }
        System.out.format("- [%d] %-20s\n", 0, "Cancel(return back)");
        System.out.println("──────────────────────────────────────────────────────");
        
    }
 
    /**
     * This method is abstract method from super class;Desert
     * the total one order about Ice-cream shows on terminal.
     * Y:enter order N: cancel
     */
    @Override
    public char displayOrder()
    {
        double tmpPrice = DesertAble.SERVICE_CHARGE+getPrice();//drink price + service price    
        System.out.println("┌────────── Check Order ───────────┐");
        System.out.format ("│ Drink : %-19s$%-3.2f │\n",getName(), getPrice());
        System.out.format ("│ extra : %-19s$%-3.2f │\n", "Service Charge",DesertAble.SERVICE_CHARGE);
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
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public double getCalculatedPrice() {
        return calculatedPrice;
    }
 
    public void setCalculatedPrice(double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }
}
