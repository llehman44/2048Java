import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class game {

    public static ArrayList<tile> piece = new ArrayList<tile>(9);
    public static boolean debug;
    public static JLabel[] tiles = new JLabel[16];
    public static gui one = new gui();

    public static void main(String[] args) {

        Font font = new Font("Courier", Font.BOLD, 40);
        JLabel item1 = new JLabel("2048");
        item1.setFont(font);
        item1.setForeground(Color.WHITE);

        for (int i = 0; i < 16; i++) {
            tiles[i] = new JLabel();
        }
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                one.add(item1);
            } else {
                one.add(new JLabel());
            }
        }

        one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        one.setSize(410, 540);
        one.getContentPane().setBackground(new Color(26, 26, 26));

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String input;
        debug = false;
        int rando = 0;
        for (int i = 0; i < 16; i++) {
            piece.add(new tile(i));

        }
        if (debug) {
            createTest();

        } else {
            createTile(rand, rando);
            createTile(rand, rando);
        }
        printGui();
        print();
        one.setVisible(true);
        for (;;) {
            input = scanner.nextLine();
            if (input.equals("a")) {
                moveleft();
                combineleft();
            }

            else if (input.equals("d")) {
                moveRight();
                combineRight();
            }

            else if (input.equals("w")) {
                moveUp();
                combineUp();
            }

            else if (input.equals("s")) {
                moveDown();
                combineDown();
            }

            if (!debug) {
                createTile(rand, rando);
            }

            for (int j = 0; j < 16; j++) {
                piece.get(j).hasMerged = false;
            }
            print();
            printGui();
        }

    }

    public static void printGui() {
        ImageIcon myPicture = new ImageIcon();
        for (int i = 0; i < 16; i++) {

            switch (piece.get(i).tileInt) {
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


            one.add(tiles[i]);
        }

    }

    public static void moveleft() {
        // move tiles all left
        int row = 3;
        int k = 3;

        boolean done = false;
        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 10; i++) { // no idea how many times this loop has to run but it works
                if (row < k - 2) {
                    row = k;
                }
                if (piece.get(row).tileInt != 0 && piece.get(row - 1).tileInt == 0) {
                    piece.get(row - 1).tileInt = piece.get(row).tileInt;
                    piece.get(row).tileInt = 0;

                }
                row--;
            }
            k = k + 4;
            row = k;
        }

    }

    public static void moveRight() {

        int row = 0;
        int k = 0;

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 20; i++) {
                if (row > k + 2) {
                    row = k;
                }
                if (piece.get(row).tileInt != 0 && piece.get(row + 1).tileInt == 0) {
                    piece.get(row + 1).tileInt = piece.get(row).tileInt;
                    piece.get(row).tileInt = 0;

                }
                row++;
            }
            k = k + 4;
            row = k;
        }
    }

    public static void moveUp() {

        int row = 12;
        int k = 12;

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 20; i++) {
                if (row < k - 8) {
                    row = k;
                }
                if (piece.get(row).tileInt != 0 && piece.get(row - 4).tileInt == 0) {
                    piece.get(row - 4).tileInt = piece.get(row).tileInt;
                    piece.get(row).tileInt = 0;

                }
                row = row - 4;
            }
            k = k + 1;
            row = k;
        }
    }

    public static void moveDown() {

        int row = 0;
        int k = 0;

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 20; i++) {
                if (row > k + 8) {
                    row = k;
                }
                if (piece.get(row).tileInt != 0 && piece.get(row + 4).tileInt == 0) {
                    piece.get(row + 4).tileInt = piece.get(row).tileInt;
                    piece.get(row).tileInt = 0;

                }
                row = row + 4;
            }
            k = k + 1;
            row = k;
        }
    }

    public static void combineleft() {
        int row = 3;
        int k = 3;
        boolean done = false;
        for (int j = 0; j < 4; j++) {
            while (row > k - 3) {
                if (piece.get(row).hasMerged == false) {
                    if (piece.get(row).tileInt == piece.get(row - 1).tileInt && piece.get(row).tileInt > 0) {
                        piece.get(row - 1).update();
                        piece.get(row).tileInt = 0;
                    }

                } else {

                }

                row--;
            }
            k = k + 4;
            row = k;
        }
        moveleft();
    }

    public static void combineRight() {
        int row = 0;
        int k = 0;

        for (int j = 0; j < 4; j++) {
            while (row < k + 3) {

                if (piece.get(row).hasMerged == false) {
                    if (piece.get(row).tileInt == piece.get(row + 1).tileInt && piece.get(row).tileInt > 0) {
                        piece.get(row + 1).update();
                        piece.get(row).tileInt = 0;

                    }

                } else {

                }

                row++;
            }
            k = k + 4;
            row = k;
        }
        moveRight();

    }

    public static void combineUp() {
        int row = 12;
        int k = 12;

        for (int j = 0; j < 4; j++) {
            while (row > k - 9) {

                if (piece.get(row).hasMerged == false) {
                    if (piece.get(row).tileInt == piece.get(row - 4).tileInt && piece.get(row).tileInt > 0) {
                        piece.get(row - 4).update();
                        piece.get(row).tileInt = 0;

                    }

                } else {

                }

                row = row - 4;
            }
            k = k + 1;
            row = k;
        }
        moveUp();

    }

    public static void combineDown() {
        int row = 0;
        int k = 0;

        for (int j = 0; j < 4; j++) {
            while (row < k + 9) {

                if (piece.get(row).hasMerged == false) {
                    if (piece.get(row).tileInt == piece.get(row + 4).tileInt && piece.get(row).tileInt > 0) {
                        piece.get(row + 4).update();
                        piece.get(row).tileInt = 0;

                    }

                } else {

                }

                row = row + 4;
            }
            k = k + 1;
            row = k;
        }
        moveDown();

    }

    public static void createTile(Random rand, int rando) {
        boolean done = false;
        rando = rand.nextInt(15);

        while (!done) {
            if (piece.get(rando).isUsed() == false) {
                piece.get(rando).update();
                done = true;
            } else {
                rando = rand.nextInt(15);
            }
        }
    }

    public static void createTest() {

        piece.get(12).update(2);
        piece.get(8).update(2);
        piece.get(13).update(2);
        piece.get(9).update(2);
        piece.get(4).update(16);

    }

    public static void print() {
        System.out.println('\n');

        for (int i = 0; i < 16; i++) {
            System.out.printf("%s   ", piece.get(i));
            if ((i + 1) % 4 == 0 && i != 15) {
                System.out.println("\n");
            }
        }
        System.out.println('\n');
    }

}
