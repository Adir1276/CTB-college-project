import java.awt.*;

public class FallingObject {
    private int x, y;
    private final int SIZE = 40;
    private int FALL_SPEED;

    public FallingObject(int x, int y, int FALL_SPEED) {
        this.x = x;
        this.y = y;
        this.FALL_SPEED = FALL_SPEED;
    }

    public void fall() {
        y += FALL_SPEED;
    }

    public int getY() {
        return y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, SIZE, SIZE);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, SIZE, SIZE);
    }
}

