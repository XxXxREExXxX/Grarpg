package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Launcher {
    public static void main(String[] args){
        //Load All Images and pass them to Applet
        //TODO: Scan for images instead of hard-coding.
        String[] imagePaths = {
            "images/GoodGuy.png",
            "images/BadGuy.png",
            "images/defaultTile.png",
            "images/defaultTileR90.png",
            "images/waterTile.png",
            "images/waterTileF1.5.png",
            "images/waterTileF2.png",
            "images/mountainTile.png",
            "images/wallTile.png",
            "images/entranceTile.png",
            "images/treasureTile.png",
            "images/blackTile.png",
            "images/brickTile.png",
            "images/deafCreep.png",
            "images/deafCreepBroken.png",
            "images/fireSkeleton.png",
            "images/fireSkeleton2.png",
            "images/bileZombie.png",
            "images/liarZombie.png",
            "images/boomZombie.png",
            "images/axeZombie.png",
            "images/TEST_GIF.gif",
            "images/darkTransparent.png",
            "images/defaultNPC.png"
        };
        String[] cscImagePaths = new String[]{
            "cscimages/slashcsc1.png",
            "cscimages/slashcsc2.png",
            "cscimages/slashcsc3.png",
            "cscimages/slashcsc4.png",
            "cscimages/slashcsc5.png",
            "cscimages/slashcsc6.png",
            "cscimages/slashcsc7.png",
            "cscimages/slashcsc8.png",
            "cscimages/slashcsc9.png",
            "cscimages/slashcsc10.png",
            "cscimages/slashcsc11.png",
            "cscimages/slashcsc12.png",
            "cscimages/slashcsc13.png",
            "cscimages/slashcsc14.png",
        };
        String s = "" + new File("").getAbsolutePath().replace('\\', '/') + "/src/";
        for (String path : imagePaths){
            //System.out.println(s + path);
        }
        HashMap<String, Image> images = new HashMap<>();
        for (String path : imagePaths){
            try {
                images.put(path, ImageIO.read(new File(s + path)));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        HashMap<String, Image> cscImages = new HashMap<>();
        for (String path: cscImagePaths){
            try {
                cscImages.put(path, ImageIO.read(new File(s + path)));
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        Game g = new Game();
        g.passImages(images);
        g.passCSCImages(cscImages);
        
        //Fire Up applet using Hybrid.java
        Hybrid.fireup(g, "REEE", 584, 384);
        
    }
}
