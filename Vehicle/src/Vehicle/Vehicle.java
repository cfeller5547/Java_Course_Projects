package Vehicle;
import java.util.Scanner;


abstract class Vehicle 
{

	int max_speed;
	String name;
	String s = String.valueOf(max_speed);
	
	public abstract float runningCost (float hours_of_operation);
	
	public Vehicle() 
	{
	}		
	
	public Vehicle(String initName, int initMaxSpeed) 
	{
		name = initName;
		max_speed = initMaxSpeed;
	}		
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setMaxSpeed(int max_speed) 
	{
		this.max_speed = max_speed;
	}
	
	public int getMaxSpeed() 
	{
		return max_speed;
	}

	public static void main(String[] args) 
	{

		VehicleDemo demo = new VehicleDemo();
		demo.display();
	
	}
	
	public String toString() {
		return "name: " + getName() + "max speed: " + s;
	}
}


class Car extends Vehicle {
	
	int number_of_cylinder;
	private static final float cost_per_cylinder_per_hour = 50;
	
	public Car() {
	
	}
	
	public Car(String initName, int initMaxSpeed, int initCarCylinderNum) {
		super(initName, initMaxSpeed);
		number_of_cylinder = initCarCylinderNum;
		
	}
	
	public void setCarNumberOfCylinder(int number_of_cylinder) {
		this.number_of_cylinder = number_of_cylinder;
	}
	
	public int getCarNumberOfCylinder() {
		return number_of_cylinder;
	}
	
	public float runningCost(float hours) {
		return (hours * cost_per_cylinder_per_hour * getCarNumberOfCylinder());
	}
	
	public float maintenanceCost(float cost_per_cylinder_per_hour) {
		return (cost_per_cylinder_per_hour*getCarNumberOfCylinder());
	}
	
	public String toString() {
		//return super.toString() + " | " + "number of cylinders: " + getCarNumberOfCylinder() + " | " + "maintenance cost: " + maintenanceCost(cost_per_cylinder_per_hour)
		return "name: " + name + " | " + "max speed: " + max_speed + " | " + "number of cylinders: " + getCarNumberOfCylinder() + " | " + "maintenance cost: " + maintenanceCost(cost_per_cylinder_per_hour);
	}
}

class Airplane extends Vehicle{
	
	int number_of_engine;
	private static final float cost_per_engine_per_hour = 100;
	
	public Airplane(String initName, int initMaxSpeed, int initAirplaneEngineNum) {
		super(initName, initMaxSpeed);
		number_of_engine = initAirplaneEngineNum;
		
	}
	
	public Airplane() {
	}
	
	public void setAirplaneEngineNumber(int number_of_engine) {
		this.number_of_engine = number_of_engine;
	}
	
	public int getAirplaneEngineNumber() {
		return number_of_engine;
	}
	
	public float runningCost(float hours) {
		return (hours * cost_per_engine_per_hour * getAirplaneEngineNumber());
	}
	
	public float maintenanceCost(float cost_per_engine_per_hour) {
		return (cost_per_engine_per_hour*getAirplaneEngineNumber());
	}
	
	public String toString() {
		return "name: " + name + " | " + "max speed: " + max_speed + " | " + "number of engines: " + getAirplaneEngineNumber() + " | " + "maintenance cost: " + maintenanceCost(cost_per_engine_per_hour);
	}
}

interface Maintainable{
	float maintenanceCost (float cost_per_unit);
}

class VehicleDemo 
{
	Car car;
	Airplane airplane;
	Vehicle v1;

	public VehicleDemo() {
		car = new Car();
		car.setName("BMW");
		car.setMaxSpeed(100);
		car.setCarNumberOfCylinder(8);
		car.maintenanceCost(50);

		airplane = new Airplane();
		airplane.setName("Boeing");
		airplane.setMaxSpeed(400);
		airplane.setAirplaneEngineNumber(6);
		airplane.maintenanceCost(50);
		
		v1 = new Car();
	}
	
	public void display() 
	{	
		
		System.out.println(car.toString());
		System.out.println("---------------------------------------------------------------------------------------------------------");

		
		System.out.println(airplane.toString());	
		System.out.println("---------------------------------------------------------------------------------------------------------");

		
		String name = car.getName();
		int maxSpeed = car.getMaxSpeed();
		int cylinderSize = car.getCarNumberOfCylinder();
		System.out.println("test car method getName(): " + name);
		System.out.println("test car method getMaxSpeed(): " + maxSpeed);
		System.out.println("test car method getCarNumberOfCylinder(): " + cylinderSize);
		
		System.out.println("---------------------------------------------------------------------------------------------------------");

		
		String name2 = airplane.getName();
		int maxSpeed2 = airplane.getMaxSpeed();
		int engineSize = airplane.getAirplaneEngineNumber();
		System.out.println("test airplane method getName(): " + name2);
		System.out.println("test airplane method getMaxSpeed(): " + maxSpeed2);
		System.out.println("test airplane method getAirplaneEngineNumber(): " + engineSize);
		
		
		System.out.println("---------------------------------------------------------------------------------------------------------");
		System.out.println("Printing v1: " + v1.toString());
		//calls method of vehicle class because a car is derived of vehicle.
}
}


