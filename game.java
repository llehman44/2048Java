import java.util.ArrayList;
import java.util.Random;

public class game {

    public ArrayList<tile> piece = new ArrayList<tile>();
    public int gameSize;

    public game() {
        gameSize = 4;
        for (int i = 0; i < (gameSize * gameSize); i++) {
            piece.add(new tile(i));

        }
        createTile();
        createTile();
    }

    public void moveleft() {
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

    public void moveRight() {
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

    public void moveUp() {

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

    public void moveDown() {

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

    public void combineleft() {
        int tile = 0;
        int row = 0;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if (piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile + 1).tileInt) {
                    piece.get(tile).update();
                    piece.get(tile + 1).tileInt = 0;
                }
                tile++;
            }
            row += gameSize;
            tile = row;
        }
    }

    public void combineRight() {
        int tile = gameSize - 1;
        int row = gameSize - 1;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if (piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile - 1).tileInt) {
                    piece.get(tile).update();
                    piece.get(tile - 1).tileInt = 0;
                }
                tile--;
            }
            row += gameSize;
            tile = row;
        }
    }

    public void combineUp() {
        int tile = 0;
        int row = 0;

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if (piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile + gameSize).tileInt) {
                    piece.get(tile).update();
                    piece.get(tile + gameSize).tileInt = 0;
                }
                tile += gameSize;
            }
            row++;
            tile = row;
        }
    }

    public void combineDown() {
        int tile = gameSize * (gameSize - 1);
        int row = gameSize * (gameSize - 1);

        for (int i = 0; i < gameSize; i++) {
            for (int x = 0; x < gameSize - 1; x++) {
                if (piece.get(tile).tileInt != 0 && piece.get(tile).tileInt == piece.get(tile - gameSize).tileInt) {
                    piece.get(tile).update();
                    piece.get(tile - gameSize).tileInt = 0;
                }
                tile -= gameSize;
            }
            row++;
            tile = row;
        }

    }

    public boolean canMoveLeft() {
        int tile = gameSize - 1;
        int row = gameSize - 1;

        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize - 1; j++) {
                if ((piece.get(tile).tileInt != 0 && piece.get(tile - 1).tileInt == 0)
                        || (piece.get(tile).tileInt == piece.get(tile - 1).tileInt && piece.get(tile).tileInt != 0)) {
                    return true;
                } else {
                    tile--;
                }
            }
            row += gameSize;
            tile = row;
        }
        return false;
    }

    public boolean canMoveRight() {
        int tile = 0;
        int row = 0;

        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize - 1; j++) {

                if ((piece.get(tile).tileInt != 0 && piece.get(tile + 1).tileInt == 0)
                        || (piece.get(tile).tileInt == piece.get(tile + 1).tileInt && piece.get(tile).tileInt != 0)) {
                    return true;
                } else {
                    tile++;
                }
            }
            row += gameSize;
            tile = row;
        }
        return false;
    }

    public boolean canMoveUp() {
        int tile = gameSize * (gameSize - 1);
        int row = gameSize * (gameSize - 1);

        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize - 1; j++) {
                if ((piece.get(tile).tileInt != 0 && piece.get(tile - gameSize).tileInt == 0)
                        || (piece.get(tile).tileInt == piece.get(tile - gameSize).tileInt
                                && piece.get(tile).tileInt != 0)) {
                    return true;
                } else {
                    tile -= gameSize;
                }
            }
            row++;
            tile = row;
        }
        return false;
    }

    public boolean canMoveDown() {
        int tile = 0;
        int row = 0;

        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize - 1; j++) {
                if ((piece.get(tile).tileInt != 0 && piece.get(tile + gameSize).tileInt == 0)
                        || (piece.get(tile).tileInt == piece.get(tile + gameSize).tileInt
                                && piece.get(tile).tileInt != 0)) {
                    return true;
                } else {
                    tile += gameSize;
                }
            }
            row++;
            tile = row;
        }
        return false;
    }

    public void createTile() {
        boolean done = false;
        int rando = 0;
        Random rand = new Random();
        rando = rand.nextInt((gameSize * gameSize) - 1);
        while (!done) {
            if (piece.get(rando).tileInt == 0) {
                piece.get(rando).update();
                done = true;
            } else {
                rando = rand.nextInt((gameSize * gameSize));
            }
        }
    }

    public void print() {
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
