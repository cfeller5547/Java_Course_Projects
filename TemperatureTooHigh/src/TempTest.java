
public class TempTest {

	public static void main(String[] args) {
		Fridge f = new Fridge();
		try {
			f.setFridge(35, "001", "chula vista");
			if(f.tempCheck() == true){
				System.out.println(f.getString() +  "\nSAFE: Temperature of " + f.getTemp() + " degrees F is within the safe operating range.\n");
				
			}
			f.setFridge(42, "002", "Lemon Grove");
			if(f.tempCheck() == true){
				System.out.println(f.getString() +  "\nSAFE: Temperature of " + f.getTemp() + " degrees F is within the safe operating range.\n");
		
			}
		}
		catch(TemperatureTooHigh e){
			System.out.println("TemperatureTooHigh: " + f.getString() + "\nALERT! Temperature has exceeded safe food storage temperature of 40 degrees F. Please correct immediately.");

		}
		
		
	}

}
