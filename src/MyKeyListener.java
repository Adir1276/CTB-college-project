import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {
    private Character c;

    MyKeyListener(Character c){
        this.c = c;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            this.c.moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.c.moveRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            this.c.stopLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.c.stopRight();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
