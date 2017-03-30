/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

public abstract class Desert implements DesertAble
{
    //Every common variable
    private String  name;
    private String  orderDetail1;
    private String  orderDetail2;
    private double  eachCalculatedPrice;
   
    public Desert(String name){
        this(name, "", "", 0.0);        
    }
    
    public Desert(String name, String orderDetail1, String orderDeatil2, double calculatedPrice)
    {
        this.name                = name;
        this.orderDetail1        = orderDetail1;
        this.orderDetail2        = orderDeatil2;
        this.eachCalculatedPrice = calculatedPrice;
    }
    
    
    //from now getter n setter setting
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getOrderDetail1() {
        return orderDetail1;
    }
 
    public void setOrderDetail1(String orderDetail1) {
        this.orderDetail1 = orderDetail1;
    }
    
    public String getOrderDetail2() {
        return orderDetail2;
    }
 
    public void setOrderDetail2(String orderDetail2) {
        this.orderDetail2 = orderDetail2;
    }
 
    public double getEachCalculatedPrice() {
        return eachCalculatedPrice;
    }
    
    public void setEachCalculatedPrice(double eachCalculatedPrice) {
        this.eachCalculatedPrice = eachCalculatedPrice;
    }
    public String toString()
    {
        return  "\nName                : " + getName()
               +"\nOrderDetail1        : " + getOrderDetail1()
               +"\nOrderDetail2        : " + getOrderDetail2()
               +"\nEachCalculatedPrice : " + getEachCalculatedPrice();
    }
    
    //display checking order implement each of subClasses
    public abstract char displayOrder();
}

