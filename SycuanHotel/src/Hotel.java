
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Scanner;

public class Hotel {
	
	LinkedList<Person> ll = new LinkedList<Person>();
	
	public static void main(String[] args) {
		
		FMain db = new FMain();
		
		
		Hotel h = new Hotel();
		
		
		Scanner Keyboard = new Scanner(System.in);
		
		String firstName;
		
		String lastName;
		
		String status;
		
		String check_in_date;
		
		String email;
		
		
		while(true) {
		
		System.out.println("---------menu--------");
		System.out.println("1. Add a guest");
		System.out.println("2. See guest list");
		System.out.println("3. Search for a guest");
		System.out.println("4. quit");
		
		
		String input2 = Keyboard.nextLine();
		
		switch(input2) {
		
		case "1":
			
			Person p = new Person();
			
			System.out.println("Enter Guest first name: ");
			
			firstName = Keyboard.nextLine();
		
			p.setFirstName(firstName);
			
			System.out.println("Enter Guest last name: ");
			
			lastName =  Keyboard.nextLine();
			
			p.setLastName(lastName);
			
			System.out.println("Enter Guest status: ");
			
			status =  Keyboard.nextLine();
			
			p.setStatus(status);
			
			System.out.println("Enter Guest check in date: ");
			
			check_in_date =  Keyboard.nextLine();
			
			p.setCheckInDate(check_in_date);
			
			System.out.println("Enter Guest email: ");
			
			email =  Keyboard.nextLine();
			
			p.setEmail(email);
			
			h.addGuest(p);
			
			try {
				db.SaveToDatabase(p);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			break;
		
		case "2":
			
			h.printGuestList();	
			System.out.println();
			System.out.println();
			System.out.println();
			break;
			
		case "3":
			
			//work here
			break;
		
		case "4":
			System.exit(0);
			
		}
		}
	}
	
	public void addGuest(Person p) {
		
		ll.add(p);
			
	}
	
	public void printGuestList() {
		for(int i = 0; i < ll.size(); i++) {
			Person p = ll.get(i);
			p.print();
		}
	}
	
public void searchByName(String S) {
		
		for(int i = 0; i < ll.size(); i++) {
			if(ll.contains(S)) {
				System.out.print("The name " + S + " was found");
			}
			else {
				System.out.print("Word not found");
			}
		}
	}

	

	
	
	
}
		
	
	
	


