/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

import java.util.Date;
 
/**
 * This class has two static variables and two variables which are being static variables
 * @author HJS
 * @version 2016. 3. 16.
 */
 
enum  TYPEOFBUY {TAKE_AWAY, DINE_IN};
 
public class DesertToday{    
 
    public static int    todayTotalCustomer = 0; 
    public static double todayTotalSale     = 0.0;
    
    public int       totalItems; 
    public double    subTotalCost;
    public TYPEOFBUY takeAwayOrDinIn;
    public String    currentTime;
    
    public DesertToday(){
        this.totalItems      = 0; 
        this.subTotalCost    = 0.0;
        this.takeAwayOrDinIn = TYPEOFBUY.TAKE_AWAY;
    }
    
    public DesertToday(int totalItem, double subTotalCost){
        this.totalItems      = totalItem; 
        this.subTotalCost    = subTotalCost;
        this.takeAwayOrDinIn = TYPEOFBUY.TAKE_AWAY;        
    }
    
    /**
     * Stacking today sale amount
     * @param totalPayment : before tax sale amount
     */
    public void setOneOrder(double totalPayment) {
        this.subTotalCost += totalPayment;
        this.totalItems++;
    }
 
    //getter and setter
    public int getTotalItems() {
        return totalItems;
    }
 
    public double getSubTotalCost() {
        return subTotalCost;
    }
    
    //Total Cost calculation
    public double getTotalCost() {
        return this.subTotalCost*DesertAble.TAX_VALUE;
    }
 
    //Tax calculation
    public double getTax() {
        return (this.subTotalCost*(DesertAble.TAX_VALUE-1));
    }
 
    public static int getTodayTotalCustomer() {
        return todayTotalCustomer;
    }
 
    public static double getTodayTotalSale() {
        return todayTotalSale;
    }
 
    //getting current date and time
    public String getCurrentTime(){
        Date d = new Date();                  
        return d.toString();
    }
    
    public TYPEOFBUY getTakeAwayOrDinIn() {
        return takeAwayOrDinIn;
    }
 
    public void setTakeAwayOrDinIn(TYPEOFBUY takeAwayOrDinIn) {
        this.takeAwayOrDinIn = takeAwayOrDinIn;
    }    
}
 

