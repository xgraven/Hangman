import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Hangman {

	public static void main(String[] args) {

		System.out.println("Виселица!");
		
        String choice="";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        
        
        try {
        	
        	MyGame game = new MyGame();
        	
        	while(!choice.equalsIgnoreCase("в")) {
        		System.out.print("(и) - Играть, (в) - Выход: ");
        		choice = br.readLine();
        		
        		if (choice.equalsIgnoreCase("и")) {
        			game.startNewGame();
        			while(!game.EndOfGame()) {
        				game.currentStatus();
        				System.out.print("Угадай букву: ");
        				choice = br.readLine();
        				game.GuessLetter(choice);
        			}
        		}
        		
        	} 
        	
        	System.out.print("До свидания!");
            
            
        } catch (Exception e) {

            e.printStackTrace();
        }

	}
	
	

}

