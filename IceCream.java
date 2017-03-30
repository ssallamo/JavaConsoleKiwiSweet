/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

/**
 * The Ice-cream menu.
 * Ice-Cream is sold by scoops 
 * and customer can choice toping menu
 * @author HJS
 * @version 2016. 3. 17.
 */
public class IceCream extends Desert
{
    private String name;
    private int    scoops;
    private String topingName;
 
    private double calculatedPrice;    
        
    public IceCream()
    {
        this("", 0, "", 0.0);
    }    
 
    public IceCream(String name, int scoops, String topingName, double calculatedPrice)
    {
        super("","","",0.0);
         this.name            = name;
        this.scoops          = scoops;
        this.topingName      = topingName;
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
        int choice  = Input.getChoice("-> Just Choice what you want!", DesertAble.ICE_CREAM.length);
        if(choice==0) return false; //no choice and just return
        setName(DesertAble.ICE_CREAM[choice-1]);        
        setScoops(Input.getInteger("-> How many Scoops would you like?"));
        char yn     = Input.getChar("-> Do you want special falvor on top? [Y/N]");
        if(yn == 'Y'){//toping choice
            displayTopingMenu(); 
            int choiceToping = Input.getChoice("-> Just Choice what you want!"
                                              , DesertAble.ICE_TOPING.length);
            if(choiceToping>0) setTopingName(DesertAble.ICE_TOPING[choiceToping-1]);
        }
        if(displayOrder()=='Y'){ //values assign into super class
            super.setName(getName());
            String tempMessage = getScoops()+" @ "+ DesertAble.ICECREAM_SCOOP + "/scoop.";
            super.setOrderDetail1(tempMessage);
            if(!getTopingName().equals("")){//toping
                String tempMessage2 = "with " + getTopingName();
                super.setOrderDetail2(tempMessage2);
            }
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
     * Display Ice-Cream Menu
     */
    public void displayDetailMenu()
    {
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("> [Ice Cream Menu] $" + DesertAble.ICECREAM_SCOOP + " Per one Scoop");
        System.out.println("------------------------------------------------------");
        for(int i=0; i<DesertAble.ICE_CREAM.length; i++){
            System.out.format("- [%d] %-20s\n", (i+1), DesertAble.ICE_CREAM[i]);
        }
        System.out.format("- [%d] %-20s\n", 0, "Cancel(return back)");
        System.out.println("──────────────────────────────────────────────────────");
    }
    
    /**
     * Ice-cream products provide 1 extra toping and extra charge
     */
    public void displayTopingMenu()
    {
        System.out.println("\n\n");
        System.out.println("──────────────────────────────────────────────────────");
        System.out.println("> [Ice Cream Toping Menu] $" + DesertAble.ICECREAM_TOPING);
        System.out.println("------------------------------------------------------");
        for(int i=0; i<DesertAble.ICE_TOPING.length; i++){
            System.out.format("- [%d] %-20s\n", (i+1), DesertAble.ICE_TOPING[i]);
        }
        System.out.format("- [%d] %-20s\n", 0, "Cancel(no Toping)");
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
        double tmpPrice = (getScoops()*DesertAble.ICECREAM_SCOOP);//default value
 
        System.out.println("┌────────── Check Order  ───────────┐");
        System.out.format ("│ Product: %-25s│\n",getName());
        System.out.format ("│ Scoops : %-25d│\n",getScoops());
        if(!getTopingName().equals("")){//toping 
            tmpPrice += DesertAble.ICECREAM_TOPING;
            System.out.format ("│ Toping : %-25s│\n",getTopingName());
        }
        System.out.format ("│ Price  : $%-24.2f│\n",tmpPrice );
        System.out.println("└───────────────────────────────────┘");
        //calculated price and assign to the private variable
        setCalculatedPrice(tmpPrice);        
        return Input.getChar("-> Would you like to enter your order? [Y/N]");
    }
    
    //from now getter and setter
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getScoops() {
        return scoops;
    }
 
    public void setScoops(int scoops) {
        this.scoops = scoops;
    }
 
    public double getCalculatedPrice() {
        return calculatedPrice;
    }
 
    public void setCalculatedPrice(double calculatedPrice) {
        this.calculatedPrice = calculatedPrice;
    }
 
    public String getTopingName() {
        return topingName;
    }
    
    public void setTopingName(String topingName) {
        this.topingName = topingName;
    }
}
 

