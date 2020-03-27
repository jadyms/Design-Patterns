
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JadyMartins
 */
public class MySQLCountryDAO implements CountryDAO{
    DatabaseConnection dc = DatabaseConnection.getInstance();
    
    
    @Override
    public ArrayList<Country> getCountries() {
        // public ArrayList<Country> getCountries() {
        
             ArrayList <Country> countries = new ArrayList<>();
            // ArrayList <Country> countries = new ArrayList<Country>();
             String query = "SELECT * FROM country;";
              
             ResultSet rs = dc.retrieveData(query);
             
             Country.CountryBuilder builder;
           
            // Country.CountryBuilder country = null;
             try {
                  
             while (rs.next()) {
                
                       builder = new Country.CountryBuilder(rs.getString("code"), rs.getString("name"), rs.getString("headofstate")).setContinent(rs.getString("continent")).setSurfaceArea(Double.valueOf(rs.getString("surfaceArea")));
                 
                        Country country = builder.build();
                       countries.add(country);
             }
             dc.closeStatements();
          
         } catch (SQLException ex) {
             Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
          
              return countries;   
    }

    @Override
    public Country findByCode(String code) {
       
             
             String query =  "SELECT * FROM country WHERE code = '" + code + "';";
             ResultSet rs = dc.retrieveData(query);
             Country country = null;
              try {
             if (rs.next()) {
                
                       country = new Country(
                         rs.getString("code"),
                                 rs.getString("name"),
                                 rs.getString("continent"),
                                 rs.getDouble("surfacearea"),
                                 rs.getString("headofstate"));
                        dc.closeStatements();
             return country;       
             }
             return null;
          
         } catch (SQLException ex) {
             Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
                return null; 
    }

    @Override
    public ArrayList<Country> findByName(String name) {
        //Name is not a primary key in the db
        //It is possible that users have inserted several inputs with the same name
        //That is the reason why an ArrayList is returned
        
         ArrayList <Country> countries = new ArrayList<Country>();
             
             String query =  "SELECT * FROM country WHERE name = '" + name + "';";
             ResultSet rs = dc.retrieveData(query);
             Country country = null;
             
             try {
                  
             while (rs.next()) {
                
                       country = new Country(
                         rs.getString("code"),
                                 rs.getString("name"),
                                 rs.getString("continent"),
                                 rs.getDouble("surfacearea"),
                                 rs.getString("headofstate"));
                 countries.add(country);
             }
             dc.closeStatements();
          
         } catch (SQLException ex) {
             Logger.getLogger(MySQLCountryDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
          
              return countries;
       
    }

    @Override
    public boolean insertCountry(Country country)  {
        String code = country.getCode();
        String name = country.getName();
        String continent = country.getContinent();
        double surfaceArea = country.getSurfaceArea();
        String headOfState = country.getHeadOfState(); 
     
    
        String query = "INSERT INTO country VALUES ('" + code + "', '" 
                                                       + name + "', '"
                                                       + continent + "', '"
                                                       + surfaceArea+ "', '"
                                                       + headOfState + "');";
        
      
            boolean isInserted = dc.insertData(query);
          
         dc.closeStatements();
          
       
       
        return isInserted;
    }
    
    
}
