package karle.mark.essence;

import karle.mark.all.Task;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Miner extends Task {
	private int essenceID = 14912;
	private int boundaryID = 1440;
	public Miner(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() != 28
				&& ctx.players.local().animation() == -1
				&& ctx.objects.select().id(boundaryID).nearest().poll().inViewport()
				&& !ctx.objects.select().id(essenceID).isEmpty();
	}

	@Override
	public void execute() {

		System.out.println("Miner");
		ctx.objects.select().id(essenceID);
		GameObject essence = ctx.objects.nearest().poll();
		if(essence.inViewport()){
			essence.interact("Mine");
		}else{
			ctx.movement.step(essence);
			ctx.camera.turnTo(essence);
		}
		Condition.sleep(1000);
	}

}
