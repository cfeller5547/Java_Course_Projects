package Vehicle2;
import java.util.Scanner;


abstract class MotorVehicle {

	boolean running;
	String color;
	
	public MotorVehicle() {
		
	}
	
	public MotorVehicle(boolean initRunning, String initColor) {
		running = initRunning;
		color = initColor;
	}
	
} 
class Motorcycle extends MotorVehicle {
	
	boolean windshield;
	
	public Motorcycle() {
		
	}
	
	public Motorcycle(boolean initRunning, String initColor, boolean initWindshield) {
		super(initRunning, initColor);
		windshield = initWindshield;
	}
	
	
	public void start() {
		running = true;
		System.out.println("motorcycle running now? " + running + " | " + "Color: " + color + " | " + "windshield: " + windshield + " | " + "vehicle: motorcycle" + " | " + "motorcycle started");
	}
	public void stop() {
		running = false; 
		System.out.println("motorcycle running now? " + running + " | " + "Color: " + color + " | " + "windshield: " + windshield + " | " + "vehicle: motorcycle" + " | " + "motorcycle stopped");

	}
	
	public String toString() {
		return "motorcycle running: " + running + " | " + "Color: " + color + " | " + "windshield:" + windshield;
	}

}
	

class Car extends MotorVehicle{
	
	int doorCount;
	
	public Car() {
		
	}
	
	public Car(boolean initRunning, String initColor, int initDoorCount) {
		super(initRunning, initColor);
		doorCount = initDoorCount;
	}
	
	public void start() {
		running = true;
		System.out.println("Car running now? " + running + " | " + "Color: " + color + " | " + "doorCount: " + doorCount + " | " + "vehicle: car" + " | " + "car started");
	}
	public void stop() {
		running = false; 
		System.out.println("Car running now? " + running + " | " + "Color: " + color + " | " + "doorCount: " + doorCount + " | " + "vehicle: car" + " | " + "car stopped");
	}
	
	public String toString() {
		return "Car running: " + running + " | " + "Color: " + color + " | " + "doorCount:" + doorCount;
	}
	
}

class VehicleManager extends MotorVehicle{
	
	Scanner keyboard = new Scanner(System.in);
	
	public VehicleManager() {
		
	}
	
	Car my_arr[] = new Car[3];
	Motorcycle my_arr2[] = new Motorcycle[3];
	

	public void run() {
		
		my_arr[0] = new Car(false, "red", 4);
		my_arr[1] = new Car(false, "black", 2);
		my_arr[2] = new Car(false, "blue", 2);
		

		my_arr2[0] = new Motorcycle(false, "grey", false);
		my_arr2[1] = new Motorcycle(false, "brown", true);
		my_arr2[2] = new Motorcycle(false, "black", true);
		
		
		car_start_menu();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		car_stop_menu();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		motorcycle_start_menu();
		System.out.println("---------------------------------------------------------------------------------------------------------");
		motorcycle_stop_menu();
		
	}
	
	public void car_start_menu() {
		
	
		
		Scanner keyboard = new Scanner(System.in);
		int input;
		System.out.println("cars: ");
		for(int i = 0; i < 3; i++) {
			System.out.println(1+i + ": " + my_arr[i].toString());
		}
		
		System.out.println("Which car do you want to select?");
		input = keyboard.nextInt();
		
		switch(input) {
		
		case 1:
			my_arr[0].start();
			break;
		case 2:
			my_arr[1].start();
			break;
		case 3:
			my_arr[2].start();
			break;
		}
	}
	
	public void motorcycle_start_menu() {
		
		
		
		int input = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.println(1+i + ": " + my_arr2[i].toString());
		}
		
		;
		System.out.println("Which motorcycle do you want to select?");
		input = keyboard.nextInt();
		System.out.println("motorcycles: ");
		
		
		switch(input) {
		
		case 1:
			my_arr2[0].start();
			break;
		case 2:
			my_arr2[1].start();
			break;
		case 3:
			my_arr2[2].start();
			break;
		}
	}
	
public void car_stop_menu() {
		
	
		int input = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.println(1+i + ": " + my_arr[i].toString());
		}
		System.out.println("Which car do you want to stop?");
		input = keyboard.nextInt();
		
		switch(input) {
		
		case 1:
			my_arr[0].stop();
			break;
		case 2:
			my_arr[1].stop();
			break;
		case 3:
			my_arr[2].stop();
			break;
		}
	}
	
public void motorcycle_stop_menu() {

	
		int input = 0;
		
		for(int i = 0; i < 3; i++) {
			System.out.println(1+i + ": " + my_arr2[i].toString());
		}
		System.out.println("Which motorcycle do you want to stop?");
		input = keyboard.nextInt();
		
		switch(input) {
		
		case 1:
			my_arr2[0].stop();
			break;
		case 2:
			my_arr2[1].stop();
			break;
		case 3:
			my_arr2[2].stop();
			break;
		}
	}

}

class Vehicle_Test {
	
	
	public static void main(String[] args) {
		VehicleManager v = new VehicleManager();
		v.run();
	}
	
}
