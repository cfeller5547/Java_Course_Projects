import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Sets {

	  public static <T> Set<T> convertArrayToSet(T array[])
	    {
	  
	        Set<T> set = new HashSet<>();
	  
	       
	        for (T t : array) {
	            
	            set.add(t);
	        }
	  
	        
	        return set;
	    }
	
	public static void main(String[] args) {
		
		Scanner Keyboard = new Scanner(System.in);
		
		int set1_size;
		int set2_size;
		
		
		
		
		System.out.println("Enter the size of your first set: ");
		set1_size = Keyboard.nextInt();
		Integer set1[] = new Integer[set1_size];
		
		System.out.print("Enter your first set of numbers: ");
		
		
		for(int i = 0; i < set1_size; i++) {
			set1[i] = Keyboard.nextInt();
		}
		
		//converting array to set
		Set <Integer> Set = convertArrayToSet(set1);
		
		
		//printing set
		System.out.println("Set: " + Set);
			
		
		
		System.out.println("Enter the size of your second set: ");
		set2_size = Keyboard.nextInt();
		Integer set2[] = new Integer[set2_size];
		
		System.out.print("Enter your second set of numbers: ");
		
		for(int i = 0; i < set2_size; i++) {
			set2[i] = Keyboard.nextInt();
		}
		
		//convert set2
		Set <Integer> Set2 = convertArrayToSet(set2);
		
		//print set2
		
		System.out.println("Set 2: " + Set2);
		
		//cartesian
		System.out.println();
		cartesianProduct(set1, set2, set1_size, set2_size);
		System.out.println();
		
		
		//union
		System.out.println();
		Set<Integer> union = new HashSet<Integer>();
		union.addAll(Set);
		union.addAll(Set2);
		System.out.println("Union:" + union);  
		System.out.println();
		
		
		//intersection
	    Set<Integer> intersection = new HashSet<Integer>();
	    intersection.addAll(Set);
	    intersection.retainAll(Set2);
	    System.out.println("Intersection:" + intersection); 
	    System.out.println();
	    
	    
	    //difference
	    Set<Integer> difference = new HashSet<Integer>();
	    difference.addAll(Set);
	    difference.removeAll(Set2);
	    System.out.println("Difference:" + difference);
	    System.out.println();
	    
	    
	    //complements
	    
	    
	    //creating universal set
	    Set<Integer> set3 = new HashSet<Integer>();
	    
	    for(Integer i = 0; i <= 100; i++) {
			set3.add(i);
		}
	    
	    set3.addAll(Set);
	    set3.removeAll(Set);
	    System.out.println("Complement:" + set3);
	    
	    
	    //powerset
	    System.out.println();
	    Power(set1, set1_size);
	    
	}   
	    //powerset function
	    static void Power(Integer set[], int size1) {
	       int i = 0;
	 System.out.print("Power set of S is: [");
	    while(i < (1<<size1))
	    {
	    System.out.print("{ ");
	            int k = 1;
	            int j = 0;
	            while ( j < size1)
	            {
	                if ((i & k) > 0)
	                {      
	                    System.out.print(set[j] + " ");
	                }
	                k = k << 1;
	                j++;
	            }
	           
	            System.out.print("}, ");
	            i++;
	    }
	    System.out.print("]");
	}
	    
	    //cartesian function
	    static void cartesianProduct(Integer arr1[], Integer arr2[], int size1, int size2) {
		     System.out.print("Cartesian Product:");
		        for (int i = 0; i < size1; i++)
		          for (int j = 0; j < size2; j++)
		            System.out.print("{"+ arr1[i]+", "+ arr2[j]+"}, ");
		}
	    
	    
	
	
//	 static void cartesianProduct(Integer arr1[], Integer arr2[], int size1, int size2)
//	    { System.out.print("Cartesian Product:");
//	        for (int i = 0; i < size1; i++)
//	          for (int j = 0; j < size2; j++)
//	            System.out.print("{"+ arr1[i]+", "+ arr2[j]+"}, ");
//	    }
	 
//	 static void Union(int arr1[], int arr2[], int size1, int size2) {
//		 int f, i, j, k = 0;
//	        int arr3[] = new int[100];
//
//	        for (i = 0; i < size1; i++) {
//	            arr3[k] = arr1[i];
//	            k++;
//	        }
//
//	        for (i = 0; i < size2; i++) {
//	            f = 0;
//	            for (j = 0; j < size1; j++) {
//	                if (arr2[i] == arr1[j]) {
//	                    f = 1;
//	                }
//	            }
//
//	            if (f == 0) {
//	                arr3[k] = arr2[i];
//	                k++;
//	            }
//	        }
//
//	        System.out.print("\nUnion of Two sets is :");
//	        for (i = 0; i < k; i++) {
//	            System.out.print(" " + arr3[i]);
//	        }
//	 }
//	 
//	 static void Intersection(int arr1[], int arr2[], int size1, int size2) {
//		  int arr3[] = new int[100];
//	        int i, j, k = 0;
//
//	        for (i = 0; i < size1; i++) {
//	            for (j = 0; j < size2; j++) {
//	                if (arr1[i] == arr2[j]) {
//	                    arr3[k] = arr1[i];
//	                    k++;
//	                }
//	            }
//	        }
//
//	        System.out.print("\nIntersection of Two sets is :");
//	        for (i = 0; i < k; i++) {
//	            System.out.print(" " + arr3[i]);
//	        }
//	 }
//	 
//	 static void Difference(int arr1[], int arr2[], int size1, int size2) {
//		 
//	 }

	
	
}

