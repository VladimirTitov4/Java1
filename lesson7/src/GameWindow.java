
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
    private static Image addImage;
    private static Image resetImage;
    private static float feedRight = 0;
    private static float feedBottom = 0;
    private static float addRight = 0;
    private static float resetRight = 0;
    private static int feedImageX = 260;
    private static int addImageX = 360;
    private static int resetImageX = 460;
    private static int imageY = 450;
    private static Plate plate = new Plate(0);
    private static Cat[] catsArray = Lesson7.getCats();

    public static void main(String[] args) throws IOException {

        background = ImageIO.read(GameWindow.class.getResourceAsStream("back.jpg"));
        catImage = ImageIO.read(GameWindow.class.getResourceAsStream("11.png"));
        plateImage = ImageIO.read(GameWindow.class.getResourceAsStream("plate.png"));
        feedImage = ImageIO.read(GameWindow.class.getResourceAsStream("feed.png"));
        addImage = ImageIO.read(GameWindow.class.getResourceAsStream("add.png"));
        resetImage = ImageIO.read(GameWindow.class.getResourceAsStream("reset.png"));

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
                feedRight = feedImageX + feedImage.getWidth(null);
                feedBottom = imageY + feedImage.getHeight(null);
                boolean isFeed = x >= feedImageX && x <= feedRight && y >= imageY && y <= feedBottom;
                for (Cat cat : catsArray) {
                    if (isFeed && !cat.isFull()) {
                        if (plate.getFood() > cat.getAppetite()) {
                            cat.eat(plate);
                        }
                        game_field.repaint();
                    }
                }
            }
        });

        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                addRight = addImageX + feedImage.getWidth(null);
                feedBottom = imageY + feedImage.getHeight(null);
                boolean isAdd = x >= addImageX && x <= addRight && y >= imageY && y <= feedBottom;
                if (isAdd) {
                    plate.increaseFood();
                    game_field.repaint();
                }
            }
        });

        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                resetRight = resetImageX + feedImage.getWidth(null);
                feedBottom = imageY + feedImage.getHeight(null);
                boolean isReset = x >= resetImageX && x <= resetRight && y >= imageY && y <= feedBottom;
                if (isReset) {
                    plate.setFood(100);

                    for (Cat cat : catsArray) {
                        cat.resetAppetite();
                    }

                    game_field.repaint();
                }
            }
        });

        game_window.add(game_field);
        game_window.setVisible(true);
    }

    private static void paintBaseObjects(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(catImage, 50, 50, null);
        g.drawImage(catImage, 50, 350, null);
        g.drawImage(catImage, 570, 50, null);
        g.drawImage(catImage, 570, 350, null);
        g.drawImage(plateImage, 335, 230, null);
        g.drawImage(feedImage, feedImageX, imageY, null);
        g.drawImage(addImage, addImageX, imageY, null);
        g.drawImage(resetImage, resetImageX, imageY, null);
        g.setColor(Color.white);

        for (Cat cat : catsArray) {
            g.drawRect(cat.xRect, cat.yRect, cat.getAppetite()*10, 20);
        }
    }

    private static class GameField extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            paintBaseObjects(g);
            plate.paint(g);

            for (Cat cat : catsArray) {
                if (cat.isFull()) cat.paint(g);
            }

            repaint();
        }
    }
}

class Lesson7 {
    public static Cat[] getCats() {
        return new Cat[]{
                new Cat("Cat1", 10, 85, 210),
                new Cat("Cat2", 4, 110, 510),
                new Cat("Cat3", 5, 632, 210),
                new Cat("Cat4", 7, 620, 510)
        };
    }
}

