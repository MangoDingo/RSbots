package karle.mark.woodcutting;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;


public class TreeRunner extends Task{
    private int[] treeIDs = {11756};

    public TreeRunner(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().count() != 28 &&
                ctx.objects.select().id(treeIDs).isEmpty();
    }

    @Override
    public void execute() {
        Random rng = new Random();
        Tile treesTile = new Tile(rng.nextInt(3085, 3233), rng.nextInt(3090, 3238));
        ctx.movement.step(treesTile);
        Condition.sleep(3000);
    }
}