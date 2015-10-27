package karle.mark.flax;

import karle.mark.all.BankOpener;
import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;

public class Bowstringer extends Task {

	public Bowstringer(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return  ctx.inventory.select().count() == 28
				&& !ctx.inventory.select().id(Flax.flaxID).isEmpty()
				&& ctx.players.local().animation() == -1
				&& !ctx.objects.select().id(Flax.spinningWheelID).isEmpty();
	}

	@Override
	public void execute() {
		System.out.println("Bowstringer");
		if(ctx.menu.opened()){
			ctx.menu.close();
		}
		while(!ctx.inventory.select().id(Flax.flaxID).isEmpty()){
			if(ctx.players.local().animation() == -1){
				if(ctx.menu.opened()){
					ctx.menu.close();
				}
			Item flax = ctx.inventory.select().id(Flax.flaxID).poll();
			flax.interact("Use");
			Condition.sleep(200);
			ctx.objects.select().id(Flax.spinningWheelID).poll().click();
			Condition.sleep(1000);
			}
		}
			ctx.objects.select().id(Flax.bowstringLadderDownID);
			GameObject ladder = ctx.objects.nearest().poll();
			ladder.interact("Climb");
			Condition.sleep(2000);
			BankOpener.setActive();
		
	}

}
