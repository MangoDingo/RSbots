package karle.mark.fighter;

import karle.mark.all.Task;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GroundItem;

public class BonePickup extends Task {

	public BonePickup(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.groundItems.select().id(Fighter.boneID).nearest().poll().inViewport()
				&& !ctx.players.local().inCombat()
				&& ctx.inventory.select().count() != 28;
				
	}

	@Override
	public void execute() {
		System.out.println("BonePickup");
		while(ctx.groundItems.select().id(Fighter.boneID).nearest().poll().inViewport()){
			GroundItem bone = ctx.groundItems.nearest().poll();
			bone.interact("Take");
			Condition.sleep(1000);
		}
	}

}
