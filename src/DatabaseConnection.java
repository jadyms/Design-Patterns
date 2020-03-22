
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JadyMartins
 */
public class DatabaseConnection {
    
    //Unique instance of the DatabaseConnection
    private static DatabaseConnection instance;
    
    
    private DatabaseConnection(){
    
    }
        
    //Connection with the database
    private static Connection getDatabaseConnection() throws ClassNotFoundException{
              
        // Loading the database driver
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection connection = null;
        
         try {
            //Get a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://52.50.23.197:3306/world?useSSL=true", "cctstudent", "Pass1234!");
         }catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return connection;
    }    
    
    
    
     public void retrieveRecords(String query) throws SQLException, ClassNotFoundException {  
        Connection connection = null;  
        PreparedStatement ps = null;  
        ResultSet rs = null;  
        
        try{
            connection = this.getDatabaseConnection();  
           //ps = connection.prepareStatement("select * from country");  
            ps = connection.prepareStatement(query);  
                      //  ps.setString();  
                        rs = ps.executeQuery();  
                        while (rs.next()) {  
                                  System.out.println(
                                          rs.getString("code") + " " + 
                                          rs.getString("name") + " " + 
                                          rs.getString("continent") + " " + 
                                         rs.getString("surfacearea")+ " " +
                                         rs.getString("headofstate") );      
                                        
                        }  
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
      }

     
     //Instance created at runtime
    public static DatabaseConnection getInstance(){
        
        if (instance == null){  
            instance = new DatabaseConnection();  
        }  
        return instance;
    }
}


