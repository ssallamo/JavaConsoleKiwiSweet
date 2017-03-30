/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

/**
 * The Candy menu.
 * Candy is sold by gram
 * @author HJS
 * @version 2016. 3. 17.
 */
public class Candy extends Desert
{
    private String name;
    private double gram;
    
    private double calculatedPrice;
 
    public Candy()
    {
        this("", 0.0, 0.0);
    }    
 
    public Candy(String name, double gram, double calculatedPrice)
    {
        super("","","",0.0);
         this.name            = name;
        this.gram            = gram;
        this.calculatedPrice = calculatedPrice;        
    }    
 
    /**
     * This is implements method for candies
     * @return boolean : order- true,no order false
     */
    public boolean  takesOrder()
    {
        boolean returnValue = false;
        displayDetailMenu();
        int choice = Input.getChoice("-> Just Choice what you want!", DesertAble.CANDY.length);   
        if(choice==0) return false; //no choice and just return
        setName(DesertAble.COOKIES[choice-1]);
        setGram(Input.getDouble("-> How much Cookies would you like?(gram.)"));    
        if(displayOrder()=='Y'){ //values assign into super class
            String tempMessage = getGram()+" @ "+ DesertAble.CANDY_GRAM + "/gram.";
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
     * Display Candies Menu
     */
    public void displayDetailMenu()
    {
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("- [Candies Menu] $" + DesertAble.CANDY_GRAM + " Per Gram");
        System.out.println("------------------------------------------------------");
        for(int i=0; i<DesertAble.CANDY.length; i++){
            System.out.format("- [%d] %-20s\n", (i+1), DesertAble.CANDY[i]);
        }
        System.out.format("- [%d] %-20s\n", 0, "Cancel(return back)");
        System.out.println("──────────────────────────────────────────────────────");
    }
    
    /**
     * This method is abstract method from super class;Desert
     * the total one order about Candies shows on terminal.
     * Y:enter order N: cancel
     */
    @Override
    public char displayOrder()
    {
        double tmpPrice = getGram()*DesertAble.CANDY_GRAM;
        System.out.println("┌────────── Check Order ───────────┐");
        System.out.format ("│ Candies: %-24s│\n",getName());
        System.out.format ("│ gram.  : %-24.2f│\n",getGram());
        System.out.format ("│ Price  : $%-23.2f│\n",tmpPrice );
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
 
    public double getGram() {
        return gram;
    }
 
    public void setGram(double gram) {
        this.gram = gram;
    }
 
    public double getCalculatedPrice() {
        return calculatedPrice;
    }
 
    public void setCalculatedPrice(double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }
} 
