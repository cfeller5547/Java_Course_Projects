package Lottery;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;


//attempt 1: $1000 winnings
//attempt 2: $0 winnings
//attempt 3: $100 winnings
//attempt 4: $0 winnings
//maximum winnings: $1000

public class Lottery {

	static int[] official = new int[3];
	static int[] player = new int[3];
	final int[] PRIZES = {0,100,1000,10000};
	static int pick;
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		Scanner Keyboard = new Scanner(System.in);
		
		int count = 0;
		
		System.out.println("WELCOME TO THE LOTTERY");
		
		for(int i = 0; i < 3; i++) {
			official[i] = random.nextInt(10);
		}
		
		for(int i = 0; i < 3; i++) {
		System.out.println("Enter your number pick from 1-9. Your on pick number: " + (1 + i) );
		player[i] = Keyboard.nextInt();
		}
		
		display();
		
		for(int i = 0; i < official.length; i++) {
			for(int j = 0; j < player.length; j++) {
				if(official[i] == player[j]){
					count++;
					System.out.println("Common match is : "+ (official[i]));
				}
			}
		}
		
		switch(count) {
		
		case 0:
			System.out.println("Player won $0, you lost.");
			break;
		case 1: 
			System.out.println("One number matched. Player won $100!");
			break;
		case 2: 
			System.out.println("Two numbers matched. Player won $1000!!");
			break;
		case 3: 
			System.out.println("Every number matched. Player won $10000!!!");
			break;
		}
	}
	
	public static void display() {
		System.out.println("The random player number picks are: ");
		System.out.println(Arrays.toString(player));
		
		System.out.println("The official number picks are: ");
		System.out.println(Arrays.toString(official));
	}
}
