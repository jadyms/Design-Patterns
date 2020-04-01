import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JadyMartins
 */

//DAO Pattern separating client from database connection
public class MySQLCountryDAO implements CountryDAO{
    
    //Access to db connection using Singleton Lazy Insantiation
    DatabaseConnection dc = DatabaseConnection.getInstance();
    
    @Override
       // Retrieve all countries from the database
    public ArrayList<Country> getCountries(){
        
        //Create an array of countries
        ArrayList <Country> countries = new ArrayList<>(); 
        
        //Declaration of the builder       
        Country.CountryBuilder builder = null;
        
        //Send query to the database and return rs
        String query = "SELECT * FROM country;";
        ResultSet rs = dc.retrieveData(query);
        
        //Loop over result set
        try{
            while(rs.next()){ //assign values
                String code = rs.getString("code");
                String name = rs.getString("name");
                String headOfState = rs.getString("headofstate");
                String continent = rs.getString("continent");
                String surfaceString = rs.getString("surfaceArea");
                double surfaceArea = Double.valueOf(surfaceString);
                          
                //Creation of the Builder Object
                builder = new Country.CountryBuilder(code,name ,headOfState).
                        setContinent(continent).setSurfaceArea(surfaceArea);
                
                //Creation of the Country Object using Builder
                Country country = builder.build();
                
                //Add Object Country to the array
                countries.add(country);
             }
            //Close connection
            dc.closeStatements();
          
        }catch (SQLException ex){
            Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;   
    }

    @Override
    //Return a country matching a given code
    public Country findByCode(String code){
        
        //Send query to the database and get rs in return
        String query =  "SELECT * FROM country WHERE code = '" + code + "';";
        ResultSet rs = dc.retrieveData(query);
        
        //Declaration of the builder    
        Country.CountryBuilder builder = null;
        
        try{
            if(rs.next()){//if result set is not empty, assign values
                String name = rs.getString("name");
                String headOfState = rs.getString("headofstate");
                String continent = rs.getString("continent");
                String surfaceString = rs.getString("surfaceArea");
                double surfaceArea = Double.valueOf(surfaceString);
                
                //creation of the Builder Object
                builder = new Country.CountryBuilder(code,name ,headOfState).
                        setContinent(continent).setSurfaceArea(surfaceArea);

                //Closing connection
                dc.closeStatements();
                
                //Create country and return it
                Country country = builder.build();
                return country;       
            }
            return null;
        }catch (SQLException ex){
            Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }

    @Override
    /*
    Find a country in the database given the name
    Country name is not a primary key in the db
    It is possible that users have inserted several inputs with the same name
    That is the reason why an ArrayList is returned
    */
    public ArrayList<Country> findByName(String name){
        //Create an ArrayList of countries
        ArrayList <Country> countries = new ArrayList<Country>();
        
          //Declaration of the builder       
        Country.CountryBuilder builder = null;
        
        //Send query to the database and get rs in return
        String query =  "SELECT * FROM country WHERE name = '" + name + "';";
        ResultSet rs = dc.retrieveData(query);
        
        try{
            while(rs.next()){ //Loop over the db and assign values
                String code = rs.getString("code");
                String headOfState = rs.getString("headofstate");
                String continent = rs.getString("continent");
                String surfaceString = rs.getString("surfaceArea");
                double surfaceArea = Double.valueOf(surfaceString);
                
                //creation of the Builder Object
                builder = new Country.CountryBuilder(code,name ,headOfState).setContinent(continent).setSurfaceArea(surfaceArea);

                //Create the country
                Country country = builder.build();
                
                //Add the countries to the arrayList
                countries.add(country);
            }
            //Closing connection
            dc.closeStatements();
        }catch (SQLException ex){
            Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }

    @Override
    //Add a new country to the database
    public boolean insertCountry(Country country){
        //Get the values
        String code = country.getCode();
        String name = country.getName();
        String continent = country.getContinent();
        double surfaceArea = country.getSurfaceArea();
        String headOfState = country.getHeadOfState(); 
        
        //Generate query
        String query = "INSERT INTO country VALUES ('" + code + "', '" 
                                                       + name + "', '"
                                                       + continent + "', '"
                                                       + surfaceArea+ "', '"
                                                       + headOfState + "');";
        //Insert values to the db and return true for success
        boolean isInserted = dc.insertData(query);
        //Closing connection
        dc.closeStatements();
        //Return true if value was inserted in the db
        return isInserted;
    }
}
