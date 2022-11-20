import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.*;

public class DrawAnimationPanel extends JPanel
        implements Runnable {

    // Board size.
    private final int WIDTH = 1200;
    private final int HEIGHT = 800;

    // Time between repainting (smoothness of animation)
    private final int DELAY = 20; // milliseconds (20 best)

    // How long to go.
    private int iTimeCycles = 0;
    private int iTimeCyclesCap = 3000;
    private boolean bStop = false;
    private final boolean STOP_ON_PLAYER_COLLISION_ONLY = true;

    // Nodes
    ArrayList<Node> lstNodes = new ArrayList<>();
    Node oPlayerNode;
    Node oHomeNode;
    private int NODE_COUNT = 125;
    private int NODE_WIDTH = 10;
    private int NODE_HEIGHT = 10;

    // Likelihood of keeping same direction.
    private final int MOVE_SAME_DIRECTION_CHANCE = 98;


    private SecureRandom g_oRand;
    private long g_lSeed = 0;
    private long g_lInitialSeed;

    private Thread animator;
    private int x = 50;
    private int y = 50;


    public DrawAnimationPanel() {

        initBoard();

        // BEGIN Random num generator and seed
        g_oRand = new SecureRandom();
        if(g_lSeed == 0) g_lSeed = System.currentTimeMillis();
        else g_lSeed++;
        g_oRand.setSeed(g_lSeed);
        g_lInitialSeed = g_lSeed;
        // END Random num
    }

    private void loadImage() {

        //ImageIcon ii = new ImageIcon("D:/...");
        //image = ii.getImage();
    }




    private void initBoard() {

        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }




    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }


    public void setInputBindings() {
        InputMap im = this.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = this.getActionMap();

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");

        am.put("RightArrow", new ArrowAction("RightArrow"));
        am.put("LeftArrow", new ArrowAction("LeftArrow"));
        am.put("UpArrow", new ArrowAction("UpArrow"));
        am.put("DownArrow", new ArrowAction("DownArrow"));
    }


    public class ArrowAction extends AbstractAction {

        private String cmd;

        public ArrowAction(String cmd) {
            this.cmd = cmd;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cmd.equalsIgnoreCase("LeftArrow")) {
                System.out.println("left");
                oPlayerNode.lastMoveX = -1;
                oPlayerNode.lastMoveY = 0;
            } else if (cmd.equalsIgnoreCase("RightArrow")) {
                System.out.println("right");
                oPlayerNode.lastMoveX = 1;
                oPlayerNode.lastMoveY = 0;
            } else if (cmd.equalsIgnoreCase("UpArrow")) {
                System.out.println("up");
                oPlayerNode.lastMoveX = 0;
                oPlayerNode.lastMoveY = -1;
            } else if (cmd.equalsIgnoreCase("DownArrow")) {
                System.out.println("down");
                oPlayerNode.lastMoveX = 0;
                oPlayerNode.lastMoveY = 1;
            }
        }
    }





    // ************************************************************************
    // ************************************************************************
    // **************** Edit below here to alter game *************************



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Render home.
        g.setColor(Color.green);
        g.drawOval(oHomeNode.x, oHomeNode.y, NODE_WIDTH *2, NODE_HEIGHT*2);

        // Move player first.
        oPlayerNode.x += oPlayerNode.lastMoveX;
        oPlayerNode.y += oPlayerNode.lastMoveY;
        g.setColor(Color.yellow);
        g.drawOval(oPlayerNode.x, oPlayerNode.y, NODE_WIDTH, NODE_HEIGHT);

        g.setColor(Color.white);

        // Check if reached home.
        if(checkCollision(oPlayerNode.x, oPlayerNode.y, oHomeNode.x, oHomeNode.y, NODE_WIDTH/2, NODE_WIDTH)){
            bStop = true;
            System.out.println("HOME WAS REACHED BY PLAYER! (cycle " + iTimeCycles + ")");
            g.setColor(Color.green);
        }

        for(Node oNode: lstNodes){

			// First decide if node should change X direction.
			// Then move X.
            // ##### ADD CODE HERE #####
        	
        	if(g_oRand.nextInt(100) > MOVE_SAME_DIRECTION_CHANCE)){
        		oNode.lastMoveX = oNode.lastMoveX * -1;
        	}
        	
        	oNode.x += oNode.lastMoveX;

			// First decide if node should change Y direction.
			// Then move Y.
            // ##### ADD CODE HERE #####
        	
         	if(g_oRand.nextInt(100) > MOVE_SAME_DIRECTION_CHANCE)){
        		oNode.lastMoveY = oNode.lastMoveY * -1;
        	}
        	
        	oNode.y += oNode.lastMoveY;

            // Check for player collision with node.
            // if STOP_ON_PLAYER_COLLISION_ONLY then set bStop to true and color everything red.
            // ##### ADD CODE HERE #####

        	if(checkCollision(oNode.x,oNode.y,oPlayerNode.x,oPlayerNode.y, NODE_WIDTH/2, NODE_WIDTH/2)) {
        		
        		if(STOP_ON_PLAYER_COLLISION_ONLY) {
        			bStop = true;
        			
        		}
        		
        		
        		
        	}

            // Check for any collision (not currently used).
            if(!STOP_ON_PLAYER_COLLISION_ONLY) {
                for (Node oOtherNode : lstNodes) {
                    if (!oNode.name.equals(oOtherNode.name) && checkCollision(oNode.x, oNode.y, oOtherNode.x, oOtherNode.y,
                            NODE_WIDTH / 2, NODE_WIDTH / 2)) {
                        iTimeCycles = iTimeCyclesCap;

                        g.setColor(Color.red);

                        //g.drawString(oNode.name + " collided with " + oOtherNode.name + "!",1000,1000);
                        System.out.println(oNode.name + " collided with " + oOtherNode.name + "!");

                        bStop = true;
                    }
                }
            }

            // Draw npc nodes.
            g.drawOval(oNode.x, oNode.y, NODE_WIDTH, NODE_HEIGHT);
        }

        Toolkit.getDefaultToolkit().sync();
    }




    private boolean checkCollision(int x1, int y1, int x2,
                      int y2, int r1, int r2)
    {
        int distSq = (x1 - x2) * (x1 - x2) +
                (y1 - y2) * (y1 - y2);
        int radSumSq = (r1 + r2) * (r1 + r2);
        if (distSq == radSumSq) return true;
        else if (distSq > radSumSq) return false;
        else return true;
    }





    @Override
    public void run() {

        setInputBindings();

        // Set up player node.
        oPlayerNode = new Node();
        oPlayerNode.name = "Player";

        // Only spawn in top 100 or left 100 spots.
        
        while(!(oPlayerNode.x > 0 && oPlayerNode.x < 100) && !(oPlayerNode.y > 0 && oPlayerNode.y < 100))  {
            oPlayerNode.x = g_oRand.nextInt(WIDTH);
            oPlayerNode.y = g_oRand.nextInt(HEIGHT);
            oPlayerNode.lastMoveX = 0;
            oPlayerNode.lastMoveY = 0;
        }
        System.out.println("Player position: " + oPlayerNode.x + "," + oPlayerNode.y);
        

        // Set up home node.
        oHomeNode = new Node();
        oHomeNode.name = "Home";
        oHomeNode.x = WIDTH/2;
        oHomeNode.y = HEIGHT/2;

        // Set up initial nodes and place them randomly.
        while(NODE_COUNT > 0){
            Node oNode = new Node();
            oNode.x = g_oRand.nextInt(WIDTH - 100) + 100;
            oNode.y = g_oRand.nextInt(HEIGHT - 100) + 100;
            oNode.lastMoveX = 1;
            oNode.lastMoveY = 1;
            oNode.name = "Node " + NODE_COUNT;
            lstNodes.add(oNode);
            NODE_COUNT--;
        }

        while (iTimeCycles < iTimeCyclesCap) {

            if(bStop) break;

            iTimeCycles++;

            repaint();

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }
}

