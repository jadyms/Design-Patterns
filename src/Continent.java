
import java.util.Arrays;


/**
 *
 * @author JadyMartins
 */
public enum Continent{
     
    
    SOUTH_AMERICA("South America"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    ASIA("Asia"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica");
   
     public String value;
     
    private Continent (String value){
    this.value = value;
}
    public String getValue(){
        
       
        return this.value;
}
     public static String getContinents(){
         String[] continents = new String[Continent.values().length];
         int count = 0;
         for (Continent c: Continent.values()){
             continents[count] = c.getValue();
             count++;
         }
                return Arrays.toString(continents);
     }
        
   
}
   



   
