
public class RogueThread implements Runnable {
	private String threadName = "Rogue Thread";

	@Override
	public void run() {
		Util Obj = new Util();
		
		while(true) {
			Obj.sleepRandomTime(threadName);
			 String sNewWord = MerkleManager.grabWord(); //explain line please
			 if(sNewWord!= null) {
				 MerkleManager.numStrikes++;
				 System.out.println("Rogue grabbed a word, STRIKE!");
			 }
			
		}
		
	}

}

