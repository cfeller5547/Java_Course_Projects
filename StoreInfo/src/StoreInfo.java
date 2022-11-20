
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class StoreInfo {
	
	public static String partNum, partName, manName, binNum;
	
	public static void main(String[] args) {
		try {
			File f = new File("Inventory.txt");
			if(f.createNewFile()) {
				System.out.println("File created: " + f.getName());
			}
			else {
				System.out.println("File already exists.");
			}
		}
		catch(IOException e) {
			System.out.println("An error occured.");
			e.printStackTrace();
		}
		writeToFile();
	}
	
	public static void writeToFile() {
		
		
		
		try {
			FileWriter writer = new FileWriter("Inventory.txt", true);
			
			Scanner Keyboard = new Scanner(System.in);
			
			
			System.out.println("Enter the part number");
			partNum = Keyboard.nextLine();
			System.out.println("Enter the part name");
			partName= Keyboard.nextLine();
			System.out.println("Enter the manufacturer's name");
			manName = Keyboard.nextLine();
			System.out.println("Enter the bin number");
			binNum = Keyboard.nextLine();
			
			writer.write("\n" + "Part Number: ");
			writer.write(partNum + "\n");
			writer.write("Part Name: ");
			writer.write(partName + "\n");
			writer.write("Manufacturer's name: ");
			writer.write(manName + "\n");
			writer.write("bin number: ");
			writer.write(binNum);

			writer.close();
			System.out.println("Succesfully wrote to file");
		}
		catch(IOException e){
			System.out.println("an error occured");
			e.printStackTrace();
		}
	}
	
	
}
