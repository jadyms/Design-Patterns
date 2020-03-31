import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author JadyMartins
 */

//Client class of the program
public class Main{
    CountryDAO dao = new MySQLCountryDAO();
    Menu init      = Menu.getInstance();
    Input input    = new Input();
            

    public Main() throws IOException {
        
        //Print welcome message
        init.printMessage("SELECT AN OPTION FROM THE MENU");
        
        String option;
        do{
            //Print menu of options
             init.printMenu();
             //Read user input 
             option = input.ReadInput();
                         
             if (option.matches("1")) {
                //Retrieve all records stored in the database table
                ArrayList<Country> countries = dao.getCountries();
                
                for(Country c: countries){
                    System.out.println(c);
                }
                System.out.println("=====  Press ENTER to continue =====");
                System.in.read();
             
             } else if (option.equals("2")) {
                //Retrieve records by country name
                String message = "Input country name: ";
                 option = input.getInput(message);
                
                ArrayList<Country> countries = dao.findByName(option);
                if(countries.isEmpty()){
                    System.out.println(option + " not found in the database");
                }                 
                for(Country c: countries){
                    System.out.println(c);
                }
                
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
           
             }else if (option.equals("3")) {
                //Retrieve records by country name
                                 
                String message = "Please input a country code: ";
                
                option = input.getInput(message);
                
                
                Country country = dao.findByCode(option);
                if(country == null){
                    System.out.println(option + " not found in the database");
                } else{
                
                System.out.println("Country with code "+  option + " : " +country);

                }
                                 
                                
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
           
             }else if (option.equals("4")) {
                   //Add new records into the database
                   
                   //Generate code
                   
                   // send code to db and get a boolean
                   
                   //send boolean to 
                   // String code = input.getValidCode("Input country code: ");
                    Country country;
                     String randomCode;
                    do{
                     randomCode = input.randomCode(3);
                        System.out.println(randomCode);
                    
                    //Check if code already exists
                    country = dao.findByCode(randomCode);
                    
                                 
                    }while(country != null);
                    String code = randomCode;
                    System.out.println("Country code: "+ randomCode);
                    
                    String name = input.getAlphabeticName("Input country name: ");
                    
                    
                    String continent = input.getValidContinent("Input a continent from the options: \n" 
                            + Continent.getContinents());
                             
               
                    String surfaceAreaString = input.getValidSurfaceArea("Input surface area: ");
                    double surfaceArea = Double.valueOf(surfaceAreaString);
                    
                    String headOfState = input.getAlphabeticName("Input head of state: ");            
                   
                    
                   Country newCountry = new Country.CountryBuilder(code, name, headOfState).setContinent(continent).setSurfaceArea(surfaceArea).build();
          
                  
                
                 
                        boolean isInserted = dao.insertCountry(newCountry);
                        if(isInserted){
                               System.out.println("Country "  + newCountry + " created");
                      
                        }
                
                      
                    
                 
 System.out.println("====  Press ENTER to continue =====");
                System.in.read();
		}else if (option.equals("5")){
                    
                init.printMessage("THANK YOU. GOODBYE");
               return;
	}
                
             
             
              
              
              
            
        }while(!(option.equals("")) || !(option.length() == 1) || !(option.matches("[1-5]+")));

  
        
    
        

    }
    
   
  
       public static void main (String [] args) throws IOException{
        new Main();
       
    
    }
    
}
