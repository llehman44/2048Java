import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class gui extends JFrame {
    Font font = new Font("Courier", Font.BOLD, 40);
    JLabel item1 = new JLabel("2048");
    static JLabel[] tiles = new JLabel[16];

    public gui() {
        super("2048");
        setLayout(new GridLayout(0, 4));
        setAlwaysOnTop(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 540);
        getContentPane().setBackground(new Color(26, 26, 26));
        item1.setFont(font);
        item1.setForeground(Color.WHITE);

        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                add(item1);
            } else {
                add(new JLabel());
            }
        }

        for (int i = 0; i < 16; i++) {
            tiles[i] = new JLabel();
        }
        repaint();
    }

    public void printGui() {
        ImageIcon myPicture = new ImageIcon();
        for (int i = 0; i < 16; i++) {

            switch (game.piece.get(i).tileInt) {
            case 0:
                myPicture = new ImageIcon("0.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 2:
                myPicture = new ImageIcon("2.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 4:
                myPicture = new ImageIcon("4.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 8:
                myPicture = new ImageIcon("8.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 16:
                myPicture = new ImageIcon("16.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 32:
                myPicture = new ImageIcon("32.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 64:
                myPicture = new ImageIcon("64.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 128:
                myPicture = new ImageIcon("128.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 256:
                myPicture = new ImageIcon("256.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 512:
                myPicture = new ImageIcon("512.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 1024:
                myPicture = new ImageIcon("1024.jpg");
                tiles[i].setIcon(myPicture);
                break;
            case 2048:
                myPicture = new ImageIcon("2048.jpg");
                tiles[i].setIcon(myPicture);
                break;
            }
            add(tiles[i]);
            repaint();

        }
    }
}
