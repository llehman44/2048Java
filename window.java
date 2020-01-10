import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class window extends JFrame {
    Font font = new Font("Courier", Font.BOLD, 45);
    JLabel item1 = new JLabel("2048");
    JPanel gameWindow = new JPanel();
    JPanel title = new JPanel();
    JPanel options = new JPanel();
    JButton three = new JButton();
    JButton four = new JButton();
    JButton five = new JButton();

    static JLabel[] tiles = new JLabel[game.gameSize * game.gameSize];

    public window() {

        super("2048");

        this.setAlwaysOnTop(true);
        this.setResizable(true);
        if (game.gameSize == 4) {
            this.setSize(410, 560);
        } else if (game.gameSize == 5) {
            this.setSize(510, 660);
        } 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setLayout(new BorderLayout());
        // this.setResizable(false);

        three.setPreferredSize(new Dimension(126, 70));
        four.setPreferredSize(new Dimension(126, 70));
        five.setPreferredSize(new Dimension(126, 70));

        item1.setFont(font);
        item1.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(410, 70)); // TITLE DIMENSION

        title.setBackground(new Color(26, 26, 26));

        title.add(item1);
        title.validate();

        options.add(three);
        options.add(four);
        options.add(five);

        options.setPreferredSize(new Dimension(410, 70)); // OPTIONS
        options.setBackground(new Color(26, 26, 26));

        if (game.gameSize == 4) {
            gameWindow.setPreferredSize(new Dimension(410, 420));
            gameWindow.setLayout(new GridLayout(0, 4)); // GAMEWINDOW SIZE
        } else if (game.gameSize == 5) {
            gameWindow.setSize(510, 520);
            gameWindow.setLayout(new GridLayout(0, 5));
        }

        gameWindow.setBackground(new Color(26, 26, 26));
        for (int i = 0; i < (game.gameSize * game.gameSize); i++) {
            tiles[i] = new JLabel();

        }
        gameWindow.validate();
        gameWindow.setVisible(true);

        add(title, BorderLayout.PAGE_START);
        add(gameWindow, BorderLayout.CENTER);
        add(options, BorderLayout.PAGE_END);
        this.setVisible(true);

    }

    public void printGui() {

        ImageIcon myPicture = new ImageIcon();
        for (int i = 0; i < (game.gameSize * game.gameSize); i++) {

            switch (game.piece.get(i).tileInt) {
            case 0:
                myPicture = new ImageIcon("tiles/0.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 2:
                myPicture = new ImageIcon("tiles/2.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 4:
                myPicture = new ImageIcon("tiles/4.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 8:
                myPicture = new ImageIcon("tiles/8.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 16:
                myPicture = new ImageIcon("tiles/16.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 32:
                myPicture = new ImageIcon("tiles/32.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 64:
                myPicture = new ImageIcon("tiles/64.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 128:
                myPicture = new ImageIcon("tiles/128.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 256:
                myPicture = new ImageIcon("tiles/256.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 512:
                myPicture = new ImageIcon("tiles/512.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 1024:
                myPicture = new ImageIcon("tiles/1024.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 2048:
                myPicture = new ImageIcon("tiles/2048.jpg");
                tiles[i].setIcon(myPicture);
                break;
            }
            gameWindow.add(tiles[i]);

        }

        gameWindow.validate();
        gameWindow.repaint();
    }

}