
import java.util.Random;

public class MyClass {

	 static char[] characters = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '*', '&', '$', '#'  };
	
	 static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	 
	 static char password;
	 
	
	 
	 
	
	public static void main(String[] args) {

		 long digits_length = 0;
		 
		 int total_characters = characters.length;
		 
		 digits_length = digits.length;
		
		//pt 1
		
		for(int i = 0; i < 7; i++){
			digits_length *= total_characters;
		}
		System.out.print("total possible combinations: " + digits_length) ;
	
		
		
		//pt 2
		
		System.out.println();
		
			for(int i = 0; i < 8; i++) {
				
				if(i == 0) {
					password = (getRandNum(digits));
					System.out.print("password: " + password);
				}
				
				else {
					password = (getRandChar(characters));
					System.out.print(password);
				}
			
			}
		
	}
	
	public static char getRandChar(char[] arr) {
		int random = new Random().nextInt(arr.length);
	    return arr[random];
	}
	
	public static char getRandNum(char[] arr) {
		int random = new Random().nextInt(arr.length);
	    return arr[random];
	}
	
	



}
