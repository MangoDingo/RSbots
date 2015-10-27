package karle.mark.fishing;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;

import karle.mark.all.Task;

public class FishRunner extends Task{
	private int fishID = 1525;

    public FishRunner(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() != 28 &&
                ctx.npcs.select().id(fishID).isEmpty();
    }

    @Override
    public void execute() {
    	System.out.println("FishRunner");
        Tile fishTile = new Tile(Random.nextInt(3088, 3229), Random.nextInt(3090, 3238));
        ctx.movement.step(fishTile);
        Condition.sleep(3000);
    }
}
