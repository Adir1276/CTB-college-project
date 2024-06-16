import javax.swing.*;
import java.awt.*;

public class MenuScreen extends JPanel {
    public MenuScreen(int x, int y, int width, int height) {
        setLayout(null);
        setBounds(x, y, width, height);
        this.setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Your goal is to catch every falling object", 300, 100);
        g.drawString("The objects will fall faster over time", 300, 125);
        g.drawString("Fail to catch 3 objects and you lose!", 300, 150);
        g.drawString("Controls: Arrow keys to move left and right", 300, 175);
    }
}
