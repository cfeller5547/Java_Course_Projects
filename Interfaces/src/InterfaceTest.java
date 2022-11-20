import java.util.ArrayList;

public class InterfaceTest {

	public static void main(String[] args) {
		
		Car oCar1 = new Car();
		//or...
		MotorVehicle oCar2 = new Car();
		//but...
		//oCar1 can call methods on Car, but oCar2 can't....see below
		
		boolean b4Door;
		b4Door = oCar1.is4Door(); //works because oCar is declared as Car type.
	//	b4Door = oCar2.is4Door(); // doesnt work because oCar2 is declared as MotorVehicle type.

		
		//but.... we can cast oCar2 into a Car type specifically....
		
		if(oCar2 instanceof Car) {
			Car oCar = (Car)oCar2;
			b4Door = oCar.is4Door();
			System.out.println("this car is a 4 door" + b4Door);
		}
		
		Motorcycle oMoto = new Motorcycle();
		
		ArrayList<MotorVehicle> lstVehicles = new ArrayList<>();
		
		lstVehicles.add(oCar1);
		lstVehicles.add(oCar2);
		lstVehicles.add(oMoto);
		
		for(MotorVehicle oVehicle: lstVehicles) {
			boolean bStarted = oVehicle.start(); //why assigning a variable to the func??
			System.out.println("vehicle started: " + bStarted);
			
			if(oVehicle instanceof Car) {
				System.out.println("car found");
			}
		}
	}

}
