import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static ArrayList<tile> piece = new ArrayList<tile>();

    public static void main(String[] args) {
        gui one = new gui();

        Scanner scanner = new Scanner(System.in);
        String input;

        for (int i = 0; i < 16; i++) {
            piece.add(new tile(i));

        }

        createTile();
        createTile();

        one.printGui();
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
            } else if (input.equals("quit")) {
                scanner.close();
                System.exit(0);
            }

            one.printGui();
            try {
                Thread.sleep(500); // 1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            createTile();

            print();
            one.printGui();

            for (int j = 0; j < 16; j++) {
                piece.get(j).hasMerged = false;
            }
        }

    }

    public static void moveleft() {
        int row = 3;
        int k = 3;

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 10; i++) { // no idea how many times this loop has to run
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

    public static void createTile() {
        boolean done = false;
        int rando = 0;
        Random rand = new Random();
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
