
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class Main {

    public Main() {
        
        System.out.println("INSERT A NUMBER OPTION");
        System.out.println("1 - Retrieve all records");
        System.out.println("2 - Retrieve records by country name");
        System.out.println("3 - Retrieve records by country code");
        System.out.println("4 - Add new records to the database");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = "";
        
        try {
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Insert an option");
        }
        
       DatabaseConnection conn = DatabaseConnection.getInstance();
        try {
            conn.retrieveRecords();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
       public static void main (String [] args){
        
        new Main();
    
    }
    
}
