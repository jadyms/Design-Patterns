import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
/**
 *
 * @author JadyMartins
 */
public class Main {
            CountryDAO dao = new MySQLCountryDAO();
            Menu init = new Menu();
            Input input = new Input();
            

    public Main() throws IOException {
        //Print welcome message
        init.printWelcome();
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
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
             
             } else if (option.equals("2")) {
                //Retrieve records by country name
                String message = "Input country name: ";
                 option = input.getInput(message);
                /*
                  do{
                    System.out.print("Input country name: ");
                    
                }while( (option = Input.Input()).matches(""));

                 
                 */                 
               
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
                
                /*
                   do{
                    System.out.print("Please input a country code: ");
                    
                }while( (option = Input.Input()).matches(""));
                
                */
                
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
                    String code = input.getValidCode("Input country code: ");
                 
                    String name = input.getValidName("Input country name: ");
                    
                    for(Continent c : Continent.values())
        {
            System.out.println(c.getValue());
        }
                    String continent = input.getValidContinent("Input continent from the options \n "
                                                       );
                              
               
                    String surfaceAreaString = input.getValidSurfaceArea("Input surface area: ");
                    double surfaceArea = Double.valueOf(surfaceAreaString);
                    
                    String headOfState = input.getValidHeadOfState("Input head of state: ");            
                   
                    
                   Country newCountry = new Country.CountryBuilder(code, name, headOfState).setContinent(continent).setSurfaceArea(surfaceArea).build();
                   boolean isInserted = dao.insertCountry(newCountry);
                   System.out.println("Country inserted into the db? " + isInserted);
                 
                                    
                   

		}
             
             
              
              
              
            
        }while(!(option.equals("")) || !(option.length() == 1) || !(option.matches("[1-5]+")));
       // }while(!(option.equals("")) || !(option.length() == 1) || !(option.matches("[1-5]+")));
  
        
    
        

    }
    
   
  
       public static void main (String [] args) throws IOException{
        
        Main main = new Main();
        //main.messyMenu();
        
    
    }
    
}
