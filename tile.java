

public class tile {

    String tileVal;
    int tileInt;
    int tileNum;
    int position;
    boolean used;
    boolean hasMerged;
    

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
        if (tileInt == 0){
            tileInt = 2;
        }
        else{
            hasMerged = true;
            tileInt = tileInt *2;
        }
    }

    public void update(int value) {
        tileInt = value;
    }

    public String toString(){
        tileVal = Integer.toString(tileInt);
        return tileVal;
    }
    
    public boolean isUsed(){
        if(tileInt > 0){
            used = true;
        }
        else{
            used = false;
        }
        return used;
    }

}