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

		System.out.println("��������!");
		
        String choice="";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        
        
        
        try {
        	
        	MyGame game = new MyGame();
        	
        	while(!choice.equalsIgnoreCase("�")) {
        		System.out.print("(�) - ������, (�) - �����: ");
        		choice = br.readLine();
        		
        		if (choice.equalsIgnoreCase("�")) {
        			game.startNewGame();
        			while(!game.EndOfGame()) {
        				game.currentStatus();
        				System.out.print("������ �����: ");
        				choice = br.readLine();
        				game.GuessLetter(choice);
        			}
        		}
        		
        	} 
        	
        	System.out.print("�� ��������!");
            
            
        } catch (Exception e) {

            e.printStackTrace();
        }

	}
	
	

}

