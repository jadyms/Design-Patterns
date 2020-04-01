/**
 *
 * @author JadyMartins
 */

//Treating country as an object
public class Country {
    
    //Declaring variables of Country
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private String headOfState; 
    
    //Using Builder Pattern to create a Country
    private Country(CountryBuilder builder){
        this.code = builder.code;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.headOfState = builder.headOfState;
    }

    public static class CountryBuilder{;
    //Declaring variables for countryBuilder innerclass
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private String headOfState; 
    
    public CountryBuilder (String code, String name, String headOfState){
    this.code = code;
    this.name = name;
    this.headOfState = headOfState;
    this.surfaceArea = 0; //Default Value
    this.continent = Continent.ASIA.toString(); //Default Value
    }
  
    //Set optional values if default not used
    public CountryBuilder setSurfaceArea(double surfaceArea){
        this.surfaceArea = surfaceArea;
        return this;
    }
    
    public CountryBuilder setContinent(String continent){
        this.continent = continent;
        return this;
    }
    
    //Create a country
    public Country build(){
        return new Country(this);
    }
    
    }
    
    
    
    //Getters and Setters
    public String getCode(){
        return code;
    }
    /*
    public void setCode(String code){
        this.code = code;
    }
    */
    public String getName(){
        return name;
    }
    
    /*
    public void setName(String name){
        this.name = name;
    }
    */
     public String getContinent(){
        return continent;
    }
    /*
    public void setContinent(String continent){
        this.continent = continent;
    }
    */
     public double getSurfaceArea(){
        return surfaceArea;
    }
    /*
    public void setSurfaceArea(double surfaceArea){
        this.surfaceArea = surfaceArea;
    }
    */
     public String getHeadOfState(){
        return headOfState;
    }
    /*
    public void setHeadOfState(String headOfState){
        this.headOfState = headOfState;
    }
*/
    @Override
    public String toString() {
       return  code + ", "
                      + name + ", "
                        + continent + ", " + surfaceArea 
                          + ", " + headOfState ;
    }
    
    
}
