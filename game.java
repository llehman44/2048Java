import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class game {

    public static ArrayList<tile> piece = new ArrayList<tile>();
    public static int gameSize;
    public static boolean debug = false;

    public static void main(String[] args) {
        gameSize = 4;

        window Window = new window();

        Scanner scanner = new Scanner(System.in);
        String input;

        for (int i = 0; i < (gameSize * gameSize); i++) {
            piece.add(new tile(i));

        }

        if (!debug) {
            createTile();
            createTile();
        } else {
            createTest();
        }

        Window.printGui();
        print();

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

            Window.printGui();
            try {
                Thread.sleep(500); // 1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            if (!debug) {
                createTile();
            }

            print();
            Window.printGui();

            for (int j = 0; j < (gameSize * gameSize); j++) {
                piece.get(j).hasMerged = false;
            }
        }

    }

    public static void createTest() {
        piece.get(2).update(2);
        piece.get(3).update(4);
        piece.get(4).update(4);
    }

    public static void moveleft() {
        int row = gameSize - 1;
        int k = gameSize - 1;
        int count = 0;

        for (int j = 0; j < gameSize; j++) {

            for (int i = 0; i < 30; i++) { // no idea how many times this loop has to run
                if (row < k - (gameSize - 2)) {  //does something with how far tile moves
                    row = k;
                    
                }
                if (piece.get(row).tileInt != 0 && piece.get(row - 1).tileInt == 0) {
                    piece.get(row - 1).tileInt = piece.get(row).tileInt;
                    piece.get(row).tileInt = 0;
                    count++;
                    print();
                }
                row--;

            }
            k = k + gameSize;
            row = k;
        }
        System.out.println(count);
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
        int row = gameSize - 1;
        int k = gameSize - 1;

        for (int j = 0; j < gameSize; j++) {
            while (row > k - (gameSize - 1)) {
                if (piece.get(row).hasMerged == false) {
                    if (piece.get(row).tileInt == piece.get(row - 1).tileInt && piece.get(row).tileInt > 0) {
                        piece.get(row - 1).update();
                        piece.get(row).tileInt = 0;
                    }

                } else {

                }

                row--;
            }
            k = k + gameSize;
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

        for (int i = 0; i < (gameSize * gameSize); i++) {
            System.out.printf("%s   ", piece.get(i));
            if ((i + 1) % gameSize == 0 && i != (gameSize * gameSize) - 1) {
                System.out.println("\n");
            }
        }
        System.out.println('\n');
    }

}
