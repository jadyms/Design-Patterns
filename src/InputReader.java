import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author JadyMartins
 */
public class InputReader{
   // private boolean isEmpty;
    //For user input
    private String input = null;
    //For random alphanumeric code
    private final static String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";      
    
     //Read the user input, wrapped in a try catch
    public String bufferedReader(){
        BufferedReader br = new BufferedReader
                           (new InputStreamReader(System.in));
        try{
            input = br.readLine();
        }catch (Exception e) { // in case there is no input
            System.out.print("Insert an option: ");
        }
        return input;
    }
    
    //Fire the buffered reader and return input
    public String getInput(String message){
        do{ //print message and get input
            System.out.print(message);
            input = bufferedReader().trim(); 
        }while(input.isEmpty()); //until there is an input
        return input;
    }
    
    //Ask for user input and check if it has only alphabetic characteres
    public String getAlphabeticName(String message){
        do{
            
            input = getInput(message); //get the input
            
        }while(isAlphabetic(input) == false);    
        
        return input; //return input
    }
    
     //Ask for user input and check if it is a valid surface area    
    public String getValidSurfaceArea(String message){
        do{
            input = getInput(message);//get the input
            
        }while (isDouble(input)==false); 
        
        if(isValidSurface(input)){// if it has a double format
            return input;
            
        }else{// if it has NOT a double format
            //suggest using default value
            String answer = "Surface Area incompatible. "
                    + "Use default 0.00? Y or N \n";
            input = getInput(answer);
            
            //if yes, use default value
            }if(input.equalsIgnoreCase("y")){
                input = "0.00";
                System.out.println("Using default surface area " + input);
            }else{
                //recursively call the method
                input = getValidSurfaceArea(message);
            }         
            return input;
    }
    
    //Ask for user input and check if it is a valid continent   
    public String getValidContinent(String message){
        do{
              
             input = getInput(message); //get the input  
             
        }while (isAlphabetic(input) == false);
        
        if(isEnum(input)){ //if matches Enum list
            return input;
            
        }else{
             //suggest using default value
            String answer = "Continent not recognized. "
                    + "Use default ASIA? Y or N \n";
                input = getInput(answer);
            //if yes, use default value
            }if(input.equalsIgnoreCase("y")){
                input = Continent.ASIA.getValue();
                System.out.println("Using default continent " + input);
            //Recursively call the method
            }else{
                input = getValidContinent(message);
            }
            return input;
    }

    //Check if input is empty
    public boolean isEmpty(String input){
        if(input.matches("")){
            return true;
        }return false;
    }
    
    //Check if input is only alphabetic format
    public boolean isAlphabetic(String input){
        if(input.matches("[a-zA-Z][a-zA-Z ]+")){
            return true;
         }
        return false;
    } 
    
    //Check if input is in a double format
    public boolean isDouble(String input){
        if(input.matches("^[+-]?([0-9]*[.])?[0-9]+$")){
            return true;
        }
        return false;
    }  
    
    //Check if surface a number > 0
    public boolean isValidSurface(String surfaceArea){        
        double surfaceAreaDouble = Double.valueOf(surfaceArea);
        if((surfaceAreaDouble) >= 0){
            return true;
        }
        return false;
    }
    
    //Check if value is compatible with enum Continent
    public boolean isEnum(String option){
        for (Continent c : Continent.values()) { //loop through values
            if (c.getValue().equalsIgnoreCase(option)) 
                return true; //if they match
            }
        return false;
    }  
    
    
    /*
    The country code is generated randomically. The parameter is the
    number of alphanumeric characters the code must have
    Source code from: https://dzone.com/articles/generate-random-alpha-numeric
    Accessed: 30/03/2020
    */
    public static String randomCode(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHANUMERIC.length());
            builder.append(ALPHANUMERIC.charAt(character));
        }
        return builder.toString();
    }
}