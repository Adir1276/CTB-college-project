import javax.swing.*;

public class MenuWindow extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public MenuWindow () {
        MenuScreen menuScreen = new MenuScreen(0, 0, WIDTH, HEIGHT);
        JButton playButton = new JButton("Play");
        playButton.setBounds(325, 300, 150, 40);
        playButton.addActionListener((event) -> {
            GameScreen gameScreen = new GameScreen(0, 0, WIDTH, HEIGHT);
            menuScreen.setVisible(false);
            this.add(gameScreen);
            this.addKeyListener(gameScreen.getMyKeyListener());
            setFocusable(true);
            requestFocus();
        });
        menuScreen.add(playButton);
        this.add(menuScreen);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }
}
