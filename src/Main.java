
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
                    //Retrieve all records stored in the database table
                    Queries queries = new Queries("select * from country");
                    
		} else if (option.equals("2")) {
                    //Retrieve records by country name
                    System.out.print("Input country name: ");
                  
        try{
           
            boolean readMenuInput = false;
            
                    
                    do{
                option = readInput.ReadInput().toLowerCase();
                // validating user input to not empty, only 1 character from 1 to 5
                if (!(option.equals(""))) {
                    readMenuInput = true;
                }else{
                    System.out.print("Please input a country name: ");
                    readMenuInput = false; // repeat until a number from 1 to 5 is inserted
                }
            }while (readMenuInput == false);
        }catch (Exception e){}
                
        String query = "SELECT * FROM country WHERE name = '" + option + "';";
               Queries queries = new Queries(query);
             queries.retrieveData();
                    
                    
		} else if (option.equals("3")) {
                    //Retrieve records by country code
                    System.out.print("Input country code: ");
                  
        try{
           
            boolean readMenuInput = false;
            
                    
                    do{
                option = readInput.ReadInput().toLowerCase();
               
                if (!(option.equals(""))) {
                    readMenuInput = true;
                }else{
                    System.out.print("Please input a country code: ");
                    readMenuInput = false; // repeat until a number from 1 to 5 is inserted
                }
            }while (readMenuInput == false);
        }catch (Exception e){}
                
        String query = "SELECT * FROM country WHERE code = '" + option + "';";
             Queries queries = new Queries(query);
             queries.retrieveData();
                    
                    
		} else if (option.equals("4")) {
                   //Add new records into the database
                   
                    System.out.print("Input country code: ");
                    String code = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input country name: ");
                    String name = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Select continent: ");
                    System.out.println(Continent.values());
                    String continent = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input surface area: ");
                    String surfaceArea = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input head of state: ");
                    String headOfState = readInput.ReadInput().toLowerCase();
                 
                    String query = "INSERT INTO country VALUES ('" + code + "', '" 
                                                                    + name + "', '"
                                                                    + continent + "', '"
                                                                    + surfaceArea+ "', '"
                                                                    + headOfState + "');";
                 
            Queries queries = new Queries(query);
             queries.insertData();
       /*
                             try{
           
            boolean readMenuInput = false;
            
                    
                    do{
                option = readInput.ReadInput().toLowerCase();
               
                if (!(option.equals(""))) {
                    readMenuInput = true;
                }else{
                    System.out.print("Please input a country code: ");
                    readMenuInput = false; // repeat until a number from 1 to 5 is inserted
                }
            }while (readMenuInput == false);
        }catch (Exception e){}
                            */
                
        
                   
                   

		} else if (option.equals("5")) {
                    System.out.println("5");
		} 
	

        
        
        
       
    }
    
       public static void main (String [] args){
        
        new Main();
    
    }
    
}
