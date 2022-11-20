import java.security.SecureRandom;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {

		BinarySearch oBinarySearch = new BinarySearch();
		
		oBinarySearch.runRecursiveTest();

		
		

	}
	
	private void runRecursiveTest() {
		
		SecureRandom oRand = new SecureRandom();
		int[] aiNumbers = new int[10];
		int iTargetNum;
		int iTargetNumIndex;
		int iIndexFound;
		
		//fill array w random numbers
		for(int i = 0; i < aiNumbers.length; i++) {
			aiNumbers[i] = oRand.nextInt(10000000);
			
		}
		
		
		//binary search requires ordered numbers
		
		Arrays.sort(aiNumbers);
		
		
		iTargetNumIndex = oRand.nextInt(aiNumbers.length);
		iTargetNum = aiNumbers[iTargetNumIndex];
		
		
		iIndexFound = findNumberBinarySearch(aiNumbers, iTargetNum, 0, aiNumbers.length-1);
		
		
		System.out.println("correct answer: " + iTargetNumIndex);
		System.out.println("Returned answer: " + iIndexFound);
	}
	
	
	private int findNumberBinarySearch(int[] aiNumbers, int iTarget, int iLowIndex, int iHighIndex) {
		
		//first get the middle index
		
		int iMiddleIndex = (iLowIndex + iHighIndex) / 2;
		
		//next check if target is at middle index
		
		if(aiNumbers[iMiddleIndex] == iTarget) {
			return iMiddleIndex;
		}
		
		//now check if target is lower than number at middle index
		
		else if(iTarget < aiNumbers[iMiddleIndex]) {
			return findNumberBinarySearch(aiNumbers, iTarget, iLowIndex, iMiddleIndex-1); 
			}
		
		//target is higher than number at middle index
		
		else {
			return findNumberBinarySearch(aiNumbers, iTarget, iMiddleIndex+1, iHighIndex); 
		}
	}

}
