/**
 *
 * @author JadyMartins
 */

//Print information to the screen
public class Menu {
     //Unique instance of the Menu - Singleton Lazy Instantiation
    private static Menu instance;
   
    public Menu(){
       
    }
    
    //Instance of Menu created at runtime
    public static Menu getInstance(){
        
        //If no instance was created, create a new one
        if (instance == null){  
            instance = new Menu();  
        }  
        return instance;
    }
    
         
   //Print a welcome message with some decoration 
    public void printMessage(String message){
        //Get the length
        int n = message.length();
       //Print decoration box  
        for (int i = 0; i < n + 4; i++){
            System.out.print("-");
        }
        System.out.println();
        System.out.println("* " + message + " *");
        for (int i = 0; i < n + 4; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    
    //Print options menu
    public void printMenu(){
        System.out.println("1 - Retrieve all records");
        System.out.println("2 - Retrieve records by country name");
        System.out.println("3 - Retrieve records by country code");
        System.out.println("4 - Add new records to the database");
        System.out.println("5 - Logout");
        System.out.println("Please input a number from 1 to 5");
    }
}
