
/**
 *
 * @author JadyMartins
 */
public enum Continent{
     
    
    SOUTH_AMERICA("South America"),
    EUROPE("europe"),
    NORTH_AMERICA("north america"),
    ASIA("asia"),
    AFRICA("africa"),
    OCEANIA("oceania");
   
     public String value;
     
    private Continent (String value){
    this.value = value;
}
    public String getValue(){
        return this.value;
}
     
        
   
}
   



   
