import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {

	public static void main(String[] args) {
		
		GameGrid g = new GameGrid();
		//g.run();

	}

	
	public void run() {
		
		SecureRandom oRand = new SecureRandom();
		
		int iWallChance = 10;
		int player_move_count = 0;
		
		int[][] gameGrid = new int[10][10];
		
		LinkedList l = new LinkedList();
		
		
		for(int y = 0; y < gameGrid[0].length;y++) {
			for(int x = 0; x<gameGrid.length; x++) {
				int iChance = oRand.nextInt(100);
				if(iChance < iWallChance) {
					gameGrid[x][y] = 1;
				}
				else {
					gameGrid[x][y] = 0;
				}
			}
		}
		printGrid (gameGrid);
		
		int iUserRow = 0;
		int iUserCol = 0;
		boolean stayInLoop = true;
		Scanner Keyboard = new Scanner(System.in);
		String user_input;
		gameGrid[0][0] = 0;
		
		
		while(stayInLoop == true) {
			
			System.out.print("move down or right?");
			
			user_input = Keyboard.nextLine();
			
			if( user_input.equalsIgnoreCase( "down" )) {
				iUserCol++;
				l.addHeadNode(iUserRow, iUserCol);
			}
			else if(user_input.equalsIgnoreCase("right")) {
				iUserRow++;
				l.addHeadNode(iUserRow, iUserCol);
			}
			
			printGrid (gameGrid);

			if(gameGrid[iUserRow][iUserCol] == 1) {
				System.out.println("user failed");
				System.out.print("--------------------");
				stayInLoop = false;
				
			}
			else if(iUserRow == 9 || iUserCol == 9) {
				System.out.println("you won you reached the end");
				System.out.print("--------------------");
				stayInLoop = false;
				
			}
			
			System.out.println();
			
		}
		while(!l.isEmpty()) { 
			
			Node node = l.removeHeadNode();
			gameGrid[node.xPosition][node.yPosition] = 5;
			player_move_count++;
		}
		System.out.println("Grid results below: ");
		System.out.println("------------------------");
		
		
		gameGrid[iUserRow][iUserCol] = -1;
		printGrid(gameGrid);
		System.out.println("player number of moves: " + player_move_count);
	}
	
	public void printGrid(int[][] gameGrid) {
		
		for(int y = 0; y < gameGrid[0].length;y++) {
			for(int x = 0; x<gameGrid.length; x++) {
			
				System.out.print(gameGrid[x][y] + " ");
			}
			System.out.println();
		}
	}
}
