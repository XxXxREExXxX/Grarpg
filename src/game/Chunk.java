package game;

/**
 *
 * @author voice
 */
public class Chunk {
    public Tile[][] tiles;
    public int chunkWidth;   //Number of Tiles in Map Horizontally
    public int chunkHeight;  //Number of Tiles in Map Vertically
    public Entity[][] entities;
    public Chunk(int chunkWidth, int chunkHeight){
        this.chunkWidth = chunkWidth;
        this.chunkHeight = chunkHeight;
        tiles =  new Tile[chunkWidth][chunkHeight];
        entities = new Entity[chunkWidth][chunkHeight];
        int currentXPOS = 0;
        int currentYPOS = 0;
        for (Tile[] tiles2 : tiles){
            for (int currentX = 0; currentX < tiles2.length; currentX++){
                tiles2[currentX] = new Tile("images/defaultTile.png", currentXPOS, currentYPOS);
                currentXPOS++;
            }
            currentXPOS = 0;
            currentYPOS++;
        }
    }
    public Chunk(Tile[][] tiles){
        entities = new Entity[8][8];
        this.tiles = new Tile[tiles.length][tiles[0].length];
        for (int i = 0; i < tiles.length; i++){
            for (int b = 0; b < tiles[0].length; b++){
                this.tiles[i][b] = tiles[i][b];
                System.out.print(tiles[i][b].imagePath.substring(6, 9));
            }
            System.out.println();
        }
        System.out.println();
        chunkWidth = tiles[0].length;
        chunkHeight = tiles.length;
    }
    
    // Communication Entity <-> Chunk.
    public void updateLoc(Entity e, int xDif, int yDif){
        if (e.getXPOS() + xDif < entities[0].length
                && e.getYPOS() + yDif < entities.length
                && e.getXPOS() + xDif >= 0
                && e.getYPOS() + yDif >= 0){
                if (entities[e.getYPOS()+yDif][e.getXPOS()+xDif] == null) {
                    entities[e.getYPOS()][e.getXPOS()] = null;
                    entities[e.getYPOS()+yDif][e.getXPOS()+xDif] = e;
                    e.setXPOS(e.getXPOS()+xDif);
                    e.setYPOS(e.getYPOS()+yDif);
                }
        } 
    }
}
