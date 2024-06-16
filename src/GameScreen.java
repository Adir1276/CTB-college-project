import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class GameScreen extends JPanel{
    private Character character;
    private int score;
    private final int MAX_LEVEL = 10;
    private int level = 1;
    private int TIME_UNTIL_NEXT_OBJECT;
    private ArrayList<FallingObject> objectList;
    private MyKeyListener myKeyListener;

    public GameScreen(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        startGame();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!character.isAlive()){
            g.drawString("Game Over!", 325, 100);
            g.drawString("Level: " + this.level, 325, 120);
            g.drawString("Final Score: " + this.score, 325, 140);
        }
        for (FallingObject fallingObject : this.objectList) {
            fallingObject.paint(g);
        }
        this.character.paint(g);
        g.drawString("Level: " + this.level, 10, 30);
        g.drawString("Score: " + this.score, 10, 50);
        g.drawString("Lives: " + this.character.getLives(), 10, 70);
    }

    public void collisionHandler(){
        Iterator<FallingObject> iterator = objectList.iterator();
        while (iterator.hasNext()) {
            FallingObject obj = iterator.next();
            obj.fall();
            if (obj.getY() > getHeight()) {
                iterator.remove();
                character.loseLife();
            } else if (obj.getBounds().intersects(character.getBounds())) {
                score++;
                iterator.remove();
            }
        }
    }

    public void startGame(){
        this.score = 0;
        this.level = 1;
        this.TIME_UNTIL_NEXT_OBJECT = 110;
        this.objectList = new ArrayList<>();
        if (this.character == null) {
            this.character = new Character();
            this.myKeyListener = new MyKeyListener(this.character);
        }
        else
            this.character.restart();
        this.mainGameLoop();
    }

    public void endGame(){
        JButton playButton = new JButton("Restart");
        playButton.setBounds(325, 300, 150, 40);
        playButton.addActionListener((event) -> {
           startGame();
           this.remove(playButton);
        });
        this.add(playButton);
        repaint();
    }

    public MyKeyListener getMyKeyListener(){
        return myKeyListener;
    }

    public void mainGameLoop () {
        new Thread(() -> {
            while (true) {
                try {
                    TIME_UNTIL_NEXT_OBJECT-=1;
                    if (TIME_UNTIL_NEXT_OBJECT == 0) {
                        Random rand = new Random();
                        this.objectList.add(new FallingObject(rand.nextInt(getWidth() - 40), 0, this.level));
                        TIME_UNTIL_NEXT_OBJECT = 120 - (this.level)*10;
                    }
                    collisionHandler();
                    character.updatePosition();
                    if (this.level < MAX_LEVEL) //
                        this.level = (20 + this.score)/20;
                    if (!this.character.isAlive()) {
                        endGame();
                        return;
                    }
                    repaint();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

}
