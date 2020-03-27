/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class Menu {
   
    public Menu(){
        
     
       
    }
    public void printWelcome(){
         //Print a welcome message with some decoration 
        String message = "SELECT AN OPTION FROM THE MENU";
        int n = message.length();
        
        for (int i = 0; i < n + 4; i++) {
            System.out.print("-");
        }
        
        System.out.println();
        System.out.println("* " + message + " *");
        
        for (int i = 0; i < n + 4; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    
    public void printMenu(){
                 
        //Print options menu
        System.out.println("1 - Retrieve all records");
        System.out.println("2 - Retrieve records by country name");
        System.out.println("3 - Retrieve records by country code");
        System.out.println("4 - Add new records to the database");
        System.out.println("5 - Logout");
        System.out.println("Please input a number from 1 to 5");
    }
    
    
}
