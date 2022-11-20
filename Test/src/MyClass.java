
public class MyClass {

	public static void main(String[] args) {
		
		int[][] aiNumbers = new int[10][10];
		int count = 0;
		
		for(int x = 0; x < aiNumbers.length; x++){

			   for(int y = 0; y < aiNumbers[x].length; y++){

				   count++;
			    System.out.println("num: " + aiNumbers[x][y]);
			    System.out.println(count);
			  }

			}

	}

}
