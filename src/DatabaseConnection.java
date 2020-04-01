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
    
    //Credentials
    private static String db = "jdbc:mysql://52.50.23.197:3306/world?useSSL=true";
    private static String username = "cctstudent";
    private static String password = "Pass1234!";
    
    //Connection variables
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
           }catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
         
        return connection;
    }    
    
    //Retrieving data from the DB
    public ResultSet retrieveData(String query){
        try {
            connection = this.getDatabaseConnection(); //unique instance
            ps = connection.prepareStatement(query);       
            rs = ps.executeQuery(); 
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    //Inserting data into the db
    public boolean insertData (String query){
        try{
            connection = this.getDatabaseConnection();
            ps = connection.prepareStatement(query);
            ps.executeUpdate();
            return true;
        }catch (SQLException | ClassNotFoundException ex){
            System.out.println("An Error Has Occurred: " + ex);
            return false;
        }
    }  
    
    public void closeStatements() {
        //Closing the connections
        try{
            rs.close();
            ps.close();
            connection.close();
        }catch(Exception e){}
    }
     
     //Instance created at runtime
    public static DatabaseConnection getInstance(){        
        if (instance == null){  
            instance = new DatabaseConnection();  
        }  
        return instance;
    }
}


