package Article;

import java.util.Scanner;


public class Article {

	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		
		String input;
		
		System.out.println("Enter a word:");
		input = Keyboard.nextLine();
		System.out.print(getArticle(input));
		System.out.println(" " + input);
	}
	
	static String getArticle(String Keyboard) {
		switch(Keyboard.charAt(0)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            return "an";
        default:
            return "a";
    }
		
	}

}
