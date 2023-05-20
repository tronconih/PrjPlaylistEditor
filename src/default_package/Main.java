/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package default_package;

import controller.GestorePlaylist;
import java.util.Scanner;

/**
 *
 * @author studente
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        GestorePlaylist gp = new GestorePlaylist();
        String risposta;
        
        System.out.println("Inserimento tracce\n");
        
        do{           
            gp.menu();

            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            System.out.println("\nVuoi inserire altre tracce?(s/n)");

            risposta = scan.nextLine();  // Read user input
            System.out.println("\nRisposta: " + risposta);  // Output user input
        }while("S".equals(risposta.toUpperCase()));        
        
    }
    
}
