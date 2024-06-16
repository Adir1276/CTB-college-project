import java.awt.*;

public class Character {
    public static final int HEIGHT = 30;
    public static final int WIDTH = 100;
    private int x;
    private final int y = 500;
    private int speed = 15;
    private int dx;
    private int lives;

    public Character() {
        this.x = 400 - WIDTH/2;
        this.dx = 0;
        this.lives = 3;
    }

    public void paint (Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillRect(this.x, this.y, this.WIDTH, this.HEIGHT);
    }

    public void moveLeft() {
        if (this.dx >= 0) {
            this.dx -= speed;
        }
    }
    public void restart() {
        this.x = 400 - WIDTH/2;
        this.dx = 0;
        this.lives = 3;
    }
    public void moveRight() {
        if (this.dx <= 0) {
            this.dx += speed;
        }
    }

    public void stopLeft() {
            this.dx += speed;
    }

    public void stopRight() {
            this.dx -= speed;
    }

    public void updatePosition() {
        if (0 <= (this.x + this.dx) && (this.x + this.dx) <= (800 - this.WIDTH))
        this.x += dx;
    }

    public void loseLife(){
        this.lives-=1;
    }

    public int getLives(){
        return this.lives;
    }

    public boolean isAlive(){
        return this.lives > 0;
    }

    public Rectangle getBounds () {
        return new Rectangle(
                this.x,
                this.y,
                WIDTH,
                HEIGHT
        );
    }


}
