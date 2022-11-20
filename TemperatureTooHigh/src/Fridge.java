
public class Fridge {

	int temperature;
	String id;
	String location;
	
	public Fridge() {
	}
	
	public void setFridge(int initTemp, String initID, String initLocation) {
		temperature = initTemp;
		id = initID;
		location = initLocation;
	}
	
	public int getTemp() {
		return temperature;
	}
	
	public String getString() {
		return "Fridge " + id + " located at " + location + " is now showing " + temperature + " degrees F.";
	}
	
	public boolean tempCheck() throws TemperatureTooHigh {
		
	
		if(temperature > 40) {
			throw new TemperatureTooHigh(getString());
		}
		return true;
	}
	
		
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
