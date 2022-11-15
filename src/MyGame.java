
public class MyGame {
	private int count = 0;
	private int maxTries;

	
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
		System.out.println("�����: " + maskedWord + 
				" �������� �������: " + Integer.toString(maxTries-count) + 
				" �������������� �����: " + getUsedLetters());
	}
	
	public boolean EndOfGame() {
		return (count == maxTries || maskedWord.equalsIgnoreCase(currentWord));
	}
	
	
	public void GuessLetter(String s) {
		usedLetters = usedLetters + s;
		if (currentWord.contains(s)) {
			System.out.println("���� ����� �����!");
			for (int i = 0; i < currentWord.length(); i++)
			{
				if (getCurrentWord().charAt(i) == s.charAt(0) ) {
					word[i] = s.charAt(0);
					
				}
			}
			maskedWord = String.valueOf(word);
			if (maskedWord.equalsIgnoreCase(currentWord)) {
				System.out.println("�� ������� �����! ��� " + currentWord);
			}
			
		}
		else {
			System.out.println("����!");
			count++;
			if (count == maxTries) {
				System.out.println("�� ���������! ���� �������� ����� - " + currentWord);
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
