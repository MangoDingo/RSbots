package karle.mark.flax;

import karle.mark.all.BankOpener;
import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class BowstringRunner extends Task {

	public BowstringRunner(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.inventory.select().count() == 28
				&& !ctx.inventory.id(Flax.flaxID).isEmpty();
	}

	@Override
	public void execute() {
		System.out.println("BowstringRunner");
		BankOpener.deactivate();
		if(!Flax.bowstringArea.contains(ctx.players.local())){
			if(Flax.bowstringArea.contains(ctx.objects.select().id(Flax.bowstringDoorClosedId).poll())){
				GameObject door = ctx.objects.nearest().poll();
				door.interact("Open");
				Condition.sleep(1000);
			}
			Tile bowstring = Flax.bowstringArea.getRandomTile();
			ctx.movement.step(bowstring);
			ctx.camera.turnTo(bowstring);
		}
		else{
			ctx.objects.select().id(Flax.bowstringLadderUpID);
			GameObject ladder = ctx.objects.nearest().poll();
			ladder.interact("Climb");
		}
		Condition.sleep(1000);
	}

}
