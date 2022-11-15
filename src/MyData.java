import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


public class MyData {
	
	private static List<String> listOfWords;
	
	public static void loadList() {
		try {
			listOfWords = Files.readAllLines(Paths.get("c:/temp/russian_nouns.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getRandomWord() {
		Random rn = new Random();
		return listOfWords.get(Math.abs(rn.nextInt()) % listOfWords.size());
	}
	
	
}
