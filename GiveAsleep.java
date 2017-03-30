/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiwisweetcheckout;

/**
 * It is a part of assignment requirement
 * ; unsing runable thread
 * @author HJS
 * @version 2016. 3. 20.
 */
public class GiveAsleep implements Runnable {
 
    public void run()
    {
        for(int even=1; even<2 ; even++)
        {
            System.out.println("Old Thread Kills and New Thread Creates!");
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
 

