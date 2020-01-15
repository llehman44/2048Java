import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class window extends JFrame implements KeyListener {

    Font font = new Font("Courier", Font.BOLD, 45);
    JLabel item1 = new JLabel("2048");
    JPanel gameWindow = new JPanel();
    JPanel title = new JPanel();
    JButton restart = new JButton("RESTART");
    
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

    
    game Game = new game();
    JLabel[] tiles = new JLabel[Game.gameSize * Game.gameSize];

    public window() {

        super("2048");
        addKeyListener(this);
        setFocusable(true);
        this.setAlwaysOnTop(true);
        this.setResizable(true);
        if (Game.gameSize == 4) {
            this.setSize(410, 560);
        } else if (Game.gameSize == 5) {
            this.setSize(510, 660);
        }
        else if (Game.gameSize == 3){
            this.setSize(310, 360);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(0, 0, 0));
        this.setLayout(new BorderLayout());
        // this.setResizable(false);

        

        item1.setFont(font);
        item1.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(410, 70)); // TITLE DIMENSION

        title.setBackground(new Color(26, 26, 26));

        title.add(item1);
        title.validate();

      
        restart.setPreferredSize(new Dimension(410, 70));
        restart.setBackground(new Color(26, 26, 26));
        restart.setFont(new Font("Courier", Font.BOLD, 40));
        restart.setForeground(Color.WHITE);
        restart.setFocusable(false);
        restart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < (Game.gameSize * Game.gameSize); i++){
                    Game.piece.get(i).tileInt = 0;
                }
                Game.createTile();
                Game.createTile();
                printGui();
                System.out.println("###");
            
            }
        });

        if (Game.gameSize == 4) {
            gameWindow.setPreferredSize(new Dimension(410, 420));
            gameWindow.setLayout(new GridLayout(0, 4)); // GAMEWINDOW SIZE
        } else if (Game.gameSize == 5) {
            gameWindow.setSize(510, 520);
            gameWindow.setLayout(new GridLayout(0, 5));
        }

        gameWindow.setBackground(new Color(26, 26, 26));
        for (int i = 0; i < (Game.gameSize * Game.gameSize); i++) {
            tiles[i] = new JLabel();
            gameWindow.add(tiles[i]);

        }
        gameWindow.validate();
        gameWindow.setVisible(true);

        add(title, BorderLayout.PAGE_START);
        add(gameWindow, BorderLayout.CENTER);
        add(restart, BorderLayout.PAGE_END);
        gameWindow.setFocusTraversalKeysEnabled(false);
        gameWindow.addKeyListener(this);
        this.setVisible(true);

    }

    public void printGui() {

        for (int i = 0; i < (Game.gameSize * Game.gameSize); i++) {

            switch (Game.piece.get(i).tileInt) {
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

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int KeyCode = e.getKeyCode();

        if (Game.canMoveLeft() == false && Game.canMoveRight() == false && Game.canMoveUp() == false
                && Game.canMoveDown() == false) {
            System.out.println("GAME OVER");
            System.exit(0);
        } else {
            if (KeyCode == KeyEvent.VK_LEFT) {
                if (Game.canMoveLeft() == true) {
                    Game.moveleft();
                    Game.combineleft();
                    Game.moveleft();
                    printGui();
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    System.out.println("cant move left");
                }

            } else if (KeyCode == KeyEvent.VK_RIGHT) {
                if (Game.canMoveRight() == true) {
                    Game.moveRight();
                    Game.combineRight();
                    Game.moveRight();
                    printGui();
                    timer.setRepeats(false);
                    timer.start();
                } else {

                    System.out.println("cant move right");
                }
            } else if (KeyCode == KeyEvent.VK_UP) {
                if (Game.canMoveUp() == true) {
                    Game.moveUp();
                    Game.combineUp();
                    Game.moveUp();
                    printGui();
                    timer.setRepeats(false);
                    timer.start();
                } else {

                    System.out.println("cant move up");
                }
            } else if (KeyCode == KeyEvent.VK_DOWN) {
                if (Game.canMoveDown() == true) {
                    Game.moveDown();
                    Game.combineDown();
                    Game.moveDown();
                    printGui();
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    System.out.println("cant move down");
                }
            } else if (KeyCode == KeyEvent.VK_SPACE) {

                printGui();
                Game.print();
                timer.setRepeats(false);
                timer.start();
            }
            
          
        }

    }

    Timer timer = new Timer(300, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

           
            Game.createTile();
            printGui();
            Game.print();
        }
    });
}