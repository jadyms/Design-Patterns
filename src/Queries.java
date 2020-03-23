
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class Queries {
    
    String query;
    
    public Queries(String query){
    this.query = query;
    }
    
    public void retrieveData(){
        DatabaseConnection conn = DatabaseConnection.getInstance();
        //conn.retrieveRecords(query);
        conn.retrieveData(query);
    
    }
    
    public void insertData(){
        DatabaseConnection conn = DatabaseConnection.getInstance();
        try {
            conn.insertRecords(query);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        System.out.println(query);
    }
        
    }

