import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author JadyMartins
 */

//Client class of the program
public class Main{
    CountryDAO dao = new MySQLCountryDAO(); //connection to the db using DAO
    Menu init = Menu.getInstance(); //prints data to console
    InputReader inputReader = new InputReader(); //get and validate inputReader
    String input = null; //for any user input
            
    public Main() throws IOException {
        
        //Print welcome message
        init.printMessage("SELECT AN OPTION FROM THE MENU");

        do{
            //Print menu of options
            init.printMenu();
            
            //Read user inputReader 
            input = inputReader.bufferedReader();
                         
             //Retrieve all records stored in the database table
            if(input.matches("1")){
                //Create arrayList of countries
                ArrayList<Country> countries = dao.getCountries();
                //Print the arrayList
                for(Country c: countries){
                    System.out.println(c);
                }
                //End of transaction
                System.out.println("=====  Press ENTER to continue =====");
                System.in.read();
             
            //Retrieve records by country name  
            }else if(input.equals("2")){
                
                //Get the country name
                String message = "Input country name: ";
                input = inputReader.getInput(message);
                
                //Look for country given the name
                //Return countries in a arrayList
                ArrayList<Country> countries = dao.findByName(input);
                
                //If name not found, letthe user know
                if(countries.isEmpty()){
                    System.out.println(input + " not found in the database");
                }
                //If found, print all the countries
                for(Country c: countries){
                    System.out.println(c);
                }
                //End of transaction
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
           
            //Retrieve records by country name
            }else if(input.equals("3")){
                
                 //Get the country code
                String message = "Please input a country code: ";
                input = inputReader.getInput(message);
                
                //Look for country given the code and return it
                Country country = dao.findByCode(input);
                //if country not found, let the user know
                if(country == null){
                    System.out.println(input + " not found in the database");
                //print country to the user    
                }else{
                    System.out.println("Country with code "+  input + " : " +country);
                }
                //End of Transaction
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
           
                //Add new records into the database
            }else if (input.equals("4")) {
                //Create a random 3char code and check if it exists in the db
                String randomCode;   
                Country country = null; 
                do{
                    randomCode = inputReader.randomCode(3); //create a code
                    //Check if code already exists
                    country = dao.findByCode(randomCode);
                }while(country != null);//repeat while no country code is found
                
                //Assign randomCode to String code
                String code = randomCode;
                System.out.println("Country code: "+ randomCode);
                //Get country name
                String name = inputReader.getAlphabeticName(
                        "Input country name: ");
                //Get continent
                String continent = inputReader.getValidContinent(
                        "Input a continent from the options: \n" 
                        + Continent.getContinents());
                //Get surface Area and parse it to double
                String surfaceAreaString = inputReader.getValidSurfaceArea(
                        "Input surface area: ");
                double surfaceArea = Double.valueOf(surfaceAreaString);
                //Get head of state
                String headOfState = inputReader.getAlphabeticName(
                        "Input head of state: ");   
                //Create the country using Builder
                Country newCountry = new Country.CountryBuilder(code, name, headOfState)
                        .setContinent(continent)
                        .setSurfaceArea(surfaceArea)
                        .build();
                //Insert into the db and return true if successful
                boolean isInserted = dao.insertCountry(newCountry);
                //If inserted into the database
                if(isInserted){
                    System.out.println("Country "  + newCountry + " created");
                }
                //End of Transaction
                System.out.println("====  Press ENTER to continue =====");
                System.in.read();
                
                //Terminate the system
		}else if (input.equals("5")){
                //Print goodbye message    
                init.printMessage("THANK YOU. GOODBYE");
                //Terminate
                return;
	}
            //until input matches 1 to 5
        }while(!(input.equals("")) || 
               !(input.length() == 1) || 
               !(input.matches("[1-5]+")));
    }

    public static void main (String [] args) throws IOException{
        new Main();
    }
}
