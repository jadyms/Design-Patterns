
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class Input {
      public static String input;
      public boolean isEmpty;
      private String option = null;
      
    public String ReadInput(){
        
      
        //Read the user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = "";
        
        try {
            input = br.readLine();
        } catch (Exception e) {
            System.out.print("Insert an option: ");
        }
        return input;
    }
    
    public String getInput(String message){
      //  String option;
        do{
                    System.out.print(message);
                    option = ReadInput().trim();
                    
                }while( option.isEmpty());
        
        return option;
    }
    
    public boolean isEmpty(String input){
        if(input.matches(""));
        return true;
    }
    
    public boolean isValidCode(String code){
        
        if(!code.matches("^[a-zA-Z0-9]*$") || (code.length()>3)){
            return false;
        }
      
        return true;
    }
    
    public String getValidSurfaceArea(String message){
         do{
             option = getInput(message);
        } 
        
        while (!option.matches("^[+-]?([0-9]*[.])?[0-9]+$"));
        return option;
    }
    
    public String getValidCode(String message){
 
        do{
             option = getInput(message);
        } 
        
        while (isValidCode(option)==false);
        return option;
    }
    
    public String getValidName(String message){
         do{
             option = getInput(message);
        } 
         
        while (!option.matches("[a-zA-Z][a-zA-Z ]+"));
         
        return option;
        
    }
    
     public String getValidHeadOfState(String message){
         do{
             option = getInput(message);
        } 
         
        while (!option.matches("[a-zA-Z][a-zA-Z ]+"));
         
        return option;
        
    }

     public boolean isEnum(String option){
         
          for (Continent b : Continent.values()) {
            if (b.value.equalsIgnoreCase(option)) 
          
         return true;
            }
            return false;
     
     }  
     public String getValidContinent(String message){
         
          do{
             
             option = getInput(message);
             
             
        } 
         
        
        while (!option.matches("[a-zA-Z][a-zA-Z ]+"));
          
           /*
           for (Continent b : Continent.values()) {
            if (b.value.equalsIgnoreCase(option)) {
                option = b.getValue();
          */
          if(isEnum(option)){
              return option;
             
            }else{
                String answer = getInput("Continent not recognized. Use default ASIA? Y or N");
                option = answer;
            } if(option.equalsIgnoreCase("y")){
                    option = Continent.ASIA.toString();
                    System.out.println("Using default continent " + option);
                }else{
                  
                 option = getValidContinent(message);
             }
            /*
            else  {
                String answer = getInput("Continent not recognized. Use default ASIA? Y or N");
                option = answer;
                   
                  if(option.equalsIgnoreCase("y")){
                    option = Continent.ASIA.toString();
                    System.out.println("Default asia " + option);
                }else{
                  
                 option = getValidContinent(message);
             }
             */
            

   
    
           
          return option;
           
           }
}