
public class MonitorThread implements Runnable {

	@Override
	public void run() {
		Util Obj = new Util();
		while(true) {
			if(MerkleManager.merkleRoot!= null) {
				if(MerkleManager.merkleRoot.compareTo(MerkleManager.userExpectedMR)==0) {
					System.out.println("You win! " + MerkleManager.merkleRoot);
					 System.exit(0);
				}
			else {
				System.out.println("Merkle roots not equal, you lost.");
				 System.exit(0);
			}
			}
			else if( MerkleManager.numStrikes == 3) {
				System.out.println("Three strikes, you lost.");
				System.exit(0);
			}
			Obj.sleep(1);
		}
		
		
	}

}
