public class MerkleManager {

    // *** this is the user's entered word ***
    public static volatile String userInputW;

    // *** this is the user's expected merkle root ***
    public static String userExpectedMR = null;

    // *** this is the merkle root ***
    public static String merkleRoot = null;

    // *** this is the number of strikes ***
    public static int numStrikes = 0;

    public void manage() {
        Util oUtil = new Util();

        userExpectedMR = oUtil.promptUser("Enter Expected Merkle Root:");

        MerkleThread merkleThread = new MerkleThread();
        RogueThread rogueThread = new RogueThread();
        MonitorThread monitorThread = new MonitorThread();

        Thread merkle = new Thread(merkleThread);
        Thread rogue = new Thread(rogueThread);
        Thread monitor = new Thread(monitorThread);

        merkle.start();
        rogue.start();
        monitor.start();

        while (true) {
            userInputW = oUtil.promptUser("Enter a word:");
        }
    }

    public static synchronized String grabWord() {
        String tempVar = userInputW;
        userInputW = null;
        return tempVar;

    }
}
