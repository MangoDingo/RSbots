package karle.mark.fishing;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;

public class Fish extends Task{
	private int fishID = 1525;
	public Fish(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() != 28
				&&ctx.players.local().animation() == -1;
	}

	@Override
	public void execute() {
		System.out.println("Fish");
		ctx.npcs.select().id(fishID);
		Npc spot = ctx.npcs.nearest().poll();
		if(spot.inViewport()){
			spot.interact("Bait");
		}else{
			ctx.movement.step(spot);
			ctx.camera.turnTo(spot);
		}
		Condition.sleep(1000);
	}

}
