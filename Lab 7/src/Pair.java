import java.util.ArrayList;

public class Pair<A, B> {

	A first;
	B second;
	
	
	public Pair(A a, B b) {
		first = a;
		second = b;
	}
	
	public A getFirst() {
		return first;
	}
	
	public B getSecond() {
		return second;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Double winPercentage;
		
		Triple<String, Integer, Integer> t1 = new Triple<>("Team one", 5, 10);
		Triple<String, Integer, Integer> t2 = new Triple<>("Team two", 10, 5);
		Triple<String, Integer, Integer> t3 = new Triple<>("Team three", 15, 0);
		Triple<String, Integer, Integer> t4 = new Triple<>("Team four", 6, 9);
		Triple<String, Integer, Integer> t5 = new Triple<>("Team five", 8, 7);
		
		//array for triple
		Triple<String, Integer ,Integer>[] arrTriple;
		arrTriple = new Triple[5];
		
		//array for pair
		Pair<String, Double>[] arrPair;
		arrPair = new Pair[5];
		
		//store the objects of triple in an array list
		ArrayList<Triple<String, Integer, Integer>> t = new ArrayList<>();
		t.add(t1);
		t.add(t2);
		t.add(t3);
		t.add(t4);
		t.add(t5);
		
		
		
		for(int i = 0; i < arrTriple.length; i++) {
			Triple<String, Integer, Integer> oTriple = t.get(i);
			winPercentage =  ((double) oTriple.getSecond() / ((double) oTriple.getSecond() + (double) oTriple.getThird()) * 100);
			Pair<String, Double> oPair = new Pair<>(oTriple.getFirst(), winPercentage);
			arrPair[i] = oPair;
		}
		
		
		//create max 
		Pair<String, Double> largestNum = new Pair<>("blank", 0.0);
		
		
		//print results
		for(int i = 0; i <arrPair.length; i++) {
			System.out.println("Team Name: " + arrPair[i].getFirst() + "\t" + "Win Percentage:" + arrPair[i].getSecond() + "%");
			if(arrPair[i].getSecond() > largestNum.getSecond()) {
				largestNum = arrPair[i];
			}
		}
		System.out.println("The highest win percentage is: " + largestNum.getSecond());
	}

}
