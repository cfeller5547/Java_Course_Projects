import java.security.SecureRandom;
import java.util.Random;  
import java.util.Scanner;
public class RockPaperScissors {

   // Constants   
	public static SecureRandom ran = new SecureRandom();

   final static int VICTORY = 3;                                  // points required to result in the win
   final static String VALID = "RPSQ";                            // all of the VALID input choices for using in comparison & assignment operations
   final static String WIN_ROCK = "Rock crushes Scissors.";       // text of Rock's win conditions
   final static String WIN_PAPER = "Paper covers Rock.";          // text of Paper's win conditions
   final static String WIN_SCISSORS = "Scissors cuts Paper.";     // text of Scissors' win conditions
   
   // Prompt text to display to get input from user -- () choices correspond to VALID constant above
   final static String PROMPT = "Choose (R)ock, (P)aper, (S)cissors, or (Q)uit:";

   // Boolean Switches used with Loops 
   static boolean quit = false;            // boolean flag set when player chooses to quit the game
   static boolean inputOK = false;         // boolean flag to determine VALID input by the player

   // Other variables
   static char p, c;                       // the player's choice (p) and the computer's choice (c)
   static String pChoice, cChoice;         // the player's and computer's choices as text
   static int rand;                        // random value determined each round that will be the computer's choice as int from 0-2 corresponding to char positions in VALID
   static int pScore = 0;                  // counter of player wins
   static int cScore = 0;                  // counter of computer wins
   static int rounds = 0;                  // counter of rounds played
   static int ties = 0;                    // counter of number of tie rounds
   static byte roundWon;                   // 0 = tie, 1 = player, 2 = computer
   static String winString = "";           // holds information for the winning condition of that round.  

   public static void main(String[] args) {
      
      // Display Game Title and Welcome message
      System.out.println("Welcome to ROCK, PAPER, SCISSORS!\nThe first one of us to score " + VICTORY + " points will be the winner!");
      ran.
      while (!quit) { 

         // Begin the new Round
         rounds++;
         
         // Initialize the Random object
         Random r = new Random();
         r.setSeed(System.currentTimeMillis());  
      
         // Generate computer's selection for the round                     
         rand = r.nextInt(3);
         c = VALID.charAt(rand);
         
         // Display a header for the round  
         System.out.println("\nROUND " + rounds);
         
         // Get player input
         inputOK = false;
         while (!inputOK) { 
            System.out.println(PROMPT);
            Scanner key = new Scanner(System.in);
            String input = key.next().toUpperCase();
            p = input.charAt(0);
            int index = VALID.indexOf(p);
            if (index > -1) {
               inputOK = true;
            } else {
               System.out.println("\"" + input + "\" is not a VALID selection, please try again.");
            }
         }
         if (p == 'Q') {
            System.out.println("\nYou've chosen to quit. Sorry to see you go.\nHope to play with you another time.\n\n");
            quit = true;
         }
         
         pChoice = getString(p);
         cChoice = getString(c);

         if (p == c) {
            roundWon = 0;
            ties++;
         } else {
            winString = "";
            if ((p == 'R') && (c == 'P')) {
               roundWon = 2;
               cScore++;
               winString = WIN_PAPER;
            } else if ((p == 'R') && (c == 'S')) {
               roundWon = 1;
               pScore++;
               winString = WIN_ROCK;
            } else if ((p == 'P') && (c == 'R')) {
               roundWon = 1;
               pScore++;
               winString = WIN_PAPER;
            } else if ((p == 'P') && (c == 'S')) {
               roundWon = 2;
               cScore++;
               winString = WIN_SCISSORS;
            } else if ((p == 'S') && (c == 'R')) {
               roundWon = 2;
               cScore++;
               winString = WIN_ROCK;
            } else if ((p == 'S') && (c == 'P')) {
               roundWon = 1;
               pScore++;
               winString = WIN_SCISSORS;
            }
         }

         if (!quit) {
            displayResults();
         }
         
      }    
   }

	static String getString(char inChar) {
		String outString = "";
		switch(inChar)	{
		case 'R':
			outString =	"Rock";
			break;
		case 'P':
			outString =	"Paper";
			break;
		default:	//	also 'S'
			outString =	"Scissors";
		}
		return outString;
	}

	static void displayResults() {
   	if	(roundWon == 0) {
			System.out.println("We both picked " +	pChoice + " so this round is a tie.");				  
		} else {
			System.out.println("You picked "	+ pChoice +	" and I picked " + cChoice	+ ".");
			System.out.println(winString);
			String winner;
			if	(roundWon == 1) {
				winner =	"You";
			} else {
				winner =	"I";
			}
			System.out.println(winner + " won this round.");
		}
		System.out.println("You now have " + pScore + " points while I have " +	cScore +	" points and we've tied " + ties + " times.");
		if	((pScore	==	VICTORY)	||	(cScore == VICTORY))	{
			String game;
			if	(pScore > cScore)	{
				game = "\nAnd that means, you are the winner! Congratulations!";
			} else {
				game = "\nAnd that means, I am the winner. I hope you'll try again soon!";
			}
			System.out.println(game);
         quit = true;
		}							 
	}

}