/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

/**
 * interface of Desert Abstract Desert class
 * @author HJS
 * @version 2016. 3. 17.
 */
 
public interface DesertAble {
    //static final variable 
    public final double CANDY_GRAM       = 0.09;
    public final double COOKIE_DOZEN     = 3.99;
    public final double ICECREAM_SCOOP   = 1.95;
    public final double ICECREAM_TOPING  = 1.05;
    
    public final double SERVICE_CHARGE   = 5.00;    
    public final double TAX_VALUE        = 1.125;
    
    public final String NAME_OF_SHOP    = "Kiwi Sweet Desert Shop";    
    public final String ADDRESS_OF_SHOP = "150 Hobson Street, Auckland";
    
    public final String[] MENU_ITEMS    = {"Ice-Cream", "Candies", "Cookies"};
    public final String[] CANDY         = {"Cherry Sticks", "Coconut Slices", "Coffee Rio", "Dubble Bubble Gum"};
    public final String[] COOKIES       = {"Chocolate Chip Cookies", "Oatmeal Cookies"
                                          ,"Peanut Butter Cookies" , "Ginger Chip Cookies"};
    public final String[] ICE_CREAM     = {"Double Choc Chip", "Vanila Candy", "Beautiful Cherry", "Cafe Ore"};
    public final String[] ICE_TOPING    = {"Choc-Chips", "Caramel Syrup", "Choco Syrup", "Sinnamon Powder"};
 
    public final String[] DRINKS        = {"Coffee", "Soft Drink", "Water Bottle", "Chocolate Drink"}; 
    public final double[] DRINKS_PRICE  = {4.50, 3.50, 3.00, 5.00};  
    
    public boolean takesOrder(); // It will be changed the method behavior each sub classes for taking order
    public void displayDetailMenu(); // display each classes of menu
  
}

