
public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList oLinkedList = new LinkedList();
		AirportNode oNode;
		
		String sAirportID = "";
		
		oLinkedList.addNode(sAirportID);
		oLinkedList.addNode(sAirportID);
		
		oNode = oLinkedList.getHeadNode();
		
		System.out.println("Head node: " + oNode.airportID);
		
	}
	
	
}
