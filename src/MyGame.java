
public class MyGame {
	
	private int count = 0;
	private int maxTries = 10;

	
	public MyGame(int limit) {
		initGame(limit);
	}
	
	public MyGame() {
		initGame(10);
	}
	
	private String currentWord = "";
	private String maskedWord = "";
	private String usedLetters = "";
	private char[] word;
	
	public void initGame(int limit)	{
		maxTries = limit;
		MyData.loadList();
	}
	
	public void startNewGame() {
		count = 0;
		usedLetters = "";
		currentWord = MyData.getRandomWord();
		word = currentWord.toCharArray();
		for (int i = 0; i < word.length; i++) word[i] = '_';
		maskedWord = String.valueOf(word);
	}
	
	public void currentStatus() {
		System.out.println("Слово: " + maskedWord + 
				" Осталось попыток: " + Integer.toString(maxTries - count) + 
				" Использованные буквы: " + getUsedLetters());
	}
	
	public boolean endOfGame() {
		return (count == maxTries || maskedWord.equalsIgnoreCase(currentWord));
	}
	
	
	
	public void guessLetter(String s) {
		s = s.substring(0,  1);
		usedLetters = usedLetters + s;
		if (currentWord.contains(s)) {
			System.out.println("Есть такая буква!");
			for (int i = 0; i < currentWord.length(); i++)
			{
				if (getCurrentWord().charAt(i) == s.charAt(0) ) {
					word[i] = s.charAt(0);
					
				}
			}
			maskedWord = String.valueOf(word);
			if (maskedWord.equalsIgnoreCase(currentWord)) {
				System.out.println("Вы угадали слово! Это " + currentWord);
			}
			
		}
		else {
			System.out.println("Мимо!");
			count++;
			if (count == maxTries) {
				System.out.println("Вы проиграли! Было загадано слово - " + currentWord);
			}
			
		}

	}

	public String getMaskedWord() {
		return maskedWord;
	}

	public String getCurrentWord() {
		return currentWord;
	}

	public String getUsedLetters() {
		return usedLetters;
	}
}
