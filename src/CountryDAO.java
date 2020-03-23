
import java.util.ArrayList;


/**
 *
 * @author JadyMartins
 */
public interface CountryDAO {
    
    public ArrayList<Country> getCountries(); //retrieve from db
    public Country findByCode(String code); //get country by code
    public Country findByName(String name); //get country by name
    public boolean insertCountry(Country country); //insert new country to the db
    
    
}
