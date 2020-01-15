
import java.util.Random;

public class tile {

    String tileVal;
    int tileInt;
    int tileNum;
    int position;
    Random rando = new Random();

    public tile(int num) {
        this.tileNum = num + 1;
        this.tileInt = 0;
    }

    public String gettileVal() {
        return tileVal;
    }

    public int gettileNum() {
        return tileNum;
    }

    public void update() {
        if (tileInt == 0) {
            if (rando.nextInt(10) + 1 > 9) {
                tileInt = 4;
            } else {
                tileInt = 2;
            }

        } else {
            tileInt = tileInt * 2;
        }

    }

    public void update(int value) {
        tileInt = value;

    }

    public String toString() {
        tileVal = Integer.toString(tileInt);
        return tileVal;
    }

}