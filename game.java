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

    }

    public static void createTest() {
        // piece.get(0).update(2);          //used to add specific tiles to board if debug boolean is true
        // piece.get(1).update(2);
        // piece.get(3).update(4);
        // piece.get(4).update(4);
    }

    public static void moveleft() {
        int tile = gameSize - (gameSize - 1); // 1
        int row = gameSize - (gameSize - 1);

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize; x++) {

                for (int y = 0; y < gameSize; y++) {
                    if (tile == row + (gameSize - 1)) { // == 4
                        break;
                    } else if (piece.get(tile).tileInt != 0 && piece.get(tile - 1).tileInt == 0) {
                        piece.get(tile - 1).tileInt = piece.get(tile).tileInt;
                        piece.get(tile).tileInt = 0;
                    }
                    tile++;
                }
                tile = row;
            }
            row += gameSize;
            tile = row;
        }

    }

    public static void moveRight() {
        int tile = gameSize - 2; // 2
        int row = gameSize - 2;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize; x++) {

                for (int y = 0; y < gameSize; y++) {
                    if (tile == row - (gameSize - 1)) {
                        break;
                    } else if (piece.get(tile).tileInt != 0 && piece.get(tile + 1).tileInt == 0) {
                        piece.get(tile + 1).tileInt = piece.get(tile).tileInt;
                        piece.get(tile).tileInt = 0;
                    }
                    tile--;

                }
                tile = row;
            }
            row += gameSize;
            tile = row;
        }
    }

    public static void moveUp() {

        int tile = gameSize; // 4
        int row = gameSize;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize; x++) {

                for (int y = 0; y < gameSize; y++) {
                    if (tile == row + (gameSize * (gameSize - 1))) { // 5 to 25 4 to 16
                        break;
                    }

                    else if (piece.get(tile).tileInt != 0 && piece.get(tile - gameSize).tileInt == 0) {
                        piece.get(tile - gameSize).tileInt = piece.get(tile).tileInt;
                        piece.get(tile).tileInt = 0;
                      
                    }
                    tile += gameSize;

                }
                tile = row;
            }
            row++;
            tile = row;
        }
    }

    public static void moveDown() {

        int tile = gameSize * (gameSize - 2);
        int row = gameSize * (gameSize - 2);

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize; x++) {

                for (int y = 0; y < gameSize; y++) {
                    if (tile < 0) { // 8 to 0, 9 to 1 /// 15 to 0, 16 to 1
                        break;
                    }

                    else if (piece.get(tile).tileInt != 0 && piece.get(tile + gameSize).tileInt == 0) {
                        piece.get(tile + gameSize).tileInt = piece.get(tile).tileInt;
                        piece.get(tile).tileInt = 0;

                    }
                    tile -= gameSize;

                }
                tile = row;
            }
            row++;
            tile = row;
        }
    }

    public static void combineleft() {
        int tile = 0; 
        int row =  0;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if(piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile + 1).tileInt){
                    piece.get(tile).update();
                    piece.get(tile + 1).tileInt = 0;
                }
                tile++;
            }
            row += gameSize;
            tile = row;
        }
    }

    public static void combineRight() {
        int tile = gameSize - 1; 
        int row =  gameSize - 1; 

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if(piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile - 1).tileInt){
                    piece.get(tile).update();
                    piece.get(tile - 1).tileInt = 0;
                }
                tile--;
            }
            row += gameSize;
            tile = row;
        }
    }

    public static void combineUp() {
        int tile = 0; 
        int row =  0;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if(piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile + gameSize).tileInt){
                    piece.get(tile).update();
                    piece.get(tile + gameSize).tileInt = 0;
                }
                tile += gameSize;
            }
            row++;
            tile = row;
        }
    }

    public static void combineDown() {
        int tile = gameSize * (gameSize -1); 
        int row =  gameSize * (gameSize -1); 

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if(piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile - gameSize).tileInt){
                    piece.get(tile).update();
                    piece.get(tile - gameSize).tileInt = 0;
                }
                tile -= gameSize;
            }
            row++;
            tile = row;
        }

    }

    public static void createTile() {
        boolean done = false;
        int rando = 0;
        Random rand = new Random();
        rando = rand.nextInt((gameSize * gameSize) - 1);
        while (!done) {
            if (piece.get(rando).isUsed() == false) {
                piece.get(rando).update();
                done = true;
            } else {
                rando = rand.nextInt((gameSize * gameSize) - 1);
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
