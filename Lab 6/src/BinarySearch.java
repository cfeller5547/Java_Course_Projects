import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch oBinarySearch = new BinarySearch();
		
		oBinarySearch.runRecursiveTest();


	}

	
	private void runRecursiveTest() {
		
		SecureRandom oRand = new SecureRandom();
		
		
		String[] aiNumbers = new String[10];
		aiNumbers[0] = "Chris";
		aiNumbers[1] = "joe";
		aiNumbers[2] = "bob";
		aiNumbers[3] = "tom";
		aiNumbers[4] = "jake";
		aiNumbers[5] = "greg";
		aiNumbers[6] = "mike";
		aiNumbers[7] = "tim";
		aiNumbers[8] = "dan";
		aiNumbers[9] = "zack";
		String sTargetNum;
		int sTargetNumIndex;
		int sIndexFound;
		
		
		
		
	
		
		Arrays.sort(aiNumbers);
		
		sTargetNumIndex = oRand.nextInt(aiNumbers.length);
		sTargetNum = aiNumbers[sTargetNumIndex];
		
		
		sIndexFound = findNumberBinarySearch(aiNumbers, sTargetNum, 0, aiNumbers.length-1);
		
		
		System.out.println("correct answer: " + sTargetNumIndex);
		System.out.println("Correct string: " +  aiNumbers[sTargetNumIndex]);
		System.out.println("Returned answer: " + sIndexFound);
		System.out.println("Returned string: " + aiNumbers[sIndexFound]);

	}
	
private int findNumberBinarySearch(String[] aiNumbers, String sTarget, int sLowIndex, int sHighIndex) {
		
		//first get the middle index
		
		int sMiddleIndex = (sLowIndex + sHighIndex) / 2;
		
		//next check if target is at middle index
		
		if(aiNumbers[sMiddleIndex].equals(sTarget) ) {
			return sMiddleIndex;
		}
		
		//now check if target is lower than number at middle index
		
		else if(sTarget.compareTo(aiNumbers[sMiddleIndex]) < 0) {
			return findNumberBinarySearch(aiNumbers, sTarget, sLowIndex, sMiddleIndex-1); 
			}
		
		//target is higher than number at middle index
		
		else {
			return findNumberBinarySearch(aiNumbers, sTarget, sMiddleIndex+1, sHighIndex); 
		}
	}

}


