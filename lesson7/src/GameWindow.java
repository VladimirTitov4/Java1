
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {

    private static GameWindow game_window;
    private static Image background;
    private static Image catImage;
    private static Image plateImage;
    private static Image feedImage;
    private static float ovalRight = 0;
    private static float ovalLeft = 0;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("back.jpg"));
        catImage = ImageIO.read(GameWindow.class.getResourceAsStream("11.png"));
        plateImage = ImageIO.read(GameWindow.class.getResourceAsStream("plate.png"));
        feedImage = ImageIO.read(GameWindow.class.getResourceAsStream("feed.png"));


        game_window = new GameWindow();
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game_window.setLocation(200, 100);
        game_window.setSize(800, 600);
        game_window.setResizable(false);

        GameField game_field = new GameField();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();


            }
        });
        game_window.add(game_field);
        game_window.setVisible(true);
    }

    private static void onRepaint(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(catImage, 50, 50, null);
        g.drawImage(catImage, 50, 350, null);
        g.drawImage(catImage, 570, 50, null);
        g.drawImage(catImage, 570, 350, null);
        g.drawImage(plateImage, 335, 230, null);
        g.drawImage(feedImage, 500, 230, null);
        g.setColor(Color.white);
        g.drawRect(85, 210, 100, 20);
        g.drawRect(110, 510, 45, 20);
        g.drawRect(632, 210, 40, 20);
        g.drawRect(620, 510, 75, 20);
        g.setColor(Color.green);
        g.drawOval(260,450,75,75);
        g.fillOval(260,450,75,75);
        g.setColor(Color.yellow);
        g.drawOval(360,450,75,75);
        g.fillOval(360,450,75,75);
        g.setColor(Color.red);
        g.drawOval(460,450,75,75);
        g.fillOval(460,450,75,75);
        g.setColor(Color.black);
        Font font = new Font("Verdana", Font.PLAIN, 20);
        g.setFont(font);
        g.drawString("Feed", 272, 493);
        g.drawString("Add", 375, 493);
        g.drawString("Reset", 470, 493);

    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();
            text();
        }
    }

    public static void text() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel htmlPanel = new JPanel();
        String text = "<html><h3>Feed</h3></html>";
        Font font = new Font("Verdana", Font.PLAIN, 12);
        JLabel htmlLabel = new JLabel();
        htmlLabel.setText(text);
        htmlLabel.setFont(font);
        htmlPanel.add(htmlLabel);

        mainPanel.add(htmlPanel, BorderLayout.SOUTH);
    }
}
