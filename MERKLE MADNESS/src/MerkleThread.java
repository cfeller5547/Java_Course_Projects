import java.util.ArrayList;

public class MerkleThread implements Runnable{

public static volatile ArrayList<String> wordList;
private int iMerkleTreeInputs = 4;
private String threadName = "Merkle Thread";

    public void run() {
        //INSTANTIATE
        Util util1 = new Util();
        wordList = new ArrayList();

        //WHILE LOOP
        while (true){
            util1.sleepRandomTime(threadName);
            String grabWord1 = MerkleManager.grabWord();

            //CHECK WORD
            if (grabWord1 != null){
                System.out.println("Merkle Grabbed the Word");
                wordList.add(grabWord1);

                if (wordList.size() == iMerkleTreeInputs) {
                     MerkleManager.merkleRoot = util1.getMerkleRoot(wordList);
                }
            }
        }
    }
}
