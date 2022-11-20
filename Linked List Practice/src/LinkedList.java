
public class LinkedList {

	
	
	private AirportNode headNode;
	
	public void addNode(String sAirportID) {
		AirportNode oNode = new AirportNode();
		oNode.airportID = sAirportID;
		
		oNode.nextNode = headNode;
		
		headNode = oNode;
	}
	
	public AirportNode getHeadNode() {
		return headNode;
	}
}
