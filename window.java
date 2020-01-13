import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class window extends JFrame implements KeyListener  {

    Font font = new Font("Courier", Font.BOLD, 45);
    JLabel item1 = new JLabel("2048");
    JPanel gameWindow = new JPanel();
    JPanel title = new JPanel();
    JPanel options = new JPanel();
    JButton three = new JButton();
    JButton four = new JButton();
    JButton five = new JButton();
    ImageIcon tile0 = new ImageIcon("tiles/0.jpg");
    ImageIcon tile2 = new ImageIcon("tiles/2.jpg");
    ImageIcon tile4 = new ImageIcon("tiles/4.jpg");
    ImageIcon tile8 = new ImageIcon("tiles/8.jpg");
    ImageIcon tile16 = new ImageIcon("tiles/16.jpg");
    ImageIcon tile32 = new ImageIcon("tiles/32.jpg");
    ImageIcon tile64 = new ImageIcon("tiles/64.jpg");
    ImageIcon tile128 = new ImageIcon("tiles/128.jpg");
    ImageIcon tile256 = new ImageIcon("tiles/256.jpg");
    ImageIcon tile512 = new ImageIcon("tiles/512.jpg");
    ImageIcon tile1024 = new ImageIcon("tiles/1024.jpg");
    ImageIcon tile2048 = new ImageIcon("tiles/2048.jpg");

    static JLabel[] tiles = new JLabel[game.gameSize * game.gameSize];

    public window() {

        super("2048");
        addKeyListener(this);
        setFocusable(true);
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
            gameWindow.add(tiles[i]);

        }
        gameWindow.validate();
        gameWindow.setVisible(true);

        add(title, BorderLayout.PAGE_START);
        add(gameWindow, BorderLayout.CENTER);
        add(options, BorderLayout.PAGE_END);
        gameWindow.setFocusTraversalKeysEnabled(false);
        gameWindow.addKeyListener(this);
        this.setVisible(true);

    }

    public void printGui() {

        for (int i = 0; i < (game.gameSize * game.gameSize); i++) {

            switch (game.piece.get(i).tileInt) {
            case 0:
                tiles[i].setIcon(tile0);
                break;
            case 2:
                tiles[i].setIcon(tile2);
                break;
            case 4:
                tiles[i].setIcon(tile4);
                break;
            case 8:
                tiles[i].setIcon(tile8);
                break;
            case 16:
                tiles[i].setIcon(tile16);
                break;
            case 32:
                tiles[i].setIcon(tile32);
                break;
            case 64:
                tiles[i].setIcon(tile64);
                break;
            case 128:
                tiles[i].setIcon(tile128);
                break;
            case 256:
                tiles[i].setIcon(tile256);
                break;
            case 512:
                tiles[i].setIcon(tile512);
                break;
            case 1024:
                tiles[i].setIcon(tile1024);
                break;
            case 2048:
                tiles[i].setIcon(tile2048);
                break;
            }
         

        }

        gameWindow.validate();
        gameWindow.repaint();
    }

 

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if(KeyCode == KeyEvent.VK_LEFT) {
            game.moveleft();
            game.combineleft();
            game.moveleft();
            printGui();
            timer.setRepeats(false);
            timer.start();
        }
        else if(KeyCode == KeyEvent.VK_RIGHT){
            game.moveRight();
            game.combineRight();
            game.moveRight();
            printGui();
            timer.setRepeats(false);
            timer.start();
        }
        else if(KeyCode == KeyEvent.VK_UP){
            game.moveUp();
            game.combineUp();
            game.moveUp();
            printGui();
            timer.setRepeats(false);
            timer.start();
        }
        else if(KeyCode == KeyEvent.VK_DOWN){
            game.moveDown();
            game.combineDown();
            game.moveDown();
            printGui();
            timer.setRepeats(false);
            timer.start();
        }
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    Timer timer = new Timer(500, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.createTile();
            printGui();
            game.print();
        }
    });
}