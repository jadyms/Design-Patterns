
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
        
        
             ArrayList <Country> countries = new ArrayList<Country>();
             
             String query = "SELECT * FROM country;";
              
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
    public Country findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
