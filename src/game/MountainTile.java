/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author voice
 */
public class MountainTile extends Tile{
    public MountainTile(String s, int x, int y){
        super(s, x, y);
        skillTraverse = "climb";
    }
}
