import java.util.ArrayList;


public class GenericsTest {

	public static void main(String[] args) {
		//begin old way of handling objects
		Object o = new Object();
		
		
		ArrayList oNames = new ArrayList();
		oNames.add("John");
		oNames.add("sally");
		oNames.add(o);
		
		//had to use casting when pulling objects back out.
		String sName1 = (String)oNames.get(0);
		
		//end old way of handling objects
		
		
		//using generics
		
		ArrayList<String> lstNames = new ArrayList<>();
		lstNames.add("John");
		String sName = lstNames.get(0);
		
		Pair<String, Double> oStock1 = new Pair<>("msft", 54.5);
		Pair<String, Double> oStock2 = new Pair<>("apl", 186.0);
		System.out.println("stock 1: " + oStock1.getFirst());
		
		
		// store our pair stock objects in an arrayList.
		ArrayList<Pair<String, Double>> lstStocks = new ArrayList<>();
		lstStocks.add(oStock1);
		lstStocks.add(oStock2);
		
		for(int i = 0; i< lstStocks.size(); i++) {
			Pair<String, Double> oStock = lstStocks.get(i);
			System.out.println("Stock " + i + ": " + oStock.getFirst()+ " - " + oStock.getSecond());
			System.out.println("Add 2: " + (oStock.getSecond() + 2.0));
		}
	}

}
