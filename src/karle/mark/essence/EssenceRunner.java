package karle.mark.essence;

import karle.mark.all.Task;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class EssenceRunner extends Task{
	private Area essenceArea = new Area(new Tile(7000, 5800), new Tile (13000, 10000));
	private Area aubreyArea = new Area(new Tile(3252, 3404), new Tile(3253, 3400));
	private int aubreyID = 637;
	private int boundaryID = 1440;
	public EssenceRunner(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() != 28
				&& ctx.objects.select().id(boundaryID).isEmpty();
	}

	@Override
	public void execute() {
		//find aubrey
		System.out.println("EssenceRunner");
		Tile aubreyTile = new Tile(Random.nextInt(3252, 3253), Random.nextInt(3400, 3404));
        ctx.movement.step(aubreyTile);
        Condition.sleep(5000);
        if(aubreyArea.contains(ctx.players.local())){
        	ctx.npcs.select().id(aubreyID);
        	Npc aubrey = ctx.npcs.nearest().poll();
        	if (aubrey.inViewport()){
        		aubrey.interact("Teleport");
        	}
        	else{
        		ctx.movement.step(aubrey);
        		ctx.camera.turnTo(aubrey);
        	}
        }
        Condition.sleep(1000);
	}

}
