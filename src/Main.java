import java.util.HashMap;
import java.util.Scanner;

public class Main {

	static String[] keyPad = {"-","","abc","def","ghi","jkl","mno",
			"pqrs","tuv","wxyz"};
	static HashMap<Character,Integer> posMap = new HashMap<>();
	static HashMap<Character, Integer> keyMap = new HashMap<>();
	
	public static void main(String[] args) {
		buildMaps();
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		/*
		 * while loop: if condition is met then continuously do the block.
		 * while (condition) {
		 * 	do somthing.
		 * } 
		 */
		while (!line.equals("halt")) {
			System.out.println(getTime(line));
			line = sc.nextLine();
		}

	}

	private static void buildMaps() {
		for (int i=0;i<keyPad.length;i++) {
			String keyCharacters = keyPad[i];
			for (int j=0;j<keyCharacters.length();j++) {
				char c = keyCharacters.charAt(j);
				posMap.put(c, j);
				keyMap.put(c, i);
			}
		}
		
	}

	private static  int getTime(String line) {
		int retTime = 0;
		int prevKey = -1;
		for (int i=0;i<line.length();i++) {
			char c = line.charAt(i);
			int pushes=getPosition(c)+1;
			retTime+=pushes;
			int key = getKey(c);
			if (key==prevKey) {
				retTime+=2;
			}
			prevKey = key;
		}
		return retTime;
	}

	private static int getKey(char c) {
		// TODO Auto-generated method stub
		return keyMap.get(c); // suppose there is a map whose entry is character-keyIndex
	}

	private static int getPosition(char c) {
		// TODO Auto-generated method stub
		return posMap.get(c); //suppose there is a map whose entry is character-positionInTheKey
	}

}
