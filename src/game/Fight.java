package game;

/**
 *
 * @author voice
 */
public class Fight {
    public Entity[] entities;
    private Game g;
    private String[] parseThis;
    double damage = 0;
    String reason = "";
    String target = "";
    boolean turn = true;
    
    public Fight(Game g){this.g=g;}
    
    public void start(Entity[] entities){
        this.entities = entities;
    }
    
    
    /*
    Iterate over entities
        For each entity get its fight command, composed of:
            damage reason target
            double String String
            if target is null target next or previous entity
            iterate over entities
                if entity's name is target name, damage it and print the reason
                
    */
    public void doTick(){
        for (int i = 0; i < entities.length; i++){
            if (turn) 
                if (i == 1) continue;
            if (!turn)
                if (i == 0) continue;
            
            //Current Entity "attacks"
            parseThis = entities[i].doFightTick().trim().split(" ");
            System.out.println(parseThis.length);
            
            if (parseThis.length < 2) continue;
            if (parseThis.length == 2){
                System.out.println("HERE");
                damage = (double) Integer.parseInt(parseThis[0]);
                reason = parseThis[1];
                if (i == 0) target = entities[1].getName();
                else target = entities[i-1].getName();
            } else {
                damage = (double) Integer.parseInt(parseThis[0]);
                reason = parseThis[1];
                target = parseThis[2];
            }
            Boolean succeeded = false;
            for (Entity e : entities){
                if (e.getName().equals(target)){
                    e.setHP(e.getHP()-damage);
                    g.textOutput.append("damaged for " + damage + " " + reason + "\n");
                    succeeded = true;
                }
            }
            if (!succeeded) g.textOutput.append("Missed!");
            
            turn = !turn;
        }
    }
}
