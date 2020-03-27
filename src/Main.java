import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author JadyMartins
 */
public class Main {
            CountryDAO dao = new MySQLCountryDAO();
            Menu init = new Menu();
            ReadInput readInput = new ReadInput();
            

    public Main() throws IOException {
        //Print welcome message
        init.printWelcome();
        String option;
        do{
            //Print menu of options
             init.printMenu();
             //Read user input 
             option = readInput.ReadInput();
                         
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
                                 
                do{
                    System.out.print("Input country name: ");
                    
                }while( (option = readInput.ReadInput()).matches(""));

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
                                 
                do{
                    System.out.print("Please input a country code: ");
                    
                }while( (option = readInput.ReadInput()).matches(""));
                
                
                
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
                   
                    System.out.print("Input country code: ");
                    String code = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input country name: ");
                    String name = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Select continent: ");
                    System.out.println(Arrays.asList(Continent.values()));
                    String continent = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input surface area: ");
                    double surfaceArea = Double.valueOf(readInput.ReadInput());
                    
                    System.out.print("Input head of state: ");
                    String headOfState = readInput.ReadInput().toLowerCase();
                    
                   Country newCountry = new Country.CountryBuilder(code, name, headOfState).setContinent(continent).setSurfaceArea(surfaceArea).build();
                   boolean isInserted = dao.insertCountry(newCountry);
                    System.out.println("Country inserted into the db? " + isInserted);
                 
                                    
                   

		}
             
             
              
              
              
            
        }while(!(option.equals("")) || !(option.length() == 1) || !(option.matches("[1-5]+")));
  
        
    
        

    }
    
    public  void messyMenu() throws IOException{
            init.printWelcome();
       
       
        // Reading the user input
	String option = "";
        
        
        
        try{
           
            boolean readMenuInput = false; // stop when a number from 1 to 5 is inserted
            
            do{
                 init.printMenu();
        
        
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
                   
                    
                    
                    ArrayList<Country> countries = dao.getCountries();
                                      
                    for(Country c: countries){
                    System.out.println(c);
                    }
                    System.out.println("====  Press ENTER to continue =====");
                    System.in.read();
                    init.printMenu();
                    
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
                
        /*
           String query = "SELECT * FROM country WHERE name = '" + option + "';";
               Queries queries = new Queries(query);
             queries.retrieveData();
        */
     
             ArrayList<Country> countries = dao.findByName(option);
        
 
                                      
                    for(Country c: countries){
                    System.out.println(c);
                    }
                    
                    
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
                
        
          Country country = dao.findByCode(option);
          System.out.println(country);
        
          /*
             String query = "SELECT * FROM country WHERE code = '" + option + "';";
             Queries queries = new Queries(query);
             queries.retrieveData();
          */
                    
		} else if (option.equals("4")) {
                   //Add new records into the database
                   
                    System.out.print("Input country code: ");
                    String code = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input country name: ");
                    String name = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Select continent: ");
                    System.out.println(Arrays.asList(Continent.values()));
                    String continent = readInput.ReadInput().toLowerCase();
                    
                    System.out.print("Input surface area: ");
                    double surfaceArea = Double.valueOf(readInput.ReadInput());
                    
                    System.out.print("Input head of state: ");
                    String headOfState = readInput.ReadInput().toLowerCase();
                    
                   Country newCountry = new Country.CountryBuilder(code, name, headOfState).setContinent(continent).setSurfaceArea(surfaceArea).build();
                   boolean isInserted = dao.insertCountry(newCountry);
                    System.out.println("Country inserted into the db? " + isInserted);
                 
                    /*
                     String query = "INSERT INTO country VALUES ('" + code + "', '" 
                                                                    + name + "', '"
                                                                    + continent + "'ct                                                                + surfaceArea+ "', '"
                                                                    + headOfState + "');";
                 
            Queries queries = new Queries(query);
             queries.insertData();
                    */
                   
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
                    //Logout
                    String message = "THANK YOU. GOODBYE";
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
	
    }
    
       public static void main (String [] args) throws IOException{
        
        Main main = new Main();
        //main.messyMenu();
        
    
    }
    
}
