
import java.lang.Math;


public class MyClass {

	
	public double factorial(double num) {
		
		double factorial = 1;
		
		for(int i = 2; i <= num; i++) {
			factorial *= i;
		}
		return factorial;
	}
	
	public double calculateProb(int defectsNum) {
		
		
		
		
		double probPercent = 1;
		
		
		
		double e = 2.71828;
		
		double result = (Math.pow(e, -probPercent) * (Math.pow(probPercent, defectsNum)))/(factorial(defectsNum));
		
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		
		MyClass m = new MyClass();
		
		double atLeastThree;
		
		//prob that 0 are defective
		System.out.println(m.calculateProb(0));
		//prob that 1 is defective
		System.out.println(m.calculateProb(1));
		//prob that 2 is defective
		System.out.println(m.calculateProb(2));
		//prob that 3 is defective
		System.out.println(m.calculateProb(3));
		//prob that at least 3 is defective
		System.out.println(m.calculateProb(0)+m.calculateProb(1)+m.calculateProb(2)+m.calculateProb(3));
		
		
	
		
		
		
	}

	

	
}
