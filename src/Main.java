
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class Main {

    public Main() {
        
        Menu init = new Menu();
        ReadInput readInput = new ReadInput();
        
        // Reading the user input
	String option = "";
        
        try{
           
            boolean readMenuInput = false; // stop when a number from 1 to 5 is inserted
            
            do{
                option = readInput.ReadInput();
                // validating user input to not empty, only 1 character from 1 to 5
                if (!(option.equals("")) && (option.length() == 1) && (option.matches("[1-5]+"))) {
                    readMenuInput = true;
                }else{
                    System.out.println("Please choose a valid option");
                    readMenuInput = false; // repeat until a number from 1 to 5 is inserted
                }
            }while (readMenuInput == false);
        }catch (Exception e){}
                
                // For each option of the menu there is a method being called here
		if (option.equals("1")) {
		System.out.println("1");
		} else if (option.equals("2")) {
			System.out.println("2");
		} else if (option.equals("3")) {
			System.out.println("3");
		} else if (option.equals("4")) {
		System.out.println("4");
		} else if (option.equals("5")) {
		System.out.println("5");
		} 
	

        
        
//        
//       DatabaseConnection conn = DatabaseConnection.getInstance();
//        try {
//            conn.retrieveRecords();
//        } catch (SQLException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    
       public static void main (String [] args){
        
        new Main();
    
    }
    
}
