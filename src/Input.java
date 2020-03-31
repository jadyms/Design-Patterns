import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author JadyMartins
 */
public class Input{
    public static String input;
    public boolean isEmpty;
    private String option = null;
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";      
    
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
        if(input.matches("")){
        return true;
        }return false;
    }
    
   public boolean isAlphabetic(String input){
         if(input.matches("[a-zA-Z][a-zA-Z ]+")){
       return true;
         }
         return false;
   } 

public boolean isDouble(String input){
     if(input.matches("^[+-]?([0-9]*[.])?[0-9]+$")){
       return true;
     }
         return false;
     
}   
   
   /*public boolean isValidCode(String code){
        
        if(!code.matches("^[a-zA-Z0-9]*$") || (code.length()>3)){
            return false;
        }
      
        return true;
    }
    */
    public boolean isValidSurface(String surfaceArea){
        
        double surfaceAreaDouble = Double.valueOf(surfaceArea);
        if((surfaceAreaDouble) >= 0){
        return true;
        }
        
        return false;
    }
        
    public String getValidSurfaceArea(String message){
         do{
             option = getInput(message);
        } 
      
          while (isDouble(option)==false);
         
         if(isValidSurface(option)){
              return option;
             
            }else{
                String answer = getInput("Surface Area incompatible. Use default 0.00? Y or N \n");
                option = answer;
            } if(option.equalsIgnoreCase("y")){
                    option = "0.00";
                    System.out.println("Using default surface area " + option);
                }else{
                  
                 option = getValidSurfaceArea(message);
             }
            
         
        return option;
    }
    /*
    public String getValidCode(String message){
 
        do{
             option = getInput(message);
        } 
        
        while (isValidCode(option)==false);
        return option;
    }
    */
    public String getAlphabeticName(String message){
         do{
             option = getInput(message);
        } 
         
        while (isAlphabetic(option) == false);
         
        return option;
        
    }
    
     
     

public static String randomCode(int count) {
StringBuilder builder = new StringBuilder();
while (count-- != 0) {
int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
builder.append(ALPHA_NUMERIC_STRING.charAt(character));
}


return builder.toString();
}

     public boolean isEnum(String option){
         
          for (Continent b : Continent.values()) {
            if (b.getValue().equalsIgnoreCase(option)) 
          
         return true;
            }
            return false;
     
     }  
   
      




public String getValidContinent(String message){
         
          do{
             
             option = getInput(message);
             
             
        } 
         
        
        while (isAlphabetic(option) == false);
          // while (!option.matches("[a-zA-Z][a-zA-Z ]+"));
      
          if(isEnum(option)){
              return option;
             
            }else{
                String answer = getInput("Continent not recognized. Use default ASIA? Y or N \n");
                option = answer;
            } if(option.equalsIgnoreCase("y")){
                    option = Continent.ASIA.getValue();
                    System.out.println("Using default continent " + option);
                }else{
                  
                 option = getValidContinent(message);
             }
            
          return option;
           
           }
}