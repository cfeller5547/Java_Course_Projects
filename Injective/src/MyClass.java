import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




public class MyClass {

	
	public static int f1(int x) {
		int result;
		result = (3 * x);
		return result;
	}
	
	public static int f2(int x) {
		int result;
		result = (x*x);
		return result;
	}
	
	public static int f3(int x) {
		int result;
		result = (2*x) - 2;
		return result;
	}
	
	
	public static void main(String[] args) {
		
		
		//create HashMap
		 HashMap<Integer, Integer> hshMap = new HashMap<Integer, Integer>();
	
		
		Scanner Keyboard = new Scanner(System.in);
		String input;
		
		
		while(true) {
		System.out.println("Select a function: ");
		System.out.println("\t" + "1. f(x) = 3x");
		System.out.println("\t" + "2. f(x) = x^2");
		System.out.println("\t" + "3. f(x) = 2x - 2");
		System.out.println("\t" + "4. Quit");
		
		input = Keyboard.nextLine();
		
		switch(input){
		
		case "1": 
			
			for(Integer i = 1; i <= 100; i++) {
				hshMap.put(i,f1(i));
			}
			HashSet<Integer>set_1_values=new HashSet<>(hshMap.values());
			if(set_1_values.size() == hshMap.keySet().size()) {
				System.out.println("This function is injective");
				System.out.println();
			}
			else {
				System.out.println("This function is not injective");
				System.out.println();
			}
			break;
			
		case "2":
			
			for(Integer i = 1; i <= 100; i++) {
				hshMap.put(i,f2(i));
			}
			HashSet<Integer>set_2_values=new HashSet<>(hshMap.values());
			if(set_2_values.size() == hshMap.keySet().size()) {
			}
			else {
				System.out.println("This function is not injective");
				System.out.println();
			}
			System.out.println("Values size: " + set_2_values.size());
			System.out.println("Keys size: " + hshMap.keySet().size());
			break;
			
		case "3":
			
			for(Integer i = 1; i <= 100; i++) {
				hshMap.put(i,f3(i));
			}
			HashSet<Integer>set_3_values=new HashSet<>(hshMap.values());
			if(set_3_values.size() == hshMap.keySet().size()) {
				System.out.println("This function is injective");
				System.out.println();
			}
			else {
				System.out.println("This function is not injective");
				System.out.println();
			}
			break;
			
		case "4": 
			return;
		}
		
	}
	}

}
