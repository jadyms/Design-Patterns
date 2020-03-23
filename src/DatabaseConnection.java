
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JadyMartins
 */
public class DatabaseConnection {
    
    //Unique instance of the DatabaseConnection
    private static DatabaseConnection instance;
    
    //Credentials
    private static String db = "jdbc:mysql://52.50.23.197:3306/world?useSSL=true";
    private static String username = "cctstudent";
    private static String password = "Pass1234!";
    
    //Conection variables
    private static Connection connection = null;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    private DatabaseConnection(){
    
    }
        
    //Connection with the database
    private static Connection getDatabaseConnection() throws ClassNotFoundException{
              
        // Loading the database driver
        Class.forName("com.mysql.jdbc.Driver");
            
        
         try {
            //Get a connection to the database
            
             connection = DriverManager.getConnection(db,username, password);
           //connection = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?useSSL=true", "cctstudent", "Pass1234!");
         }catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return connection;
    }    
    
    //Retrieving data from the DB
    public ResultSet retrieveData(String query){
               
        
        try {
            connection = this.getDatabaseConnection();
            ps = connection.prepareStatement(query);       
             rs = ps.executeQuery(); 
            
                     
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
   
        return rs;
    }
    
    //Insertng data into the db
    
    public boolean insertData(String query){
        try {
             connection = this.getDatabaseConnection();
             ps = connection.prepareStatement(query);
             
             return true;
        
    } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }  
    
    
    public void closeStatements() throws SQLException{
        rs.close();
        ps.close();
        connection.close();
    }
    
public String[] retrieveRecords(String query) throws SQLException, ClassNotFoundException {  
          
         final ArrayList data = new ArrayList<>();
        
        
        try{
            connection = this.getDatabaseConnection();  
      
            ps = connection.prepareStatement(query);  
                    
         
            
                        rs = ps.executeQuery();  
                        while (rs.next()) { 
                            data.add(
                                    rs.getString("code") + " " + 
                                    rs.getString("name") + " " + 
                                    rs.getString("continent") + " " + 
                                    rs.getString("surfacearea")+ " " +
                                    rs.getString("headofstate"));
                           
                            /*
                                  System.out.println(
                                          rs.getString("code") + " " + 
                                          rs.getString("name") + " " + 
                                          rs.getString("continent") + " " + 
                                         rs.getString("surfacearea")+ " " +
                                         rs.getString("headofstate") );      
                           */             
                        }  
                        
                      /*ArrayList to Array Conversion */
                      //https://beginnersbook.com/2013/12/how-to-convert-arraylist-to-string-array-in-java/
		
                     
                        
                         //System.out.println(data);
                 } catch (Exception e){ 
                     System.out.println(e);
                 }
        
        
          finally{  
                    if(rs!=null){  
                        rs.close();  
                    }if (ps!=null){  
                      ps.close();  
                  }if(connection!=null){  
                      connection.close();  
                  }   
                }  
         String array[] = new String[data.size()];              
		for(int j =0;j<data.size();j++){
		  array[j] = (String) data.get(j);
		}

		/*Displaying Array elements*/
		for(String k: array)
		{
			System.out.println(k);
		}

        return array;
      }

     
     public void insertRecords(String query) throws ClassNotFoundException, SQLException{
          Connection connection = null;  
        PreparedStatement ps = null; 
        int counter = 0;
        
        try{
        connection = this.getDatabaseConnection();
        ps = connection.prepareStatement(query);
        counter = ps.executeUpdate();
        }catch(Exception e){}
        
        finally{
               if(ps!=null){
                   ps.close();
               } if(connection!=null){
                   connection.close();
               }
                }
     }
     
     //Instance created at runtime
    public static DatabaseConnection getInstance(){
        
        if (instance == null){  
            instance = new DatabaseConnection();  
        }  
        return instance;
    }
}


