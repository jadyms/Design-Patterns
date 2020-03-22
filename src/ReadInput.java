
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class ReadInput {
      public static String input;
      
    public String ReadInput(){
        
      
        //Read the user input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        input = "";
        
        try {
            input = br.readLine();
        } catch (Exception e) {
            System.out.println("Insert an option");
        }
        return input;
    }
    
}
