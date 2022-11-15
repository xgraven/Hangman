import java.io.BufferedReader;
import java.io.InputStreamReader;


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
        			while(!game.endOfGame()) {
        				game.currentStatus();
        				System.out.print("Угадай букву: ");
        				choice = br.readLine();
        				game.guessLetter(choice);
        			}
        		}
        		
        	} 
        	
        	System.out.print("До свидания!");
            
            
        } catch (Exception e) {

            e.printStackTrace();
        }

	}
	
	

}

