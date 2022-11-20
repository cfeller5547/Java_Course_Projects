import java.util.Scanner;

public class MyClass {


	
	public static void main(String[] args) {
		
		MyClass m = new MyClass();
		
		Scanner Keyboard = new Scanner(System.in);
		int input;
		
		
		System.out.println("Enter an integer: ");
		input = Keyboard.nextInt();
		
		System.out.println("result: " + m.function1(input, input));
	}
	
	public int function1(int base, int exponent) {
		
		System.out.println("base: " + base + "\t" + "exponent: " + exponent);
		
		if (exponent == 0) {
			return 1;
		}
		else {
			
			return base * function1(base, exponent-1);
		}
	}
	

}
