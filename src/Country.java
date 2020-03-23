/**
 *
 * @author JadyMartins
 */
public class Country {
    
    //Declaring variables
    private String code;
    private String name;
    private String continent;
    private double surfaceArea;
    private String headOfState; 
    
    public Country(String code, String name, String continent, double surfaceArea, String headOfState){
        //Assigning variables
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.surfaceArea = surfaceArea;
        this.headOfState = headOfState;
    }
    
    //Getters and Setters
    public String getCode(){
        return code;
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
     public String getContinent(){
        return continent;
    }
    
    public void setContinent(String continent){
        this.continent = continent;
    }
    
     public double getSurfaceArea(){
        return surfaceArea;
    }
    
    public void setSurfaceArea(double surfaceArea){
        this.surfaceArea = surfaceArea;
    }
    
     public String getHeadOfState(){
        return headOfState;
    }
    
    public void setHeadOfState(String headOfState){
        this.headOfState = headOfState;
    }

    @Override
    public String toString() {
        return "Country{" + "code=" + code + ", name=" + name + ", continent=" + continent + ", surfaceArea=" + surfaceArea + ", headOfState=" + headOfState + '}';
    }
    
    
}
