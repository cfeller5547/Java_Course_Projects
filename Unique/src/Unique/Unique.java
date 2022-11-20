package Unique;
import java.util.Scanner;

public class Unique {
	
	static final int MAX_ENTRIES = 5;
	
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		int input;
		int buffer[];
		int count = 0;
		buffer = new int[MAX_ENTRIES];
		
		
		
		System.out.println("Enter length of array: ");
		count = Keyboard.nextInt();	
		if(count > MAX_ENTRIES) {
			System.exit(0);
		}
		buffer = getArray(Keyboard, count);	
		displayArray(buffer);
		}
		
	
	static void displayArray(int buffer[]) {
		System.out.println("Array Elements: ");
		for(int i: buffer) {
			System.out.println(i);
		}
	}
	
	static int[] getArray(Scanner Keyboard, int length ) {
		int tempArray[];
		
		tempArray = new int[length];
		
		for(int i = 0; i < length; i++) {
			
			
			if(i > MAX_ENTRIES-1) {
				return tempArray;
			}
			System.out.println("Element " + i + ":");
			
			int tempInt = Keyboard.nextInt();
			
			
			if(tempInt == -1) {
				System.exit(0);
			}
			tempArray[i] = tempInt;
		}
			return tempArray;
}

}

//for(int count = 0; count < buffer.length; count++) {
//	System.out.println("Enter a number: ");
//	input = Keyboard.nextInt();
//	buffer[count] = input;
//	if(count > MAX_ENTRIES) {
//		return;
//	}
