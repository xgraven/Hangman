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
			e.printStackTrace();
		}
	}
	
	public static String getRandomWord() {
		String result = "";
		try {
			Random rn = new Random();
			result = listOfWords.get(Math.abs(rn.nextInt()) % listOfWords.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
						
	}
	
	
}
