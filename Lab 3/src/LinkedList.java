
public class LinkedList {

	private Node headNode;
	
	public void addHeadNode(int x, int y) {
		Node node = new Node();
		node.xPosition = x;
		node.yPosition = y;
		node.nextNode = headNode;
		headNode = node;
		
		return;
	}
	
	boolean isEmpty() {
		return headNode == null;
	}
	
	public Node removeHeadNode() {
		Node temp = headNode;
		headNode = headNode.nextNode;
		return temp;
	}

	public Node getHeadNode() {
		return headNode;
	}
}


