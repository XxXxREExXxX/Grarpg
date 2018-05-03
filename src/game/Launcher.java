package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Launcher {
    public static void main(String[] args){
        //Load All Images and pass them to Applet
        //TODO: Scan for images instead of hard-coding.
        String[] imagePaths = {
            "images/GoodGuy.png",
            "images/BadGuy.png",
            "images/defaultTile.png",
            "images/waterTile.png",
            "images/mountainTile.png"
        };
        String s = "" + new File("").getAbsolutePath().replace('\\', '/') + "/src/";
        for (String path : imagePaths){
            System.out.println(s + path);
        }
        HashMap<String, Image> images = new HashMap<>();
        for (String path : imagePaths){
            try {
                images.put(path, ImageIO.read(new File(s + path)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        Game g = new Game();
        g.passImages(images);
        
        //Fire Up applet using Hybrid.java
        Hybrid.fireup(g, "REEE", 584, 384);
        
    }
}