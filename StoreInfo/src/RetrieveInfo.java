import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RetrieveInfo {
	
	public static void main(String[] args)throws IOException 
		
	   {
		
	    String word = ""; int val = 0;
	    while(!word.matches("quit"))
	    {
	        System.out.println("Enter the part number to be searched for");
	        Scanner input = new Scanner(System.in);
	        word = input.next();
	        Scanner file = new Scanner(new File("Inventory.txt"));
	  
	    
	        while(file.hasNextLine())           
	        {
	            String line = file.nextLine();
	            if(line.indexOf(word) != -1)
	            {
	                System.out.println("Word EXISTS in the file");
	                val = 1;
	                System.out.println(file.nextLine());
	                System.out.println(file.nextLine());
	                System.out.println(file.nextLine());
	              
	                break;
	            }
	            else
	            {
	                val = 0;
	                continue;
	            }
	        }
	        if(val == 0)
	        {
	            System.out.println("part number does not exist");
	        }
	        System.out.println("-------continue or quit--- enter continue or quit");
	        word = input.next();        
	    }   
	      } 
}
	      
	



//public static void main(String[] args) {
//	try {
//		File f = new File("Inventory.txt");
//		Scanner reader = new Scanner(f);
//		while(reader.hasNextLine()) {
//			String data = reader.nextLine();
//			System.out.println(data);
//			
//		}
//		reader.close();
//	}
//	catch(FileNotFoundException e){
//		System.out.println("An error occurred.");
//		e.printStackTrace();
//	}
//}