import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class tile extends JLabel {

    int x;
    int y;
    String tileVal;
    int tileInt;
    int tileNum;
    int position;
    boolean used;
    boolean hasMerged;
    

    public tile(int num) {
    
       
        // (max - min + 1) + min
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