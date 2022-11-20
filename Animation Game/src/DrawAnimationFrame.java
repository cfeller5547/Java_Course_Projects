import javax.swing.*;
import java.awt.*;

public class DrawAnimationFrame extends JFrame {

    public DrawAnimationFrame() {

        initUI();
    }

    private void initUI() {

        add(new DrawAnimationPanel());

        setResizable(false);
        pack();

        setTitle("Draw");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new DrawAnimationFrame();
            ex.setVisible(true);
        });
    }
}
