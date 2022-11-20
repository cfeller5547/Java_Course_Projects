import java.util.ArrayList;
import java.util.List;


public class MyClass {

	int graph[][] = new int[][] {{ 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }};
	
	public ArrayList<Integer>[] aList;
      
	public int v;
	
	boolean hasCycle;
	
	public MyClass(int vertices){
		this.v = vertices;
		
		createAdjList();
		
	}
	
	
	public void createAdjList() {
		
		aList = new ArrayList[v];
		
		//filling up list to size of the number of vertices
		for(int i = 0; i < v; i++) {
			aList[i] = new ArrayList<>();
		}
	}
	
	public void getAllPaths(int source, int destination, boolean visited[], List<Integer> path) {
		
		visited[source] = true;
		
		if(source == destination) {
			//match found so done
			System.out.println(path);
			visited[source] = false;
			return;
		}
		
		for(Integer i : aList[source]) {
			if(!visited[i]) {
				path.add(i);
				getAllPaths(i, destination, visited, path);
				
				path.remove(i);
			}
		}
		
		visited[source] = false;
		
	}
	
	public void displayPaths(int source, int destination) {
		
		boolean[] visited = new boolean[v];
		ArrayList<Integer> path = new ArrayList<>();
		
		path.add(source);
		
		getAllPaths(source, destination, visited, path);
	}
	
public void getAllOpenWalks(int source, int destination, boolean visited[], List<Integer> path) {
		
		visited[source] = true;
		
		if(source == destination) {
			//match found so done
			System.out.println(path);
			visited[source] = false;
			return;
		}
		
		for(Integer i : aList[source]) {
			if(!visited[i]) {
				path.add(i);
				getAllPaths(i, destination, visited, path);
				
				
			}
		}
		
		visited[source] = false;
		
	}
	
	public void displayOpenWalks(int source, int destination) {
		
		boolean[] visited = new boolean[v];
		ArrayList<Integer> path = new ArrayList<>();
		
		path.add(source);
		
		getAllOpenWalks(source, destination, visited, path);
	}
	
	 public void closedWalks(int graph[][]) {
		  hasCycle = false;
		  
		  ArrayList<Integer> path= new ArrayList<>();
		  path.add(0);
		  
		  boolean[] visited = new boolean[graph.length];
		  
		  for(int i = 0; i < visited.length; i++)
		     visited[i] = false;
		  
		  visited[0] = true;
		  
		  FindHamiltonianCycle(graph, 1, path, visited);

		  if (!hasCycle) {
			  System.out.println("No Hamiltonian Cycle");
			  return;
		  }
	  }

	  public void FindAllClosedWalks(int graph[][], int k, ArrayList<Integer> path, boolean[] visited) {
		  if(k == graph.length) {
			  if (graph[path.get(path.size() - 1)][path.get(0)]!= 0) {
				  path.add(0);
				  for (int i = 0; i < path.size(); i++) {
		                    System.out.print(path.get(i) + " ");
		          }
		                System.out.println();
		                path.remove(path.size() - 1);
		                hasCycle = true;
			  }
			  return;
		  }
		  
		  for (int v = 0; v < graph.length; v++) {
			  if (isValidForCircuit(v, k, path, graph) && !visited[v]) {
				  path.add(v);
	              visited[v] = true;
	              
	              FindHamiltonianCycle(graph, k + 1, path, visited);
	              
	              visited[v] = false;
	              path.remove(path.size() - 1);
			  }
		  }
	  }
	
	  public void addEdges(int source, int destination)
	    {
	        
	        aList[source].add(destination);
	    }
	  
	  public boolean isValidForCycle(int v, int k, List<Integer> path, int[][] graph ) {
		  if(graph [path.get(k-1)][v] == 0) {
			  return false;
		  }
		  
		  else {
		  for (int i = 0; i < k; i++)   
		      if (path.get(i) == v)
		         return false;
		   return true;
		  }
	  }
	  
	  public boolean isValidForCircuit(int v, int k, List<Integer> path, int[][] graph ) {
		  if(graph [path.get(k-1)][v] == 0) {
			  return false;
		  }
		  
		  else {
		 
		   return true;
		  }
	  }
	  
	  public void hamiltonianCycle(int graph[][]) {
		  hasCycle = false;
		  
		  ArrayList<Integer> path= new ArrayList<>();
		  path.add(0);
		  
		  boolean[] visited = new boolean[graph.length];
		  
		  for(int i = 0; i < visited.length; i++)
		     visited[i] = false;
		  
		  visited[0] = true;
		  
		  FindHamiltonianCycle(graph, 1, path, visited);

		  if (!hasCycle) {
			  System.out.println("No Hamiltonian Cycle");
			  return;
		  }
	  }

	  public void FindHamiltonianCycle(int graph[][], int k, ArrayList<Integer> path, boolean[] visited) {
		  if(k == graph.length) {
			  if (graph[path.get(path.size() - 1)][path.get(0)]!= 0) {
				  path.add(0);
				  for (int i = 0; i < path.size(); i++) {
		                    System.out.print(path.get(i) + " ");
		          }
		                System.out.println();
		                path.remove(path.size() - 1);
		                hasCycle = true;
			  }
			  return;
		  }
		  
		  for (int v = 0; v < graph.length; v++) {
			  if (isValidForCycle(v, k, path, graph) && !visited[v]) {
				  path.add(v);
	              visited[v] = true;
	              
	              FindHamiltonianCycle(graph, k + 1, path, visited);
	              
	              visited[v] = false;
	              path.remove(path.size() - 1);
			  }
		  }
	  }
	  
	  public void hamiltonianCircuit(int graph[][]) {
		  hasCycle = false;
		  
		  ArrayList<Integer> path= new ArrayList<>();
		  path.add(0);
		  
		  boolean[] visited = new boolean[graph.length];
		  
		  for(int i = 0; i < visited.length; i++)
		     visited[i] = false;
		  
		  visited[0] = true;
		  
		  FindHamiltonianCycle(graph, 1, path, visited);

		  if (!hasCycle) {
			  System.out.println("No Hamiltonian Cycle");
			  return;
		  }
	  }

	  public void FindHamiltonianCircuit(int graph[][], int k, ArrayList<Integer> path, boolean[] visited) {
		  if(k == graph.length) {
			  if (graph[path.get(path.size() - 1)][path.get(0)]!= 0) {
				  path.add(0);
				  for (int i = 0; i < path.size(); i++) {
		                    System.out.print(path.get(i) + " ");
		          }
		                System.out.println();
		                path.remove(path.size() - 1);
		                hasCycle = true;
			  }
			  return;
		  }
		  
		  for (int v = 0; v < graph.length; v++) {
			  if (isValidForCircuit(v, k, path, graph) && !visited[v]) {
				  path.add(v);
	              visited[v] = true;
	              
	              FindHamiltonianCycle(graph, k + 1, path, visited);
	              
	              visited[v] = false;
	              path.remove(path.size() - 1);
			  }
		  }
	  }
	  
	 
	public static void main(String[] args) {
	
	MyClass graph = new MyClass(4);	
	
	int graphMatrix[][] = new int[][] {{ 1, 2, 2, 1 }, { 2, 1, 2, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 0 }};

	
	for(int i=0;i<4;i++)
	{
		for(int j=0; j<4; j++)
		{
			if(graphMatrix[i][j]>0)
			{
				graph.addEdges(i,j);
			}
		}
	}
	
	
	
	
	//all paths output
	System.out.println("------------all paths-------------");
	graph.displayPaths(1, 3);
	
	
	//all open walks output
	System.out.println("------------all open walks-------------");
	graph.displayOpenWalks(1, 2);	
	
	

	//all closed walks output
	System.out.println("------------all closed walks-------------");
	graph.closedWalks(graphMatrix);
	
	

	//all trails output
	System.out.println("------------all trails-------------");
	graph.displayPaths(1,3);
	
	
	//all cycle output
	System.out.println("------------all cycle-------------");
	graph.hamiltonianCycle(graphMatrix);
	
	//all circuit output
	System.out.println("------------all circuit-------------");
	graph.hamiltonianCycle(graphMatrix);
	}
	

	
	

}
