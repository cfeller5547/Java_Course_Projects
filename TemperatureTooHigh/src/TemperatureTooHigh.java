

public class TemperatureTooHigh extends Exception {

	public TemperatureTooHigh(){
		
	}
	
	public TemperatureTooHigh(String message){
		message = "\nALERT! Temperature has exceeded safe food storage temperature of 40 degrees F. Please correct immediately.\n";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
